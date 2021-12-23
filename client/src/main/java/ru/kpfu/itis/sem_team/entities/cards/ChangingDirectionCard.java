package main.java.ru.kpfu.itis.sem_team.entities.cards;

import main.java.ru.kpfu.itis.sem_team.entities.boards.AbstractBoard;

public class ChangingDirectionCard extends AbstractCard implements ChangingDirection {

    public ChangingDirectionCard(Color color) {
        super(color, 0);
    }

    @Override
    public void changeDirection(AbstractBoard board) {

    }
}
