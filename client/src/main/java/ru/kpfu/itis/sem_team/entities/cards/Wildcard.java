package main.java.ru.kpfu.itis.sem_team.entities.cards;

import main.java.ru.kpfu.itis.sem_team.entities.boards.UnoBoard;

public class Wildcard extends UnoCard implements IResettingColor {
    public Wildcard() {
        super(Color.COLORLESS, 0);
    }

    @Override
    public void resetColor(Color color, UnoBoard board) {
        board.setColor(color);
    }
}
