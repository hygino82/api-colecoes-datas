package br.dev.hygino.colecoes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalavrasDuplicadas {

    public static void main(String[] args) {
        List<String> nomes = List.of("Jupira", "Tenorio", "Juliete", "Morgana", "Filomena", "Melania", "Jupira", "Filomena");
        Set<String> uniques = new HashSet<>();
        Set<String> dups = new HashSet<>();

        for (String a : nomes) {
            if (!uniques.add(a)) {
                dups.add(a);
            }
        }

        // Remove elementos duplicados
        uniques.removeAll(dups);

        System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);
    }

}
