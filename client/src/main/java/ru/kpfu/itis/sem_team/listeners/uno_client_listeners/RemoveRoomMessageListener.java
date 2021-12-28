package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.exceptions.UnoException;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class RemoveRoomMessageListener extends AbstractUnoClientMessageListener {
    @Override
    public void handle(IMessage message) {
        UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);
        UnoRoom messageRoom = message.getParameter(UnoRoom.class);

        UnoRoom room = (UnoRoom) client.getModel().getMenu().getRoom(messageRoom);
        UnoPlayer player = (UnoPlayer) room.getPlayer(messagePlayer);
        Boolean isValid = (Boolean) message.getParameter("valid");
        if (isValid) {
            try {
                player.deleteRoom(room);
                room.getParticipants().clear();
                client.getModel().getMenu().removeRoom(room);
            } catch (UnoException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Integer getType() {
        return UnoProtocol.MESSAGE_ROOM;
    }

    @Override
    public String getAction() {
        return "remove";
    }
}
