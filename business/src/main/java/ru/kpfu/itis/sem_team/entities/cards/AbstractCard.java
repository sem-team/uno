package ru.kpfu.itis.sem_team.entities.cards;

public abstract class AbstractCard {
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
}
