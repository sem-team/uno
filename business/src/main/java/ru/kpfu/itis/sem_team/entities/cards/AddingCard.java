package ru.kpfu.itis.sem_team.entities.cards;

import ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;

public class AddingCard extends UnoCard implements IAdding {

    private int addsCards;

    public AddingCard(int addsCards, Color color) {
        super(color, 0);
        this.addsCards = addsCards;
    }

    @Override
    public void addCards(UnoPlayer player, int number, UnoBoard board) {
        UnoGame game = (UnoGame) board.getGame();
        for (int i = 0; i < number; i++) {
            game.giveCard(player);
        }
    }

    public int getAddsCards() {
        return addsCards;
    }

    public void setAddsCards(int addsCards) {
        this.addsCards = addsCards;
    }
}
