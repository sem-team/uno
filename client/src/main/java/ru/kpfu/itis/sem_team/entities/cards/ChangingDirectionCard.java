package main.java.ru.kpfu.itis.sem_team.entities.cards;

import main.java.ru.kpfu.itis.sem_team.entities.boards.UnoBoard;

public class ChangingDirectionCard extends AbstractCard implements ChangingDirection {

    public ChangingDirectionCard(Color color) {
        super(color, 0);
    }

    @Override
    public void changeDirection(UnoBoard board) {
        board.setClockwise(!board.isClockwise());
    }
}
