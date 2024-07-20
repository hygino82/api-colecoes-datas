package br.dev.hygino;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import br.dev.hygino.model.Book;

public class MainLivros {
    public static void main(String[] args) {
        final String arquivo = "src/main/resources/books.csv";
        final List<Book> bookList = new ArrayList<>();

        try (FileReader fr = new FileReader(arquivo); BufferedReader reader = new BufferedReader(fr)) {

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

        final var quantidadeLivros = totalDelivrosPorAutor(nomeAutor, bookList);

        System.out.printf("O Autor %s tem %d livros cadastrados.\n", nomeAutor, quantidadeLivros);

        final var totalPaginas = totalDePaginasPorAutor(nomeAutor, bookList);
        System.out.printf("Os livros cadastrados de %s somam %d páginas.\n", nomeAutor, totalPaginas);

        final var booksByCountry = listarQuantidadeDeLivrosPorPais(bookList);
        System.out.println("\nLivros publicados por país");
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

        final String pais = "Brasil";
        final var totalLivrosPais = bookList.stream().filter(livro -> livro.country().equalsIgnoreCase(pais)).count();

        System.out.printf("Total de livros cadastrados do %s %d livros.\n", pais, totalLivrosPais);

        System.out.printf("Lista de autores cadastrados do %s\n", pais);
        final var autoresBrasileiros = listarAutoresDadoSeuPais(pais, bookList);
        autoresBrasileiros.forEach(System.out::println);

        int anoPublicacao = 1967;
        final var livrosComAnoMaiorIgual = listarLivrosPorPaisComAnoDePublicacaoMaiorOuIgual(anoPublicacao, bookList);
        System.out.printf("Livros publicados a partir de %d\n", anoPublicacao);
        livrosComAnoMaiorIgual.forEach((paisPublicao, livros) -> {
            System.out.println(paisPublicao);
            livros.forEach(System.out::println);
        });
        final var quantidadePublicadaPorAno = contarLivrosPublicadosPorAno(anoPublicacao, bookList);
        System.out.printf("No ano de %d foram publicados %d livros\n", anoPublicacao, quantidadePublicadaPorAno);
    }

    public static long totalDelivrosPorAutor(String nomeAutor, List<Book> bookList) {
        final Predicate<Book> condicao = (a) -> a.author().equals(nomeAutor);

        if (bookList.stream().noneMatch(condicao)) {
            return 0;
        }
        return bookList.stream().filter(condicao).count();
    }

    public static int totalDePaginasPorAutor(String nomeAutor, List<Book> bookList) {
        final Predicate<Book> condicao = livro -> livro.author().equals(nomeAutor);
        if (bookList.stream().noneMatch(condicao)) {
            return 0;
        }

        return bookList.stream().filter(condicao).mapToInt(Book::totalPages).sum();
    }

    public static Map<String, Long> listarQuantidadeDeLivrosPorPais(List<Book> bookList) {
        return bookList.stream().collect(Collectors.groupingBy(Book::country, Collectors.counting()));
    }

    public static List<String> listarAutoresCadastrados(List<Book> bookList) {
        return bookList.stream().map(Book::author)
                .distinct()
                .sorted(Comparator.comparing(String::toString))
                .toList();
    }

    public static Map<String, Set<String>> listaLivrosPorAutor(List<Book> bookList) {
        final var livrosPorAutor = bookList.stream()
                .collect(Collectors.groupingBy(Book::author, Collectors.mapping(Book::title, Collectors.toSet())));
        return livrosPorAutor;
    }

    public static Map<String, List<String>> listaLivrosPorPais(List<Book> bookList) {

        return bookList.stream()
                .collect(Collectors.groupingBy(Book::country, Collectors.mapping(Book::title, Collectors.toList())));
    }

    public static Map<String, Set<String>> listaEscritoresPorPais(List<Book> bookList) {

        return bookList.stream()
                .collect(Collectors.groupingBy(Book::country, Collectors.mapping(Book::author, Collectors.toSet())));
    }

    public static long totalLivrosCadastradosPorPais(String nomePais, List<Book> bookList) {
        final Predicate<Book> condicao = livro -> livro.country().equalsIgnoreCase(nomePais);
        if (bookList.stream().noneMatch(condicao)) {
            return 0;
        }
        return bookList.stream().filter(condicao).count();
    }

    public static List<String> listarAutoresDadoSeuPais(String nomePais, List<Book> bookList) {
        final Predicate<Book> condicao = livro -> livro.country().equalsIgnoreCase(nomePais);
        if (bookList.stream().noneMatch(condicao)) {
            throw new IllegalArgumentException("Pais não cadastrado");
        }
        return bookList.stream()
                .filter(condicao)
                .map(Book::author)
                .distinct()
                .sorted(Comparator.comparing(String::toString))
                .toList();
    }

    public static Map<String, Set<Book>> listarLivrosPorPaisComAnoDePublicacaoMaiorOuIgual(Integer anoPublicacao, List<Book> bookList) {
        return bookList.stream()
                .filter(livro -> livro.releaseYear() >= anoPublicacao)
                .collect(Collectors.groupingBy(Book::country, Collectors.toSet()));
    }

    public static long contarLivrosPublicadosPorAno(Integer anoPublicacao, List<Book> bookList) {
        return bookList.stream().filter(livro -> Objects.equals(livro.releaseYear(), anoPublicacao)).count();
    }
}