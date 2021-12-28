package ru.kpfu.itis.sem_team.entities.menus;

import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;
import ru.kpfu.itis.sem_team.event.Event;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;
import ru.kpfu.itis.sem_team.util.Observable;
import ru.kpfu.itis.sem_team.util.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMenu extends Observable implements Observer, Serializable {
    protected List<AbstractRoom> rooms;

    public AbstractMenu() {
        rooms = new ArrayList<>();
    }

    public void addRoom(AbstractRoom room) {
        rooms.add(room);
        room.addObserver(this);

        IEvent event = new Event(UnoProtocol.MESSAGE_ROOM, "create");
        event.addParameter("room", room);
        notifyObservers(event);
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
            List<Integer> ids = room.getParticipants().stream().map(AbstractPlayer::getId).collect(Collectors.toList());
            if (ids.contains(player.getId())) {
                return room;
            }
        }
        return null;
    }

    @Override
    public void update(Observable o, IEvent event) {
        notifyObservers(event);
    }
}
