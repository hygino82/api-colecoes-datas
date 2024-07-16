package br.dev.hygino.colecoes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ManipulandoColecoes01 {

    public static void main(String[] args) {
        List<String> nomes = List.of("Jupira", "Tenorio", "Juliete", "Morgana", "Filomena", "Melania", "Jupira", "Filomena");
        nomes.forEach(nome -> System.out.print(nome + "  "));
        System.out.println();
        System.out.println("Lista sem nomes repetidos");

        Set<String> conjunto = nomes.stream().collect(Collectors.toSet());
        conjunto.forEach(nome -> System.out.print(nome + "  "));

        System.out.println("\nConjunto de frutas");
        Set<String> frutas = new HashSet<>();
        frutas.addAll(Set.of("Banana", "Laranja", "Figo", "Graviola", "Melancia"));

        if (frutas.add("Tomate")) {
            System.out.println("A fruta adicionada ao conjunto!");
        } else {
            System.out.println("fruta repetida");
        }
        frutas.forEach(nome -> System.out.print(nome + "  "));

        Set<String> legumes = Set.of("Ervilha", "Soja", "Lentilha", "Feijao");
        //legumes.add("Grao de bico");//erro pois foi ciado o conjunto com Set.of() que é imutável
        legumes.forEach(nome -> System.out.print(nome + "  "));
    }

}
