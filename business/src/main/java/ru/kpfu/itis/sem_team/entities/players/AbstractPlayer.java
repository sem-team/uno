package ru.kpfu.itis.sem_team.entities.players;

import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.util.Observable;
import ru.kpfu.itis.sem_team.util.Observer;

public abstract class AbstractPlayer extends Observable implements IPlayer, Observer  {
    protected String name;

    public AbstractPlayer(String name) {
        this.name = name;
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
}
