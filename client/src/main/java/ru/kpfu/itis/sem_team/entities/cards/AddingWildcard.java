package main.java.ru.kpfu.itis.sem_team.entities.cards;

import main.java.ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import main.java.ru.kpfu.itis.sem_team.entities.players.UnoPlayer;

public class AddingWildcard extends UnoCard implements IAdding, IResettingColor{
    public AddingWildcard() {
        super(Color.COLORLESS, 0);
    }

    @Override
    public void addCards(UnoPlayer player, int number, UnoBoard board) {

    }

    @Override
    public void resetColor(Color color, UnoBoard board) {

    }
}
