package br.dev.hygino.datas;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest01 {

    public static void main(String[] args) {
        //Locale.setDefault(Locale.US);
        Locale localeItaly = new Locale("it", "IT");
        Locale localeBrazil = new Locale("pt", "BR");
        Locale localeIndia = new Locale("in", "IN");
        Locale localePolonia = new Locale("pl", "PL");
        Calendar calendar = Calendar.getInstance();
        
        var df1 = DateFormat.getTimeInstance(DateFormat.FULL, localeItaly);
        var df2 = DateFormat.getTimeInstance(DateFormat.FULL, localeBrazil);
        var df3 = DateFormat.getTimeInstance(DateFormat.FULL, localeIndia);
        var df4 = DateFormat.getTimeInstance(DateFormat.FULL, localePolonia);
        
        System.out.println("Italia: " + df1.format(calendar.getTime()));
        System.out.println("Brasil: " + df2.format(calendar.getTime()));
        System.out.println("India: " + df3.format(calendar.getTime()));
        System.out.println("Polonia: " + df4.format(calendar.getTime()));
        
        System.out.println(localeItaly.getDisplayCountry(localePolonia));
        System.out.println(localeBrazil.getDisplayCountry(localePolonia));
        System.out.println(localePolonia.getDisplayCountry(localePolonia));
    }
}
