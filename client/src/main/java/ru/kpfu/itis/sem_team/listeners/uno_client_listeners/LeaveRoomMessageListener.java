package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class LeaveRoomMessageListener extends AbstractUnoClientListener {

    public static final int TYPE = UnoProtocol.MESSAGE_PLAYER;
    public static final String ACTION = "leave";

    @Override
    public void handle(IMessage message) {
        UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);
        UnoRoom messageRoom = message.getParameter(UnoRoom.class);

        UnoPlayer player = (UnoPlayer) client.getUnoApp().getMenu().getPlayer(messagePlayer);
        UnoRoom room = (UnoRoom) client.getUnoApp().getMenu().getRoom(messageRoom);
        //TODO: check getCurrentPlayer()
        player.leaveRoom(room);
    }
}
