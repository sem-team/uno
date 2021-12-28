package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class CreateRoomMessageListener extends UnoServerMessageListener {

    private static final int TYPE = 2;
    private static final String ACTION = "create";

    @Override
    public void handle(int connectionId, IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        if (isMessageTypeAcceptable(type, UnoProtocol.MESSAGE_ROOM)) {
            UnoPlayer player = message.getParameter(UnoPlayer.class);
            UnoRoom room = new UnoRoom(player);
            server.getUnoApp().getMenu().addRoom(room);

            message.addParameter("room", room);
            server.sendMessageBroadcast(message);
        }
    }
}
