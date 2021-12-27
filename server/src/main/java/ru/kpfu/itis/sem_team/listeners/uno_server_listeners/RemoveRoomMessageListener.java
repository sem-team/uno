package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.entities.exceptions.UnoException;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class RemoveRoomMessageListener extends UnoServerMessageListener {

    private static final int TYPE = 2;
    private static final String ACTION = "remove";

    @Override
    public void handle(int connectionId, IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        if (isMessageTypeAcceptable(type, UnoProtocol.MESSAGE_ROOM)) {
            UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);
            UnoRoom messageRoom = message.getParameter(UnoRoom.class);

            UnoPlayer player = (UnoPlayer) server.getUnoApp().getMenu().getPlayer(messagePlayer);
            UnoRoom room = (UnoRoom) server.getUnoApp().getMenu().getRoom(messageRoom);

            try {
                player.deleteRoom(room);
                server.getUnoApp().getMenu().removeRoom(room);
                message.addParameter("deletedRoom", room);
                server.sendMessageBroadcast(message);
                room.getParticipants().clear();
            } catch (UnoException e) {
                message.addParameter("valid", false);
                server.sendMessage(connectionId, message);
            }
        }
    }
}
