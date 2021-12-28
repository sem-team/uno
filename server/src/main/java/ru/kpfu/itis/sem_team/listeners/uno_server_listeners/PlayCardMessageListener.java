package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import ru.kpfu.itis.sem_team.entities.cards.UnoCard;
import ru.kpfu.itis.sem_team.exceptions.UnoException;
import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class PlayCardMessageListener extends UnoServerMessageListener {

    @Override
    public void handle(int connectionId, IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        if (isMessageTypeAcceptable(type, UnoProtocol.MESSAGE_CARD)) {
            UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);
            UnoCard messageCard = message.getParameter(UnoCard.class);

            UnoRoom room = (UnoRoom) server.getUnoApp().getMenu().getRoomByPlayer(messagePlayer);
            UnoPlayer player = (UnoPlayer) room.getPlayer(messagePlayer);
            UnoGame game = (UnoGame) room.getGame();

            try {
                player.useCard(messageCard, (UnoBoard) game.getBoard());
                message.addParameter("room", room);
                server.sendMessageBroadcast(message);

            } catch (UnoException e) {
                message.addParameter("valid", false);
                server.sendMessage(connectionId, message);
            }
        }
    }

    @Override
    public Integer getType() {
        return UnoProtocol.MESSAGE_CARD;
    }

    @Override
    public String getAction() {
        return "play";
    }
}
