package main.java.ru.kpfu.itis.sem_team.entities.boards;

import main.java.ru.kpfu.itis.sem_team.entities.cards.*;
import main.java.ru.kpfu.itis.sem_team.entities.games.AbstractGame;

import java.util.Random;

public class UnoBoard extends AbstractBoard {

    private Color color;
    private boolean clockwise;
    private UnoCard lastUsedCard;

    public UnoBoard(AbstractGame game) {
        this.game = game;
    }

    public UnoCard getCard() {
        Random random = new Random();
        double randomDouble = random.nextDouble();
        if (randomDouble <= 0.71) {
            return getRandomUnoCard();
        }
        else if (randomDouble <= 0.78) {
            return getRandomMissingRoundCard();
        }
        else if (randomDouble <= 0.85) {
            return getRandomChangingDirectionCard();
        }
        else if (randomDouble <= 0.92) {
            return getRandomAddingCard();
        }
        else if (randomDouble <= 0.96) {
            return getRandomWildcard();
        }
        else {
            return getRandomAddingWildcard();
        }
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

    public UnoCard getLastUsedCard() {
        return lastUsedCard;
    }

    public void setLastUsedCard(UnoCard lastUsedCard) {
        this.lastUsedCard = lastUsedCard;
        setColor(lastUsedCard.getColor());
    }

    private UnoCard getRandomUnoCard() {
        return new UnoCard(getRandomColor(), getRandomInt());
    }

    private AddingCard getRandomAddingCard() {
        return new AddingCard(2, getRandomColor());
    }

    private ChangingDirectionCard getRandomChangingDirectionCard() {
        return new ChangingDirectionCard(getRandomColor());
    }

    private Wildcard getRandomWildcard() {
        return new Wildcard();
    }

    private AddingWildcard getRandomAddingWildcard() {
        return new AddingWildcard(4);
    }

    private MissingRoundCard getRandomMissingRoundCard() {
        return new MissingRoundCard(getRandomColor());
    }

    private Color getRandomColor() {
        Random random = new Random();
        double randomColor = random.nextDouble();
        if (randomColor <= 0.25) {
            return Color.RED;
        }
        else if (randomColor <= 0.5) {
            return Color.BLUE;
        }
        else if (randomColor <= 0.75) {
            return Color.GREEN;
        }
        else {
            return Color.YELLOW;
        }
    }

    private int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
