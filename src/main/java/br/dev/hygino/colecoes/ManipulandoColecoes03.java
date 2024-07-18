package br.dev.hygino.colecoes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ManipulandoColecoes03 {
    public static void main(String[] args) {
        List<String> pessoas = new ArrayList<>(
                List.of("Jupira", "Tenório", "Godofredo", "Melania", "Gorete"));

        pessoas.stream().sorted(Comparator.comparing(String::toString)).forEach(System.out::println);

        LinkedList<Integer> numeros = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6));

        numeros.push(20);

        numeros.pop();

        numeros.forEach(System.out::println);
    }
}
