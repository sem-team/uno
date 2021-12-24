package main.java.ru.kpfu.itis.sem_team.entities.cards;

import main.java.ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;

public class AddingCard extends AbstractCard implements Adding {

    private int addsCards;

    public AddingCard(int addsCards, Color color) {
        super(color, 0);
        this.addsCards = addsCards;
    }

    @Override
    public void addCards(AbstractPlayer player, int number) {
        //TODO: Get cards from board's stack, get player's stack and add cards
        //FIXME: Change signature: add AbstractBoard
    }

    public int getAddsCards() {
        return addsCards;
    }

    public void setAddsCards(int addsCards) {
        this.addsCards = addsCards;
    }
}
