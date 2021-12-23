package main.java.ru.kpfu.itis.sem_team.entities.menus;

import main.java.ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import main.java.ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;

import java.util.List;

public abstract class AbstractMenu {
    protected List<AbstractRoom> rooms;
    protected List<AbstractPlayer> players;

    public List<AbstractRoom> getRooms() {
        return rooms;
    }

    public void setRooms(List<AbstractRoom> rooms) {
        this.rooms = rooms;
    }

    public List<AbstractPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<AbstractPlayer> players) {
        this.players = players;
    }
}
