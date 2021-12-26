package main.java.ru.kpfu.itis.sem_team.entities.games;

import main.java.ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import main.java.ru.kpfu.itis.sem_team.entities.cards.UnoCard;
import main.java.ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import main.java.ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;

public class UnoGame extends AbstractGame {
    public UnoGame(UnoRoom room) {
        this.room = room;
        this.board = new UnoBoard(this);
    }

    public void giveCard(UnoCard card, UnoPlayer player) {
        player.addCard(card);
    }
    //TODO: call getCard() from Board and use it here 
    //TODO: giveCards - private
    //TODO: resetUsersState - in order to start a game from the beginning  - private
}
