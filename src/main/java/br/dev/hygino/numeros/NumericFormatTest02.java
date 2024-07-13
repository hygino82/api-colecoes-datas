package br.dev.hygino.numeros;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumericFormatTest02 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        final var localeDefault = Locale.getDefault();
        final var localePtBr = new Locale("pt", "BR");
        final var localeJp = Locale.JAPAN;
        final var localeIt = Locale.ITALY;

        NumberFormat nfa[] = new NumberFormat[4];

        nfa[0] = NumberFormat.getCurrencyInstance();
        nfa[2] = NumberFormat.getCurrencyInstance(localePtBr);
        nfa[1] = NumberFormat.getCurrencyInstance(localeJp);
        nfa[3] = NumberFormat.getCurrencyInstance(localeIt);

        double valor = 1_000.2470;

        for (var numberFormat : nfa) {
            //numberFormat.setMaximumFractionDigits(4);
            System.out.println(numberFormat.format(valor));
        }
        
        String valorString = "$1,000.214";
        
        try {
            System.out.println(nfa[0].parse(valorString));
        } catch (ParseException ex) {
            System.out.println("Formato inválido");
        }
    }
}
