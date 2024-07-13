package br.dev.hygino.numeros;

import java.util.Locale;

public class LocaleTest02 {

    public static void main(String[] args) {
        System.out.println(Locale.getDefault());

        for (var s : Locale.getISOCountries()) {
            System.out.print(s + " ");
        }

        System.out.println();

        for (var s : Locale.getISOLanguages()) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
