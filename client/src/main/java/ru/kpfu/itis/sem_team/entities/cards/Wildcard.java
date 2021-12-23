package main.java.ru.kpfu.itis.sem_team.entities.cards;

import main.java.ru.kpfu.itis.sem_team.entities.boards.AbstractBoard;

public class Wildcard extends AbstractCard implements ResettingColor {
    public Wildcard() {
        super(Color.COLORLESS, 0);
    }

    @Override
    public void resetColor(Color color, AbstractBoard board) {

    }
}
