package main.java.ru.kpfu.itis.sem_team.entities.cards;

import main.java.ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import main.java.ru.kpfu.itis.sem_team.entities.games.UnoGame;
import main.java.ru.kpfu.itis.sem_team.entities.players.UnoPlayer;

public class AddingWildcard extends UnoCard implements IAdding, IResettingColor{

    private final int addsCards;

    public AddingWildcard(int addsCards) {
        super(Color.COLORLESS, 0);
        this.addsCards = addsCards;
    }

    @Override
    public void addCards(UnoPlayer player, int number, UnoBoard board) {
        UnoGame game = (UnoGame) board.getGame();
        for (int i = 0; i < number; i++) {
            game.giveCard(player);
        }
    }

    @Override
    public void resetColor(Color color, UnoBoard board) {
        board.setColor(color);
    }

    public int getAddsCards() {
        return addsCards;
    }
}
