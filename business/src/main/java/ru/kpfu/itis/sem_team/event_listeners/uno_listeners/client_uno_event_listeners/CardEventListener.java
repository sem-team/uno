package ru.kpfu.itis.sem_team.event_listeners.uno_listeners.client_uno_event_listeners;

import ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import ru.kpfu.itis.sem_team.entities.cards.UnoCard;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

import java.util.List;

public class CardEventListener extends AbstractClientUnoEventListener {
    @Override
    public void handle(IEvent event) {
        Integer type = (Integer) event.getParameter("type");
        if (!type.equals(UnoProtocol.MESSAGE_CARD)) {
            return;
        }
        checkAction(event);

    }

    private void checkAction(IEvent event) {
        String action = (String) event.getParameter("action");
        UnoPlayer selectedPlayer = (UnoPlayer) event.getParameter("player");

        UnoPlayer player = uno.getMenu().getPlayerByName(selectedPlayer.getName());

        switch (action) {
            case "give":
                // TODO: finish method body after new changes
                List<UnoCard> cards = (List<UnoCard>) event.getParameter("cards");
//                uno.getCurrentGame().giveCards(player, cards);
                break;
            case "play":
                UnoBoard board = (UnoBoard) uno.getCurrentRoom().getGame().getBoard();
                UnoCard card = (UnoCard) event.getParameter(UnoCard.class);
                player.useCard(card, board);
        }
    }
}
