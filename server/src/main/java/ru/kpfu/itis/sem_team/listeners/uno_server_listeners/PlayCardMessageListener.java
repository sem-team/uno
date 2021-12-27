package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import ru.kpfu.itis.sem_team.entities.cards.UnoCard;
import ru.kpfu.itis.sem_team.entities.exceptions.UnoException;
import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class PlayCardMessageListener extends UnoServerMessageListener {

    private static final int TYPE = 4;
    private static final String ACTION = "play";

    @Override
    public void handle(int connectionId, IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        if (isMessageTypeAcceptable(type, UnoProtocol.MESSAGE_CARD)) {
            UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);
            UnoCard messageCard = message.getParameter(UnoCard.class);

            UnoPlayer player = (UnoPlayer) server.getUnoApp().getMenu().getPlayer(messagePlayer);
            UnoGame game = (UnoGame) server.getUnoApp().getMenu().getRoomByPlayer(player).getGame();

            try {
                player.useCard(messageCard, (UnoBoard) game.getBoard());
                message.addParameter("playedCardRoom", (UnoRoom) game.getRoom());
                server.sendMessageBroadcast(message);

            } catch (UnoException e) {
                message.addParameter("valid", false);
                server.sendMessage(connectionId, message);
            }
        }
    }
}
