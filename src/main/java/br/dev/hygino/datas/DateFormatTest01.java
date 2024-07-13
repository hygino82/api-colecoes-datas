package br.dev.hygino.datas;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateFormatTest01 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Calendar calendar = Calendar.getInstance();
        DateFormat df[] = new DateFormat[7];
        df[0] = DateFormat.getInstance();
        df[1] = DateFormat.getDateInstance();
        df[2] = DateFormat.getDateTimeInstance();
        df[3] = DateFormat.getDateInstance(DateFormat.SHORT);
        df[4] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        df[5] = DateFormat.getDateInstance(DateFormat.LONG);
        df[6] = DateFormat.getDateInstance(DateFormat.FULL);

        for (var dateFormat : df) {
            System.out.println(dateFormat.format(calendar.getTime()));
        }
    }
}
