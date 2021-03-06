package ru.kpfu.itis.sem_team.entities.games;

import ru.kpfu.itis.sem_team.entities.boards.AbstractBoard;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;
import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.util.Observable;
import ru.kpfu.itis.sem_team.util.Observer;

import java.io.Serializable;

public abstract class AbstractGame extends Observable implements Serializable {
    protected boolean hasStarted;
    protected boolean hasEnded;
    protected AbstractBoard board;
    protected AbstractRoom room;
    protected AbstractPlayer activePlayer;
    protected int numberOfActivePlayer;

    public AbstractGame() {
        hasStarted = false;
        hasEnded = false;
        numberOfActivePlayer = -1;
    }

    public void setNumberOfActivePlayer(int numberOfActivePlayer) {
        this.numberOfActivePlayer = numberOfActivePlayer;
    }

    public int getNumberOfActivePlayer() {
        return numberOfActivePlayer;
    }

    public AbstractBoard getBoard() {
        return board;
    }

    public AbstractRoom getRoom() {
        return room;
    }

    public abstract void start();
    public abstract void end();

    public boolean isHasStarted() {
        return hasStarted;
    }
}
