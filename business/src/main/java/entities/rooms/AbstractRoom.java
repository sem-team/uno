package entities.rooms;

import main.java.ru.kpfu.itis.sem_team.entities.games.AbstractGame;
import main.java.ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;

import java.util.List;

public abstract class AbstractRoom {
    protected AbstractGame game;
    protected List<AbstractPlayer> participants;
    protected AbstractPlayer admin;

    //TODO: Get rid of unnecessary getters & setters

    public AbstractGame getGame() {
        return game;
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
}
