package ru.kpfu.itis.sem_team.entities.players;

import ru.kpfu.itis.sem_team.entities.cards.*;
import ru.kpfu.itis.sem_team.exceptions.UnoException;
import ru.kpfu.itis.sem_team.entities.games.AbstractGame;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.menus.AbstractMenu;

import java.util.ArrayList;
import java.util.List;

public class UnoPlayer extends AbstractPlayer {

    private boolean saidUno;
    private List<UnoCard> cards;

    public UnoPlayer(String name, int id) {
        super(name, id);
        saidUno = false;
        cards = new ArrayList<>();
    }

    public UnoPlayer(int id) {
        super(id);
    }

    public void askCard(UnoGame game) {
        game.giveCard(this);
    }

    public void askCards(UnoGame game, int number) {
        game.giveCards(this, number);
    }

    public void sayUno() throws UnoException {
        if (!saidUno && cards.size() == 2) {
            saidUno = true;
        }
        else {
            throw new UnoException();
        }
    }

    public void sayNotUno(UnoPlayer player, UnoGame game) throws UnoException {
        if (!player.saidUno && player.getCards().size() == 2) {
            player.saidUno = false;
            player.askCard(game);
        }
        else {
            throw new UnoException();
        }
    }

    public void useCard(UnoCard card, UnoBoard board) throws UnoException {
        if (card.getClass().equals(AddingCard.class)) {
            useAddingCard(card, board);
        }
        else if (card.getClass().equals(AddingWildcard.class)) {
            useAddingWildcard(card, board);
        }
        else if (card.getClass().equals(ChangingDirectionCard.class)) {
            useChangingDirectionCard(card, board);
        }
        else if (card.getClass().equals(MissingRoundCard.class)) {
            useMissingRoundCard(card, board);
        }
        else if (card.getClass().equals(Wildcard.class)) {
            useWildcard(card, board);
        }
        else {
            useUnoCard(card, board);
        }

        if (this.cards.size() == 0 && this.saidUno) {
            finishGame(board.getGame());
        }
        else if (!this.saidUno) {
            askCard((UnoGame) board.getGame());
        }
    }

    private void useWildcard(UnoCard card, UnoBoard board) {
        board.setLastUsedCard(card);
        //TODO: ask for a color from user
    }

    private void useMissingRoundCard(UnoCard card, UnoBoard board) throws UnoException {
        UnoCard lastUsedCard = board.getLastUsedCard();
        MissingRoundCard missingRoundCard = (MissingRoundCard) card;
        if (lastUsedCard == null) {
            board.setLastUsedCard(missingRoundCard);
            missingRoundCard.missRound((UnoGame) board.getGame());
        }
        else if (card.getColor().equals(lastUsedCard.getColor())) {
            board.setLastUsedCard(card);
            missingRoundCard.missRound((UnoGame) board.getGame());
        }
        else if (lastUsedCard.getColor().equals(Color.COLORLESS) && card.getColor().equals(board.getColor())) {
            board.setLastUsedCard(card);
            missingRoundCard.missRound((UnoGame) board.getGame());
        }
        else {
            throw new UnoException();
        }
    }

    private void useChangingDirectionCard(UnoCard card, UnoBoard board) throws UnoException {
        UnoCard lastUsedCard = board.getLastUsedCard();
        ChangingDirectionCard changingDirectionCard = (ChangingDirectionCard) card;
        if (lastUsedCard == null) {
            board.setLastUsedCard(changingDirectionCard);
            changingDirectionCard.changeDirection(board);
        }
        else if (card.getColor().equals(lastUsedCard.getColor())) {
            board.setLastUsedCard(card);
            changingDirectionCard.changeDirection(board);
        }
        else if (lastUsedCard.getColor().equals(Color.COLORLESS) && card.getColor().equals(board.getColor())) {
            board.setLastUsedCard(card);
            changingDirectionCard.changeDirection(board);
        }
        else {
            throw new UnoException();
        }
    }

    private void useAddingWildcard(UnoCard card, UnoBoard board) {
        board.setLastUsedCard(card);
        AddingWildcard addingWildcard = (AddingWildcard) card;
        addingWildcard.addCards(((UnoGame) board.getGame()).getNextActivePlayer(), addingWildcard.getAddsCards(), board);
        //TODO: ask for a color from user
    }

    private void useAddingCard(UnoCard card, UnoBoard board) throws UnoException {
        UnoCard lastUsedCard = board.getLastUsedCard();
        AddingCard addingCard = (AddingCard) card;
        if (lastUsedCard == null) {
            board.setLastUsedCard(addingCard);
            addingCard.addCards(((UnoGame) board.getGame()).getNextActivePlayer(), addingCard.getAddsCards(), board);
        }
        else if (card.getColor().equals(lastUsedCard.getColor())) {
            board.setLastUsedCard(card);
            addingCard.addCards(((UnoGame) board.getGame()).getNextActivePlayer(), addingCard.getAddsCards(), board);
        }
        else if (lastUsedCard.getColor().equals(Color.COLORLESS) && card.getColor().equals(board.getColor())) {
            board.setLastUsedCard(card);
            addingCard.addCards(((UnoGame) board.getGame()).getNextActivePlayer(), addingCard.getAddsCards(), board);
        }
        else {
            throw new UnoException();
        }
    }

    private void useUnoCard(UnoCard card, UnoBoard board) throws UnoException {
        UnoCard lastUsedCard = board.getLastUsedCard();
        if (lastUsedCard == null) {
            board.setLastUsedCard(card);
        }
        else if (card.getColor().equals(lastUsedCard.getColor()) || card.getNumber() == lastUsedCard.getNumber()) {
            board.setLastUsedCard(card);
        }
        else if (lastUsedCard.getColor().equals(Color.COLORLESS) && card.getColor().equals(board.getColor())) {
            board.setLastUsedCard(card);
        }
        else {
            throw new UnoException();
        }
    }

    public void addCard(UnoCard card) {
        cards.add(card);
    }

    public void addCards(List<UnoCard> cards) {
        this.cards.addAll(cards);
    }

    @Override
    public void joinRoom(AbstractRoom room) {
        room.addPlayer(this);
    }

    @Override
    public void leaveRoom(AbstractRoom room) {
        room.removePlayer(this);
    }

    @Override
    public void createRoom(AbstractMenu menu) {
        UnoRoom room = new UnoRoom(this);
        menu.addRoom(room);
        room.addPlayer(this);
    }

    @Override
    public void deleteRoom(AbstractRoom room) throws UnoException {
        if (room.getAdmin().equals(this)) {
            room.delete();
        }
        else {
            throw new UnoException();
        }
    }

    @Override
    public void startGame(AbstractGame game) throws UnoException {
        if (this.equals(game.getRoom().getAdmin())) {
            game.start();
        }
        else {
            throw new UnoException();
        }
    }

    public void finishGame(AbstractGame game) {
        game.end();
    }

    public List<UnoCard> getCards() {
        return cards;
    }
}
