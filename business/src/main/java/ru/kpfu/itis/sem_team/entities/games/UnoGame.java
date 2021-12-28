package ru.kpfu.itis.sem_team.entities.games;

import ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.event.Event;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

import java.util.List;

public class UnoGame extends AbstractGame {
    public UnoGame(UnoRoom room) {
        this.room = room;
        this.addObserver(room);
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

    @Override
    public void start() {
        this.hasStarted = true;
        giveCards();
        setNextActivePlayer();

        notifyObservers(new Event(UnoProtocol.MESSAGE_GAME, "start"));
    }

    @Override
    public void end() {
        this.hasEnded = true;

        notifyObservers(new Event(UnoProtocol.MESSAGE_GAME, "start"));
    }

    public void finishTurn() {
        if (((UnoPlayer) this.activePlayer).getCards().size() == 0) {
            end();
        }
        else {
            setNextActivePlayer();
        }
    }

    public UnoPlayer getNextActivePlayer() {
        if (((UnoBoard) this.board).isClockwise()) {
            if (numberOfActivePlayer + 2 > this.room.getMaxNumberOfParticipants()) {
                return (UnoPlayer) this.room.getParticipants().get(0);
            }
            return (UnoPlayer) this.room.getParticipants().get(numberOfActivePlayer + 1);
        }
        else {
            if (numberOfActivePlayer - 1 < 0) {
                return (UnoPlayer) this.room.getParticipants().get(this.room.getMaxNumberOfParticipants() - 1);
            }
            return (UnoPlayer) this.room.getParticipants().get(numberOfActivePlayer - 1);
        }
    }

    public void setNextActivePlayer() {
        if (!((UnoBoard) this.board).isClockwise()) {
            if (numberOfActivePlayer - 1 < 0) {
                numberOfActivePlayer = this.room.getParticipants().size() - 1;
            }
            else {
                numberOfActivePlayer -= 1;
            }
        }
        else {
            if (numberOfActivePlayer + 2 > this.getRoom().getParticipants().size()) {
                numberOfActivePlayer = 0;
            }
            else {
                numberOfActivePlayer += 1;
            }
        }
        this.activePlayer = this.room.getParticipants().get(numberOfActivePlayer);
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
}
