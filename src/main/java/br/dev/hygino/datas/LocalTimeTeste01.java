package br.dev.hygino.datas;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeTeste01 {

    public static void main(String[] args) {
        LocalTime time = LocalTime.of(22, 51, 15);
        System.out.println(time);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
        System.out.println(time.get(ChronoField.HOUR_OF_DAY));
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MAX);
    }
}
