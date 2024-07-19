package br.dev.hygino.model;

public record Book(
        String title,
        String author,
        String publisher,
        Integer totalPages,
        Integer releaseYear
) {
}
