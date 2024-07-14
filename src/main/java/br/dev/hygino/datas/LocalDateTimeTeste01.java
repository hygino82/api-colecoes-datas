package br.dev.hygino.datas;

import java.time.*;

public class LocalDateTimeTeste01 {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.parse("2024-07-14");
        LocalTime localTime = LocalTime.parse("17:25:43");
        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);

        var localDateTime1 = localDate.atTime(localTime);
        System.out.println(localDateTime1);

        var localDateTime2 = LocalDate.of(2017, Month.MARCH, 25).atTime(18, 45, 16);
        System.out.println(localDateTime2);

        var localDateTime3 = LocalTime.of(12, 25).atDate(LocalDate.of(2018, Month.NOVEMBER, 16));
        System.out.println(localDateTime3);
    }
}
