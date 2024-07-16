package br.dev.hygino.colecoes;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperacoesConjuntos01 {

    public static void main(String[] args) {
        Set<Integer> A = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        Set<Integer> B = new HashSet<>(Set.of(5, 6, 7, 8, 9));
        System.out.println("Operacoes com conjuntos");
        System.out.println("A: " + A);
        System.out.println("B: " + B);

        Set<Integer> uniao = Stream.concat(A.stream(), B.stream())
                .collect(Collectors.toSet());
        System.out.println("Uniao: " + uniao);

        Set<Integer> intersecao = A.stream()
                .filter(B::contains)
                .collect(Collectors.toSet());

        System.out.println("Intersecao: " + intersecao);

        Set<Integer> diferenca = A.stream()
                .filter(e -> !B.contains(e))
                .collect(Collectors.toSet());

        System.out.println("Diferenca A - B: " + diferenca);
    }
}
