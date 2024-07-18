package br.dev.hygino.datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAula2 {

    private DateAula2() {
        testedateTime();
    }

    private void testedateTime() {
        final var currentDate1 = new Date();
        System.out.println(currentDate1);

        final var currentDate2 = LocalDate.now();
        System.out.println(currentDate2);
        // pega a data e hora com fuso horário
        final var currentDate3 = ZonedDateTime.now();
        System.out.println(currentDate3);
        // pega a data e hora sem fuso horário
        final var currentDate4 = LocalDateTime.now();
        System.out.println(currentDate4);

        final var other = LocalDate.now().plusDays(3).withMonth(8).atTime(16, 7);
        System.out.println(other);

        final var other2 = new GregorianCalendar(2024, Calendar.JULY, 17, 18, 27).getTime();
        System.out.println(other2);

        final var actualMonth = LocalDate.now().getMonth();
        System.out.println("Mẽs atual: " + actualMonth.getValue());

        final var actualTime = LocalTime.now();

        final var combined = LocalDateTime.of(LocalDate.now(), actualTime);
        System.out.println(combined);

        // diferença de datas
        final var birthdate = LocalDate.of(1982, 12, 9);
        // mostra a diferença em meses
        System.out.println(ChronoUnit.MONTHS.between(birthdate, LocalDate.now()));

        // Somando valoes na api antiga
        final var calendar = new GregorianCalendar();
        calendar.add(Calendar.HOUR, 10);
        final var now = new Date();
        System.out.println(calendar.getTime().getTime() - now.getTime());

        // somando aom a api nova
        final var future = LocalDateTime.now().plusHours(10);
        System.out.println(Duration.between(LocalDateTime.now(), future));

        // formatação de data na api antiga
        try {
            final var formatter1 = new SimpleDateFormat("dd/MM/yyyy");
            final var formatedDate = formatter1.parse("14/05/2024");
            System.out.println(formatedDate);
        } catch (ParseException ex) {
            System.out.println("Ero no formato da data");
        }
        // formatação de data na api nova

        final var formatedDate = LocalDate.parse("14/06/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(formatedDate);

    }

    public static void main(String[] args) {
        new DateAula2();
    }
}
