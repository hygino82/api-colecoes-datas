import java.util.List;

import br.dev.hygino.model.Book;

public class Factory {
    static final List<Book> bookListFactory() {
        List<Book> books = List.of(
                new Book("O Guarani", "José de Alencar", "Martins Fontes", 608, 1857, "Brasil"),
                new Book("Dom Casmurro", "Machado de Assis", "Penguin Companhia", 256, 1899, "Brasil"),
                new Book("Grande Sertão: Veredas", "João Guimarães Rosa", "Nova Fronteira", 624, 1956, "Brasil"),
                new Book("O Cortiço", "Aluísio Azevedo", "Ateliê Editorial", 320, 1890, "Brasil"),
                new Book("Capitães da Areia", "Jorge Amado", "Companhia das Letras", 280, 1937, "Brasil"),
                new Book("A Hora da Estrela", "Clarice Lispector", "Rocco", 88, 1977, "Brasil"),
                new Book("Vidas Secas", "Graciliano Ramos", "Record", 176, 1938, "Brasil"),
                new Book("Iracema", "José de Alencar", "Ática", 168, 1865, "Brasil"),
                new Book("Memórias Póstumas de Brás Cubas", "Machado de Assis", "Penguin Companhia", 208, 1881,
                        "Brasil"),
                new Book("Macunaíma", "Mário de Andrade", "Agir", 208, 1928, "Brasil"),
                new Book("O Alquimista", "Paulo Coelho", "HarperOne", 208, 1988, "Brasil"),
                new Book("Orgulho e Preconceito", "Jane Austen", "Martin Claret", 424, 1813, "Reino Unido"),
                new Book("Cem Anos de Solidão", "Gabriel García Márquez", "Record", 448, 1967, "Colômbia"),
                new Book("Guerra e Paz", "Leon Tolstói", "Companhia das Letras", 2160, 1869, "Rússia"),
                new Book("O Grande Gatsby", "F. Scott Fitzgerald", "Companhia das Letras", 240, 1925, "EUA"),
                new Book("Crime e Castigo", "Fiódor Dostoiévski", "Editora 34", 576, 1866, "Rússia"),
                new Book("O Apanhador no Campo de Centeio", "J.D. Salinger", "Editora do Autor", 224, 1951, "EUA"),
                new Book("Dom Quixote", "Miguel de Cervantes", "Companhia das Letras", 1232, 1605, "Espanha"),
                new Book("Os Irmãos Karamazov", "Fiódor Dostoiévski", "Editora 34", 1056, 1880, "Rússia"),
                new Book("Madame Bovary", "Gustave Flaubert", "Martin Claret", 368, 1857, "França"),
                new Book("Moby Dick", "Herman Melville", "Principis", 632, 1851, "EUA"),
                new Book("A Divina Comédia", "Dante Alighieri", "Nova Fronteira", 408, 1320, "Itália"),
                new Book("Anna Kariênina", "Lev Tolstói", "Editora 34", 864, 1877, "Rússia"),
                new Book("Os Miseráveis", "Victor Hugo", "Martin Claret", 1504, 1862, "França"),
                new Book("Ulisses", "James Joyce", "Companhia das Letras", 1280, 1922, "Irlanda"),
                new Book("A Odisseia", "Homero", "Companhia das Letras", 496, -800, "Grécia"),
                new Book("O Sol é Para Todos", "Harper Lee", "José Olympio", 364, 1960, "EUA"),
                new Book("O Hobbit", "J.R.R. Tolkien", "Martins Fontes", 336, 1937, "Reino Unido"),
                new Book("O Retrato de Dorian Gray", "Oscar Wilde", "Penguin Companhia", 320, 1890, "Irlanda"),
                new Book("Em Busca do Tempo Perdido", "Marcel Proust", "Globo Livros", 4200, 1913, "França"),
                new Book("O Estrangeiro", "Albert Camus", "Record", 176, 1942, "França"));

        return books;
    }
}
