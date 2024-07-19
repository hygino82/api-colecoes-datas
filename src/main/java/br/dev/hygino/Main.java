package br.dev.hygino;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import br.dev.hygino.model.Book;

public class Main {
    public static void main(String[] args) {
        String arquivo = "src/main/resources/books.csv";
        final List<Book> bookList = new ArrayList<>();

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

        final var quantidadeLivros = totalDelivrosPorAutor(nomeAutor, bookList);

        System.out.printf("\n\nO Autor %s tem %d livros cadastrados\n", nomeAutor, quantidadeLivros);
        
        final var totalPaginas = bookList.stream().filter(condicao).mapToInt(Book::totalPages).sum();
        System.out.printf("Os livros de %s somam %d páginas\n", nomeAutor, totalPaginas);

        final var booksByCountry = bookList.stream()
                .collect(Collectors.groupingBy(Book::country, Collectors.counting()));
        System.out.println("\n\nLivros publicados por país");
        booksByCountry.forEach((pais, quant) -> System.out.printf("%s: %d livros\n", pais, quant));

        final var autores = listarAutoresCadastrados(bookList);
        System.out.printf("\n\nForam cadastrados %d autores\n", autores.size());
        autores.forEach(System.out::println);

        System.out.println("\n\nLivros de cada autor cadastrado");
        final var livrosPorAutor = listaLivrosPorAutor(bookList);

        livrosPorAutor.forEach((autor, titulos) -> {
            System.out.println("Autor: " + autor);
            titulos.forEach(titulo -> System.out.println("  Título: " + titulo));
        });

        System.out.println("\n\nLivros de cada país cadastrado");
        final var livrosPorPais = listaLivrosPorPais(bookList);

        livrosPorPais.forEach((pais, titulos) -> {
            System.out.println("País: " + pais);
            titulos.forEach(titulo -> System.out.println("  Título: " + titulo));
            System.out.printf("     Total: %d\n\n", titulos.size());
        });

        System.out.println("\n\nEscritores de cada país cadastrado");
        final var escritoresPorPais = listaEscritoresPorPais(bookList);

        escritoresPorPais.forEach((pais, escritores) -> {
            System.out.println("País: " + pais);
            escritores.forEach(nome -> System.out.println("  Escritor: " + nome));
            System.out.printf("     Total: %d\n\n", escritores.size());
        });
    }

    static long totalDelivrosPorAutor(String nomeAutor, List<Book> bookList) {
        final Predicate<Book> condicao = (a) -> a.author().equals(nomeAutor);

        if (!bookList.stream().anyMatch(condicao)) {
            return 0;
        }

        final var quantidadeLivros = bookList.stream().filter(condicao).count();
        return quantidadeLivros;
    }

    static List<String> listarAutoresCadastrados(List<Book> bookList) {
        final var autores = bookList.stream()
                .map(Book::author)
                .distinct()
                .sorted(Comparator.comparing(String::toString))
                .toList();
        return autores;
    }

    static Map<String, Set<String>> listaLivrosPorAutor(List<Book> bookList) {
        final var livrosPorAutor = bookList.stream()
                .collect(Collectors.groupingBy(
                        Book::author,
                        Collectors.mapping(Book::title, Collectors.toSet())));
        return livrosPorAutor;
    }

    static Map<String, List<String>> listaLivrosPorPais(List<Book> bookList) {
        final var livrosPorPais = bookList.stream()
                .collect(Collectors.groupingBy(
                        Book::country,
                        Collectors.mapping(Book::title, Collectors.toList())));
        return livrosPorPais;
    }

    static Map<String, Set<String>> listaEscritoresPorPais(List<Book> bookList) {
        final var escritoresPais = bookList.stream()
                .collect(Collectors.groupingBy(
                        Book::country,
                        Collectors.mapping(Book::author, Collectors.toSet())));// toSet() para não repetir nome de
                                                                               // autores
        return escritoresPais;
    }
}