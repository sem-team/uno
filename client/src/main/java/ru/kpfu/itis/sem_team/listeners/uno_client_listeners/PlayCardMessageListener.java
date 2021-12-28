package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import ru.kpfu.itis.sem_team.entities.cards.UnoCard;
import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.exceptions.UnoException;
import ru.kpfu.itis.sem_team.message.IMessage;

public class PlayCardMessageListener extends AbstractUnoClientMessageListener {
    @Override
    public void handle(IMessage message) {
        UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);
        UnoCard card = message.getParameter(UnoCard.class);

        UnoRoom room = (UnoRoom) client.getModel().getMenu().getRoomByPlayer(messagePlayer);
        UnoPlayer player = (UnoPlayer) room.getPlayer(messagePlayer);
        UnoGame game = (UnoGame) room.getGame();
        Boolean isValid = (Boolean) message.getParameter("valid");

        if (isValid) {
            try {
                player.useCard(card, (UnoBoard) game.getBoard());
            } catch (UnoException e) {
                e.printStackTrace();
            }
        }
    }
}
