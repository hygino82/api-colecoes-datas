package br.dev.hygino.model.comparator;

import br.dev.hygino.model.Game;

import java.util.Comparator;

public class CompareByTitle implements Comparator<Game> {

    @Override
    public int compare(Game game1, Game game2) {
        if (game1.getGameTitle().compareTo(game2.getGameTitle()) > 0) {
            return 1;
        } else if (game1.getGameTitle().compareTo(game2.getGameTitle()) == 0) {
            return 0;
        }
        return -1;
    }

    @Override
    public Comparator<Game> reversed() {
        return Comparator.super.reversed();
    }
}
