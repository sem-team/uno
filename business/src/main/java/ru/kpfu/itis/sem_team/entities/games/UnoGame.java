package ru.kpfu.itis.sem_team.entities.games;

import ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;

import java.util.List;

public class UnoGame extends AbstractGame {
    public UnoGame(UnoRoom room) {
        this.room = room;
        this.board = new UnoBoard(this);
    }

    public void giveCard(UnoPlayer player) {
        UnoBoard board = (UnoBoard) this.board;
        player.addCard(board.getCard());
    }

    public void giveCards(UnoPlayer player, int number) {
        UnoBoard board = (UnoBoard) this.board;
        for (int i = 0; i < number; i++) {
            player.addCard(board.getCard());
        }
    }

    private void giveCards() {
        List<AbstractPlayer> playerList = room.getParticipants();
        UnoBoard board = (UnoBoard) this.board;
        for (AbstractPlayer player : playerList) {
            for (int i = 0; i < 8; i++) {
                UnoPlayer unoPlayer = (UnoPlayer) player;
                unoPlayer.addCard(board.getCard());
            }
        }
    }
    //TODO: resetUsersState - in order to start a game from the beginning  - private
}
