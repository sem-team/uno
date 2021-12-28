package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class GiveTurnMessageListener extends UnoServerMessageListener {

    private static final int TYPE = 3;
    private static final String ACTION = "giveTurn";

    @Override
    public void handle(int connectionId, IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        if (isMessageTypeAcceptable(type, UnoProtocol.MESSAGE_GAME)) {
            UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);
            UnoRoom room = (UnoRoom) server.getUnoApp().getMenu().getRoomByPlayer(messagePlayer);
            ((UnoGame) room.getGame()).finishTurn();

            message.addParameter("room", room);
            server.sendMessageBroadcast(message);
        }
    }
}