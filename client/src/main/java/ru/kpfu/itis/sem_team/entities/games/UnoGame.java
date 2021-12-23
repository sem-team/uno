package main.java.ru.kpfu.itis.sem_team.entities.games;

import main.java.ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import main.java.ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;

public class UnoGame extends AbstractGame {
    public UnoGame(UnoRoom room) {
        this.room = room;
        this.board = new UnoBoard(this);
    }
}
