package ru.kpfu.itis.sem_team.entities.cards;

import ru.kpfu.itis.sem_team.entities.boards.UnoBoard;

public class ChangingDirectionCard extends UnoCard implements IChangingDirection {

    public ChangingDirectionCard(Color color) {
        super(color, 0);
    }

    @Override
    public void changeDirection(UnoBoard board) {
        board.setClockwise(!board.isClockwise());
    }
}
