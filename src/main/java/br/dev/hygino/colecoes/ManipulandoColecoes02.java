package br.dev.hygino.colecoes;

import java.util.ArrayList;
import java.util.List;

public class ManipulandoColecoes02 {
    
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        
        List<Integer> pares = numeros.stream().filter(x -> x % 2 == 0).toList();
        System.out.println("Pares: " + pares);
        
        List<String> nomes = List.of("Jupira", "Tenorio", "Juliete", "Morgana", "Filomena", "Melania", "Jupira", "Filomena");
        nomes.subList(3, 6).forEach(System.out::println);
        
    }   
}
