package main.java.ru.kpfu.itis.sem_team.entities.boards;

import main.java.ru.kpfu.itis.sem_team.entities.cards.Color;
import main.java.ru.kpfu.itis.sem_team.entities.cards.UnoCard;
import main.java.ru.kpfu.itis.sem_team.entities.games.AbstractGame;

import java.util.Deque;

public class UnoBoard extends AbstractBoard {

    private Color color;
    private boolean clockwise;
    private Deque<UnoCard> stackOfCard;
    private UnoCard lastUsedCard;

    //TODO: Generate stack method
    //TODO: Change stackOfCard to just-in-time generation

    public UnoBoard(AbstractGame game) {
        this.game = game;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isClockwise() {
        return clockwise;
    }

    public void setClockwise(boolean clockwise) {
        this.clockwise = clockwise;
    }

    public Deque<UnoCard> getStackOfCard() {
        return stackOfCard;
    }

    public void setStackOfCard(Deque<UnoCard> stackOfCard) {
        this.stackOfCard = stackOfCard;
    }

    public UnoCard getLastUsedCard() {
        return lastUsedCard;
    }

    public void setLastUsedCard(UnoCard lastUsedCard) {
        this.lastUsedCard = lastUsedCard;
    }
}
