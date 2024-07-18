package br.dev.hygino.datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocaldateTimeTest02 {
    public static void main(String[] args) {
        LocalDateTime timePoint = LocalDateTime.now(); // The current date and time
        LocalDate.of(2012, Month.DECEMBER, 12); // from values
        LocalDate.ofEpochDay(150); // middle of 1970
        LocalTime.of(17, 18); // the train I took home today
        LocalTime.parse("10:15:30"); // From a String
    }
}
