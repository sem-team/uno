package main.java.ru.kpfu.itis.sem_team.entities.cards;

import main.java.ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import main.java.ru.kpfu.itis.sem_team.entities.games.UnoGame;
import main.java.ru.kpfu.itis.sem_team.entities.players.UnoPlayer;

import java.util.Deque;

public class AddingCard extends UnoCard implements Adding {

    private int addsCards;

    public AddingCard(int addsCards, Color color) {
        super(color, 0);
        this.addsCards = addsCards;
    }

    @Override
    public void addCards(UnoPlayer player, int number, UnoBoard board) {
        Deque<UnoCard> cards = board.getStackOfCard();
        UnoGame game = (UnoGame) board.getGame();
        for (int i = 0; i < number; i++) {
            UnoCard card = cards.pop();
            game.giveCard(card, player);
        }
    }

    public int getAddsCards() {
        return addsCards;
    }

    public void setAddsCards(int addsCards) {
        this.addsCards = addsCards;
    }
}
