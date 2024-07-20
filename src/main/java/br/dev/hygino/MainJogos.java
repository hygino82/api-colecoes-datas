package br.dev.hygino;

import br.dev.hygino.model.Game;
import br.dev.hygino.model.enums.ConsoleType;
import br.dev.hygino.model.enums.MediaType;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MainJogos {
    public static void main(String[] args) {
        List<Game> gameListist = generateGameList();
        final LocalDate dataMaxima = LocalDate.of(1999, 10, 3);
        final var buscaJogosLancadosAntes = gameListist.stream().filter(game -> game.getReleaseDate().isBefore(dataMaxima)).toList();
        System.out.printf("Jogos lançados antes de %s\n", dataMaxima);
        buscaJogosLancadosAntes.forEach(System.out::println);
    }

    static List<Game> generateGameList() {
        return Arrays.asList(
                new Game("Zombies Ate My Neighbors", ConsoleType.MEGA_DRIVE, MediaType.CARTRIDGE, LocalDate.of(1993, 7, 19)),
                new Game("Jurassic Park: Rampage Edition", ConsoleType.MEGA_DRIVE, MediaType.CARTRIDGE, LocalDate.of(1994, 9, 28)),
                new Game("Primal Rage", ConsoleType.MEGA_DRIVE, MediaType.CARTRIDGE, LocalDate.of(1994, 9, 28)),
                new Game("Primal Rage", ConsoleType.SUPER_NINTENDO, MediaType.CARTRIDGE, LocalDate.of(1994, 9, 28)),
                new Game("Primal Rage", ConsoleType.PLAYSTATION_1, MediaType.CD, LocalDate.of(1995, 10, 31)),
                new Game("NBA Jam: Tournament Edition", ConsoleType.MEGA_DRIVE, MediaType.CARTRIDGE, LocalDate.of(1994, 1, 17)),
                new Game("NBA Jam: Tournament Edition", ConsoleType.SUPER_NINTENDO, MediaType.CARTRIDGE, LocalDate.of(1994, 1, 17)),
                new Game("NBA Jam: Tournament Edition", ConsoleType.PLAYSTATION_1, MediaType.CD, LocalDate.of(1995, 11, 28)),
                new Game("Medal of Honor", ConsoleType.PLAYSTATION_1, MediaType.CD, LocalDate.of(1999, 11, 11)),
                new Game("The Need for Speed", ConsoleType.PLAYSTATION_1, MediaType.CD, LocalDate.of(1996, 3, 20)),
                new Game("Need for Speed II", ConsoleType.PLAYSTATION_1, MediaType.CD, LocalDate.of(1997, 3, 31)),
                new Game("Need for Speed III: Hot Pursuit", ConsoleType.PLAYSTATION_1, MediaType.CD, LocalDate.of(1998, 10, 19)),
                new Game("Need for Speed: High Stakes", ConsoleType.PLAYSTATION_1, MediaType.CD, LocalDate.of(1999, 3, 1)),
                new Game("Need for Speed: Porsche Unleashed", ConsoleType.PLAYSTATION_1, MediaType.CD, LocalDate.of(2000, 6, 29)),
                new Game("Gran Turismo", ConsoleType.PLAYSTATION_1, MediaType.CD, LocalDate.of(1998, 5, 12)),
                new Game("Gran Turismo 2", ConsoleType.PLAYSTATION_1, MediaType.CD, LocalDate.of(1999, 12, 11)),
                new Game("Resident Evil", ConsoleType.PLAYSTATION_1, MediaType.CD, LocalDate.of(1996, 3, 22)),
                new Game("Resident Evil 2", ConsoleType.PLAYSTATION_1, MediaType.CD, LocalDate.of(1998, 1, 21)),
                new Game("Resident Evil 3: Nemesis", ConsoleType.PLAYSTATION_1, MediaType.CD, LocalDate.of(1999, 9, 22))
        );
    }
}
