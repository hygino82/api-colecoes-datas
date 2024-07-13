package br.dev.hygino.numeros;

import java.text.NumberFormat;
import java.util.Locale;

public class NumericFormatTest01 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        final var localeDefault = Locale.getDefault();
        final var localePtBr = new Locale("pt", "BR");
        final var localeJp = Locale.JAPAN;
        final var localeIt = Locale.ITALY;

        NumberFormat nfa[] = new NumberFormat[4];

        nfa[0] = NumberFormat.getInstance();
        nfa[2] = NumberFormat.getInstance(localePtBr);
        nfa[1] = NumberFormat.getInstance(localeJp);
        nfa[3] = NumberFormat.getInstance(localeIt);

        double valor = 1_000_000.247;

        for (var numberFormat : nfa) {
            System.out.println(numberFormat.format(valor));
        }
    }
}
