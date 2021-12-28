package ru.kpfu.itis.sem_team.entities.rooms;

import ru.kpfu.itis.sem_team.entities.games.AbstractGame;
import ru.kpfu.itis.sem_team.entities.menus.AbstractMenu;
import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.event.Event;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;
import ru.kpfu.itis.sem_team.util.Observable;
import ru.kpfu.itis.sem_team.util.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRoom extends Observable implements Observer, Serializable {
    protected AbstractGame game;
    protected List<AbstractPlayer> participants = new ArrayList<>();
    protected AbstractPlayer admin;
    protected final int maxNumberOfParticipants;

    protected AbstractRoom(int maxNumberOfParticipants) {
        this.maxNumberOfParticipants = maxNumberOfParticipants;
    }

    public AbstractGame getGame() {
        return game;
    }

    public void delete() {
        game = null;
        admin = null;
    }

    public void setGame(AbstractGame game) {
        this.game = game;
    }

    public List<AbstractPlayer> getParticipants() {
        return participants;
    }

    public void setParticipants(List<AbstractPlayer> participants) {
        this.participants = participants;
    }

    public AbstractPlayer getAdmin() {
        return admin;
    }

    public void setAdmin(AbstractPlayer admin) {
        this.admin = admin;
    }

    public void addPlayer(AbstractPlayer player) {
        //my code
        participants.add(player);
        notifyObservers(new Event(UnoProtocol.MESSAGE_PLAYER, "connect"));
    }

    public void removePlayer(AbstractPlayer player) {
        //my code
        participants.remove(player);
        notifyObservers(new Event(UnoProtocol.MESSAGE_PLAYER, "leave"));
    }

    public int getMaxNumberOfParticipants() {
        return maxNumberOfParticipants;
    }

    public AbstractPlayer getPlayer(AbstractPlayer player) {
        for (AbstractPlayer participant : participants) {
            if (player.getId() == participant.getId()) {
                return participant;
            }
        }
        return null;
    }

    @Override
    public void update(Observable o, IEvent event) {

    }
}
