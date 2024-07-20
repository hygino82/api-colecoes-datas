package br.dev.hygino;

import br.dev.hygino.model.Game;
import br.dev.hygino.model.enums.ConsoleType;
import br.dev.hygino.model.enums.MediaType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class MainJogos {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        List<Game> gameList = generateGameList();

        final LocalDate dataMaxima = LocalDate.of(1999, 10, 3);
        final var buscaJogosLancadosAntes = findByGamesBeforeOf(dataMaxima, gameList);
        System.out.printf("Jogos lançados antes de %s\n", dataMaxima);
        buscaJogosLancadosAntes.forEach(System.out::println);

        final var consoleType = ConsoleType.PLAYSTATION_1;
        final var jogosDoConsole = countGamesByConsole(consoleType, gameList);
        System.out.printf("O console %s tem %d jogos cadastrados\n", consoleType.name(), jogosDoConsole);

        System.out.println("Total de jogos cadastrados por console");
        final var countGamesByConsole = totalGamesByConsole(gameList);
        countGamesByConsole.forEach((c, n) -> System.out.printf("%s tem %d jogos\n", c, n));

        System.out.printf("\nLista de jogos ordenada do console %s\n", consoleType);
        final var findGamesByConsole = findGamesByConsoleOrdered(consoleType, gameList);
        findGamesByConsole.forEach(System.out::println);

        final var startAt = LocalDate.of(1997, 10, 15);
        final var endAt = LocalDate.of(1999, 8, 8);

        final var buscaJogosLancadosEntre = findByGamesInThePeriod(startAt, endAt, gameList);
        System.out.printf("\nLista de jogos lançados entre %s e %s possui %d jogos\n", formatter.format(startAt), formatter.format(endAt), buscaJogosLancadosEntre.size());
        buscaJogosLancadosEntre.forEach(System.out::println);

        final String titulo = "need";
        final var listarJogosPorConsoleENomeContendo = findGamesByConsoleAndTitle(titulo, consoleType, gameList);
        System.out.printf("\nJogos do console %s com nome contendo '%s'\n", consoleType, titulo);
        listarJogosPorConsoleENomeContendo.forEach(System.out::println);

        final var mediaType = MediaType.BLU_RAY;
        System.out.printf("\nBusca de jogos que usam %s como mídia agrupado por Console\n", mediaType);
        final var buscarJogosQuieUsemMidiaAgruparPorConsole = findGamesByMediaTypeGroupByConsole(mediaType, gameList);
        buscarJogosQuieUsemMidiaAgruparPorConsole.forEach((chave, valor) -> {
            System.out.printf("\nJogos do console %s: %d\n", chave, valor.size());
            valor.forEach(System.out::println);
        });
    }

    public static Map<ConsoleType, Set<String>> findGamesByMediaTypeGroupByConsole(MediaType mediaType, List<Game> gameList) {
        return gameList.stream()
                .filter(game -> game.getMediaType().equals(mediaType))
                .collect(Collectors.groupingBy(Game::getConsoleType, Collectors.mapping(Game::getGameTitle, Collectors.toSet())));
    }

    public static List<String> findGamesByConsoleAndTitle(String title, ConsoleType consoleType, List<Game> gameList) {
        return gameList.stream().filter(game ->
                        game.getGameTitle().toLowerCase().contains(title.toLowerCase())
                                && game.getConsoleType().equals(consoleType)
                )
                .map(Game::getGameTitle)
                .toList();
    }

    public static List<Game> findByGamesInThePeriod(LocalDate startAt, LocalDate endAt, List<Game> gameList) {
        return gameList.stream()
                .filter(game -> !game.getReleaseDate().isBefore(startAt) && !game.getReleaseDate().isAfter(endAt))
                .toList();
    }

    public static long countToGamesInThePeriod(LocalDate startAt, LocalDate endAt, List<Game> gameList) {
        return gameList.stream()
                .filter(game -> !game.getReleaseDate().isBefore(startAt) && !game.getReleaseDate().isAfter(endAt))
                .count();
    }

    public static List<String> findGamesByConsoleOrdered(ConsoleType consoleType, List<Game> gameList) {
        return gameList.stream()
                .filter(game -> game.getConsoleType().equals(consoleType))
                .map(Game::getGameTitle)
                .sorted(String::compareTo)
                .toList();
    }

    public static Map<ConsoleType, Long> totalGamesByConsole(List<Game> gameList) {
        final var totalGames = gameList.stream()
                .collect(Collectors.groupingBy(Game::getConsoleType, Collectors.counting()));

        return totalGames.entrySet()
                .stream()
                .sorted(Map.Entry.<ConsoleType, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public static Map<ConsoleType, List<String>> listGamesByConsole(List<Game> gameList) {
        return gameList.stream()
                .collect(Collectors.groupingBy(
                        Game::getConsoleType,
                        Collectors.mapping(Game::getGameTitle, Collectors.toList())
                ));
    }

    public static List<Game> findByGamesBeforeOf(LocalDate date, List<Game> gameList) {
        return gameList.stream()
                .filter(game -> game.getReleaseDate().isBefore(date))
                .toList();
    }

    public static long countGamesByConsole(ConsoleType console, List<Game> gameList) {
        return gameList.stream().filter(game -> game.getConsoleType().equals(console)).count();
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
                new Game("Resident Evil 3: Nemesis", ConsoleType.PLAYSTATION_1, MediaType.CD, LocalDate.of(1999, 9, 22)),
                new Game("Need for Speed: Hot Pursuit 2", ConsoleType.PLAYSTATION_2, MediaType.DVD, LocalDate.of(2002, 10, 2)),
                new Game("Need for Speed: Underground", ConsoleType.PLAYSTATION_2, MediaType.DVD, LocalDate.of(2003, 11, 17)),
                new Game("Need for Speed: Underground 2", ConsoleType.PLAYSTATION_2, MediaType.DVD, LocalDate.of(2004, 11, 15)),
                new Game("Need for Speed: Most Wanted", ConsoleType.PLAYSTATION_2, MediaType.DVD, LocalDate.of(2005, 11, 15)),
                new Game("Need for Speed: Carbon", ConsoleType.PLAYSTATION_2, MediaType.DVD, LocalDate.of(2006, 10, 30)),
                new Game("Need for Speed: ProStreet", ConsoleType.PLAYSTATION_2, MediaType.DVD, LocalDate.of(2007, 11, 14)),
                new Game("Need for Speed: Undercover", ConsoleType.PLAYSTATION_2, MediaType.DVD, LocalDate.of(2008, 11, 18)),
                new Game("Need for Speed: ProStreet", ConsoleType.PLAYSTATION_3, MediaType.BLU_RAY, LocalDate.of(2007, 11, 14)),
                new Game("Need for Speed: Undercover", ConsoleType.PLAYSTATION_3, MediaType.BLU_RAY, LocalDate.of(2008, 11, 18)),
                new Game("Need for Speed: Shift", ConsoleType.PLAYSTATION_3, MediaType.BLU_RAY, LocalDate.of(2009, 9, 15)),
                new Game("Need for Speed: Hot Pursuit", ConsoleType.PLAYSTATION_3, MediaType.BLU_RAY, LocalDate.of(2010, 11, 16)),
                new Game("Need for Speed: Shift 2 Unleashed", ConsoleType.PLAYSTATION_3, MediaType.BLU_RAY, LocalDate.of(2011, 3, 29)),
                new Game("Need for Speed: The Run", ConsoleType.PLAYSTATION_3, MediaType.BLU_RAY, LocalDate.of(2011, 11, 15)),
                new Game("Need for Speed: Most Wanted", ConsoleType.PLAYSTATION_3, MediaType.BLU_RAY, LocalDate.of(2012, 10, 30)),
                new Game("Need for Speed: Rivals", ConsoleType.PLAYSTATION_3, MediaType.BLU_RAY, LocalDate.of(2013, 11, 15)),
                new Game("Need for Speed: Rivals", ConsoleType.PLAYSTATION_4, MediaType.BLU_RAY, LocalDate.of(2013, 11, 15)),
                new Game("Need for Speed", ConsoleType.PLAYSTATION_4, MediaType.BLU_RAY, LocalDate.of(2015, 11, 3)),
                new Game("Need for Speed: Payback", ConsoleType.PLAYSTATION_4, MediaType.BLU_RAY, LocalDate.of(2017, 11, 10)),
                new Game("Need for Speed: Heat", ConsoleType.PLAYSTATION_4, MediaType.BLU_RAY, LocalDate.of(2019, 11, 8))
        );
    }
}
