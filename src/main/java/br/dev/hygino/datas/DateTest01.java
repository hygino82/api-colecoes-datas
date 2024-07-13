package br.dev.hygino.datas;

import java.util.Date;
import java.util.Locale;

public class DateTest01 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Date date = new Date();
        System.out.println(date.getTime());

    }
}
