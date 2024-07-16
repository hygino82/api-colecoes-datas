package br.dev.hygino.datas;

import java.time.*;

public class InstantExemplo {

    public static void main(String[] args) {
        Instant timestamp = Instant.now();

        LocalDateTime ldt = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
        System.out.printf("%s %d %d at %d:%d%n", ldt.getMonth(), ldt.getDayOfMonth(),
                ldt.getYear(), ldt.getHour(), ldt.getMinute());
    }

}
