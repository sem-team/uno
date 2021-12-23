package main.java.ru.kpfu.itis.sem_team.entities.rooms;

import main.java.ru.kpfu.itis.sem_team.entities.games.UnoGame;
import main.java.ru.kpfu.itis.sem_team.entities.players.UnoPlayer;

public class UnoRoom extends AbstractRoom {
    public UnoRoom(UnoPlayer admin) {
        this.game = new UnoGame(this);
        this.admin = admin;
        //TODO: future addPlayer() reference from AbstractRoom
    }
}
