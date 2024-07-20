package br.dev.hygino.model;

import br.dev.hygino.model.enums.ConsoleType;
import br.dev.hygino.model.enums.MediaType;

import java.time.LocalDate;
import java.util.Objects;

public class Game {
    private String gameTitle;
    private ConsoleType consoleType;
    private MediaType mediaType;
    private LocalDate releaseDate;

    public Game() {
    }

    public Game(String gameTitle, ConsoleType consoleType, MediaType mediaType, LocalDate releaseDate) {
        this.gameTitle = gameTitle;
        this.consoleType = consoleType;
        this.mediaType = mediaType;
        this.releaseDate = releaseDate;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public ConsoleType getConsoleType() {
        return consoleType;
    }

    public void setConsoleType(ConsoleType consoleType) {
        this.consoleType = consoleType;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(gameTitle, game.gameTitle) && consoleType == game.consoleType && mediaType == game.mediaType && Objects.equals(releaseDate, game.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameTitle, consoleType, mediaType, releaseDate);
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameTitle='" + gameTitle + '\'' +
                ", consoleType=" + consoleType +
                ", mediaType=" + mediaType +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
