package br.dev.hygino.datas;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDateTeste01 {

    public static void main(String[] args) {
        LocalDate data = LocalDate.of(2024, Month.JULY, 14);
        System.out.println(data);
        System.out.println(data.getYear());
        System.out.println(data.getMonth());
        System.out.println(data.getDayOfMonth());
        System.out.println(data.getMonthValue());
        System.out.println(data.getDayOfWeek());
        System.out.println(data.lengthOfMonth());
        System.out.println(data.isLeapYear());//ano bissexto
        System.out.println(data.get(ChronoField.YEAR_OF_ERA));
        System.out.println(data.get(ChronoField.DAY_OF_WEEK));
        var novaData = data.plusWeeks(8L);
        //não altera o valor da data, deve repassar para um novo objeto o valor
        System.out.println(novaData);
    }
}
