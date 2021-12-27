package ru.kpfu.itis.sem_team.entities.cards;

import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.util.Observable;
import ru.kpfu.itis.sem_team.util.Observer;

public abstract class AbstractCard extends Observable implements Observer {
    protected Color color;
    protected int number;

    public AbstractCard(Color color, int number) {
        this.color = color;
        this.number = number;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void update(Observable o, IEvent event) {

    }
}
