package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class GiveCardMessageListener extends UnoServerMessageListener {

    private static final int TYPE = 4;
    private static final String ACTION = "give";

    @Override
    public void handle(int connectionId, IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        if (isMessageTypeAcceptable(type, UnoProtocol.MESSAGE_CARD)) {
            UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);
            UnoRoom room = (UnoRoom) server.getUnoApp().getMenu().getRoomByPlayer(messagePlayer);
            UnoPlayer player = (UnoPlayer) room.getPlayer(messagePlayer);

            Integer amount = (Integer) message.getParameter("amount");
            if (amount == null) {
                player.askCard((UnoGame) room.getGame());
            }
            else {
                player.askCards((UnoGame) room.getGame(), amount);
            }
            message.addParameter("askedCardsPlayer", player);
            message.addParameter("askedCardsRoom", room);
            server.sendMessageBroadcast(message);
        }
    }
}
