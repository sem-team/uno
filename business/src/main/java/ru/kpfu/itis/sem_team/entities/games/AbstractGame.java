package ru.kpfu.itis.sem_team.entities.games;

import ru.kpfu.itis.sem_team.entities.boards.AbstractBoard;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;
import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;

public abstract class AbstractGame {
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
}
