package br.dev.hygino.colecoes;

import java.util.*;

public class ExemploMap01 {

    static class ResultadoVotacao implements Comparable<ResultadoVotacao> {

        private final String nome;
        private final Integer votos;

        public ResultadoVotacao(String nome, Integer votos) {
            this.nome = nome;
            this.votos = votos;
        }

        @Override
        public String toString() {
            return nome + " : " + votos + " votos";
        }

        @Override
        public int compareTo(ResultadoVotacao outro) {
            return -this.votos.compareTo(outro.votos);
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> resultado = new HashMap<>();
        List<String> votos = List.of(
                "Gorete",
                "Jurandi",
                "Tenório",
                "Juca",
                "Jupira",
                "Gorete",
                "Jupira",
                "Francisco",
                "Gorete");

        votos.forEach(voto -> {
            int contagem = 1;
            if (resultado.containsKey(voto)) {
                contagem += resultado.get(voto);
            }
            resultado.put(voto, contagem);
        });

        SortedSet<ResultadoVotacao> classificacao = new TreeSet<>() ;
        resultado.forEach((nome, voto) -> {
            classificacao.add(new ResultadoVotacao(nome, voto));
        });

        System.out.println("Resultado final");
        classificacao.stream().forEach(System.out::println);
       // classificacao.stream().sorted().forEach(System.out::println);
        System.out.println("Imprime a lista de cadidatos");
        for (var chave : resultado.keySet()) {
            System.out.println(chave);
        }
    }
}
