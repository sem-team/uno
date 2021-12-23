package main.java.ru.kpfu.itis.sem_team.entities.boards;

import main.java.ru.kpfu.itis.sem_team.entities.cards.AbstractCard;
import main.java.ru.kpfu.itis.sem_team.entities.cards.Color;
import main.java.ru.kpfu.itis.sem_team.entities.cards.UnoCard;
import main.java.ru.kpfu.itis.sem_team.entities.games.AbstractGame;

import java.util.List;

public class UnoBoard extends AbstractBoard {

    private Color color;
    private boolean clockwise;
    private UnoCard primaryCard;
    //TODO: Maybe I can find another collection?
    private List<AbstractCard> stackOfCard;
    private AbstractCard lastUsedCard;

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

    public UnoCard getPrimaryCard() {
        return primaryCard;
    }

    public void setPrimaryCard(UnoCard primaryCard) {
        this.primaryCard = primaryCard;
    }

    public List<AbstractCard> getStackOfCard() {
        return stackOfCard;
    }

    public void setStackOfCard(List<AbstractCard> stackOfCard) {
        this.stackOfCard = stackOfCard;
    }

    public AbstractCard getLastUsedCard() {
        return lastUsedCard;
    }

    public void setLastUsedCard(AbstractCard lastUsedCard) {
        this.lastUsedCard = lastUsedCard;
    }
}
