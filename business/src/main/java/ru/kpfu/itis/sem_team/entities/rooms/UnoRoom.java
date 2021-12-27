package ru.kpfu.itis.sem_team.entities.rooms;

import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;

public class UnoRoom extends AbstractRoom {
    public UnoRoom(UnoPlayer admin) {
        super(4);
        this.game = new UnoGame(this);
        this.admin = admin;
        this.addPlayer(admin);
    }
}
