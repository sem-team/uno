package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

import java.util.List;
import java.util.stream.Collectors;

public class GetRoomsMessageListener extends UnoServerMessageListener {

    private static final int TYPE = 2;
    private static final String ACTION = "getRooms";

    @Override
    public void handle(int connectionId, IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        if (isMessageTypeAcceptable(type, UnoProtocol.MESSAGE_ROOM)) {
            List<AbstractRoom> roomList = server.getUnoApp().getMenu().getRooms().stream()
                    .filter(room -> !room.getGame().isHasStarted())
                    .collect(Collectors.toList());
            message.addParameter("rooms", roomList);
            server.sendMessageBroadcast(message);
        }
    }
}
