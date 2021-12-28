package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class JoinRoomMessageListener extends AbstractUnoClientMessageListener {

    @Override
    public void handle(IMessage message) {
        UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);
        UnoRoom messageRoom = message.getParameter(UnoRoom.class);

        UnoRoom room = (UnoRoom) client.getModel().getMenu().getRoom(messageRoom);
        messagePlayer.joinRoom(room);
    }

    @Override
    public Integer getType() {
        return UnoProtocol.MESSAGE_PLAYER;
    }

    @Override
    public String getAction() {
        return "connect";
    }
}
