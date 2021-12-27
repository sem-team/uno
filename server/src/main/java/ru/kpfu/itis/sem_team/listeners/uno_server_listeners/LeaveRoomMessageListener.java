package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class LeaveRoomMessageListener extends UnoServerMessageListener {

    public static final int TYPE = 1;
    public static final String ACTION = "leave";

    @Override
    public void handle(int connectionId, IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        if (isMessageTypeAcceptable(type, UnoProtocol.MESSAGE_PLAYER)) {
            UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);
            UnoRoom messageRoom = message.getParameter(UnoRoom.class);

            UnoPlayer player = (UnoPlayer) server.getUnoApp().getMenu().getPlayer(messagePlayer);
            UnoRoom room = (UnoRoom) server.getUnoApp().getMenu().getRoom(messageRoom);

            player.leaveRoom(room);

            message.addParameter("room", room);
            server.sendMessageBroadcast(message);
        }
    }
}
