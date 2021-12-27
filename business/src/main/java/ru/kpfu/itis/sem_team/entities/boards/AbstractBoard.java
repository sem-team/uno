package ru.kpfu.itis.sem_team.entities.boards;

import ru.kpfu.itis.sem_team.entities.games.AbstractGame;

public abstract class AbstractBoard {
    protected AbstractGame game;

    public AbstractGame getGame() {
        return game;
    }

    public void setGame(AbstractGame game) {
        this.game = game;
    }
}
