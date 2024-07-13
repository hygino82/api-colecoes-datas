package br.dev.hygino.datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest01 {

    public static void main(String[] args) throws ParseException {
        String pattern = "yyyy-MM-dd 'T' HH:mm:ss z";
        String pattern2 = "'Vista Alegre' dd 'de' MMMM 'de' yyyy";
        var pattern3 = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern3);
        Date date = new Date();
        System.out.println(sdf.format(date));

        var date2 = sdf.parse("09/12/1982");
        System.out.println(date2);
    }
}
