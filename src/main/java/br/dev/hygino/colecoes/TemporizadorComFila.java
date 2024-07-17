package br.dev.hygino.colecoes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TemporizadorComFila {
    public static void main(String[] args) throws InterruptedException {

        int tempo = 10;
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = tempo; i >= 0; i--)
            queue.add(i);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
            Thread.sleep(1000);
        }

        var res = heapSort(List.of(1, 2, 3, 7, 9, 12, 14, 8, 5));
        System.out.println("Resultado: " + res);
    }

    static <E> List<E> heapSort(Collection<E> c) {
        Queue<E> queue = new PriorityQueue<>(c);
        List<E> resultado = new ArrayList<>();

        while (!queue.isEmpty())
            resultado.add(queue.remove());

        return resultado;
    }
}