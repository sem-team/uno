package ru.kpfu.itis.sem_team.entities.rooms;

import ru.kpfu.itis.sem_team.entities.games.AbstractGame;
import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.util.Observable;
import ru.kpfu.itis.sem_team.util.Observer;

import java.util.List;

public abstract class AbstractRoom extends Observable implements Observer {
    protected AbstractGame game;
    protected List<AbstractPlayer> participants;
    protected AbstractPlayer admin;
    protected final int maxNumberOfParticipants;

    protected AbstractRoom(int maxNumberOfParticipants) {
        this.maxNumberOfParticipants = maxNumberOfParticipants;
    }

    //TODO: Get rid of unnecessary getters & setters

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
        participants.add(player);
    }

    public void removePlayer(AbstractPlayer player) {
        participants.remove(player);
    }

    public int getMaxNumberOfParticipants() {
        return maxNumberOfParticipants;
    }

    @Override
    public void update(Observable o, IEvent event) {

    }
}
