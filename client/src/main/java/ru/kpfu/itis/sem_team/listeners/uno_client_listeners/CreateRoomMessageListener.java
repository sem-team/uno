package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class CreateRoomMessageListener extends AbstractUnoClientMessageListener {
    @Override
    public void handle(IMessage message) {
        UnoRoom room = message.getParameter(UnoRoom.class);
        client.getModel().getMenu().addRoom(room);
    }

    @Override
    public Integer getType() {
        return UnoProtocol.MESSAGE_ROOM;
    }

    @Override
    public String getAction() {
        return "create";
    }
}
