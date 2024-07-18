package br.dev.hygino.datas;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeTest03 {
    public static void main(String[] args) {
        // remove os dois ultimos dias do mês
        LocalDate aDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);
        System.out.println(aDay);

        LocalDate dateOfBirth = LocalDate.of(1982, Month.DECEMBER, 9);
        System.out.println(dateOfBirth.getDayOfWeek());
    }
}
