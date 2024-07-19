package br.dev.hygino;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

                    final Book book = new Book(title, author, publisher, pages, year);

                    bookList.add(book);
                } catch (NumberFormatException ex) {
                    System.out.println("Formato numérico inválido!");
                }
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro na leitura do arquivo");
        }
        System.out.println("Leitura concluida com sucesso!");
        bookList.forEach(System.out::println);
    }
}