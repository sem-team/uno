package ru.kpfu.itis.sem_team.entities.players;

import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.util.Observable;
import ru.kpfu.itis.sem_team.util.Observer;

import java.util.Objects;

public abstract class AbstractPlayer extends Observable implements IPlayer, Observer  {
    protected String name;
    protected int id;

    public AbstractPlayer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public AbstractPlayer(int id) {
        this.name = "player_" + id;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, IEvent event) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPlayer player = (AbstractPlayer) o;
        return id == player.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
