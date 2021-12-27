package ru.kpfu.itis.sem_team.entities.menus;

import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenu {
    protected List<AbstractRoom> rooms;
    protected List<AbstractPlayer> players;

    //TODO: Get rid of unnecessary getters & setters

    public AbstractMenu() {
        rooms = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void addPlayer(AbstractPlayer player) {
        players.add(player);
    }

    public void removePlayer(AbstractPlayer player) {
        players.remove(player);
    }

    public void addRoom(AbstractRoom room) {
        rooms.add(room);
    }

    public void removeRoom(AbstractRoom room) {
        rooms.remove(room);
    }

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

    public boolean isPlayerValid(AbstractPlayer newPlayer) {
        return players.stream()
                .anyMatch(player -> player.getName().equals(newPlayer.getName()));
    }
}
