package br.dev.hygino;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import br.dev.hygino.model.Book;

public class Main {
    public static void main(String[] args) {
        String arquivo = "src/main/resources/books.csv";
        List<Book> bookList = new ArrayList<>();

        try (FileReader fr = new FileReader(arquivo);
                BufferedReader reader = new BufferedReader(fr)) {

            String linha;
            while ((linha = reader.readLine()) != null) {
                try {

                    final String[] campos = linha.split(";");
                    final var title = campos[0];
                    final var author = campos[1];
                    final var publisher = campos[2];
                    final var pages = Integer.valueOf(campos[3]);
                    final var year = Integer.valueOf(campos[4]);
                    final var country = campos[5];
                    final Book book = new Book(title, author, publisher, pages, year, country);

                    bookList.add(book);
                } catch (NumberFormatException ex) {
                    System.out.println("Formato numérico inválido!");
                }
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro na leitura do arquivo");
        }
        System.out.println("Leitura concluida com sucesso!");

        final String nomeAutor = "Machado de Assis";
        final Predicate<Book> condicao = (a) -> a.author().equals(nomeAutor);

        final var quantidadeLivros = bookList.stream().filter(condicao).count();

        System.out.printf("\n\nO Autor %s tem %d livros cadastrados\n", nomeAutor, quantidadeLivros);
        final var totalPaginas = bookList.stream().filter(condicao).mapToInt(Book::totalPages).sum();

        System.out.printf("Os livros de %s somam %d páginas\n", nomeAutor, totalPaginas);

        final var booksByCountry = bookList.stream()
                .collect(Collectors.groupingBy(Book::country, Collectors.counting()));
        System.out.println("\n\nLivros publicados por país");
        booksByCountry.forEach((pais, quant) -> System.out.printf("%s: %d livros\n", pais, quant));

        final var autores = bookList.stream()
                .map(Book::author)
                .distinct()
                .sorted(Comparator.comparing(String::toString))
                .toList();
        System.out.printf("\n\nForam cadastrados %d autores\n", autores.size());
        autores.forEach(System.out::println);

    }
}