package ru.kpfu.itis.sem_team.entities.menus;

import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.util.Observable;
import ru.kpfu.itis.sem_team.util.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenu extends Observable implements Observer {
    protected List<AbstractRoom> rooms;

    public AbstractMenu() {
        rooms = new ArrayList<>();
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

    public AbstractRoom getRoom(AbstractRoom providedRoom) {
        for (AbstractRoom room : rooms) {
            if (providedRoom.getParticipants().equals(room.getParticipants())) {
                return room;
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

    @Override
    public void update(Observable o, IEvent event) {

    }
}
