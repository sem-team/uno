package entities.games;

import main.java.ru.kpfu.itis.sem_team.entities.boards.AbstractBoard;
import main.java.ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;

public abstract class AbstractGame {
    protected boolean hasStarted;
    protected boolean hasEnded;
    protected AbstractBoard board;
    protected AbstractRoom room;

    public AbstractGame() {
        hasStarted = false;
        hasEnded = false;
    }
}
