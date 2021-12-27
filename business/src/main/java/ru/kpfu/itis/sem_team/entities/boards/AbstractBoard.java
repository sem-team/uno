package ru.kpfu.itis.sem_team.entities.boards;

import ru.kpfu.itis.sem_team.entities.games.AbstractGame;

import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.util.Observable;
import ru.kpfu.itis.sem_team.util.Observer;

public abstract class AbstractBoard extends Observable implements Observer {
    protected AbstractGame game;

    public AbstractGame getGame() {
        return game;
    }

    public void setGame(AbstractGame game) {
        this.game = game;
    }

    @Override
    public void update(Observable o, IEvent event) {

    }
}
