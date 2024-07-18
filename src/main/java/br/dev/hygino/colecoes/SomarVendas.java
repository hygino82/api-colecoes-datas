package br.dev.hygino.colecoes;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class SomarVendas {
 public static void main(String[] args) {
        List<Sale> sales = List.of(
                new Sale("Seller1", new BigDecimal("100.50")),
                new Sale("Seller2", new BigDecimal("200.75")),
                new Sale("Seller1", new BigDecimal("50.25")),
                new Sale("Seller3", new BigDecimal("150.00")),
                new Sale("Seller2", new BigDecimal("100.00"))
        );

        Map<String, BigDecimal> top3Sellers = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getSeller, // Agrupa pelo nome do vendedor
                        Collectors.reducing(
                                BigDecimal.ZERO, // Valor inicial
                                Sale::getValue, // Extrai o valor de venda
                                BigDecimal::add // Soma os valores
                        )
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, BigDecimal>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new // Preserva a ordem de inserção
                ));

        top3Sellers.forEach((seller, totalVendas) -> 
                System.out.println("Vendedor: " + seller + ", Total de Vendas: " + totalVendas));
    }
    static class Sale {
        private String seller;
        private BigDecimal value;

        public Sale(String seller, BigDecimal value) {
            this.seller = seller;
            this.value = value;
        }

        public String getSeller() {
            return seller;
        }

        public BigDecimal getValue() {
            return value;
        }
    }
}
