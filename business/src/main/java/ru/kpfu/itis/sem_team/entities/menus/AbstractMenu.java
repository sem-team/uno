package ru.kpfu.itis.sem_team.entities.menus;

import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;
import ru.kpfu.itis.sem_team.event.Event;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;
import ru.kpfu.itis.sem_team.util.Observable;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenu extends Observable {
    protected List<AbstractRoom> rooms;
    protected List<AbstractPlayer> players;

    public AbstractMenu() {
        rooms = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void addPlayer(AbstractPlayer player) {
        players.add(player);
        notifyObservers(new Event(UnoProtocol.MESSAGE_PLAYER, "connect"));
    }

    public void removePlayer(AbstractPlayer player) {
        players.remove(player);
        notifyObservers(new Event(UnoProtocol.MESSAGE_PLAYER, "leave"));
    }

    public void addRoom(AbstractRoom room) {
        rooms.add(room);
        notifyObservers(new Event(UnoProtocol.MESSAGE_ROOM, "create"));
    }

    public void removeRoom(AbstractRoom room) {
        rooms.remove(room);
        notifyObservers(new Event(UnoProtocol.MESSAGE_ROOM, "remove"));
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

    public AbstractRoom getRoom(AbstractRoom providedRoom) {
        for (AbstractRoom room : rooms) {
            if (providedRoom.getParticipants().equals(room.getParticipants())) {
                return room;
            }
        }
        return null;
    }

    public AbstractPlayer getPlayer(AbstractPlayer providedPlayer) {
        for (AbstractPlayer player : players) {
            if (providedPlayer.getName().equals(player.getName())) {
                return player;
            }
        }
        return null;
    }

    public AbstractRoom getRoomByPlayer(AbstractPlayer player) {
        for (AbstractRoom room : rooms) {
            if (room.getParticipants().contains(player)) {
                return room;
            }
        }
        return null;
    }
}
