package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.exceptions.UnoException;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class StartGameMessageListener extends AbstractUnoClientMessageListener {
    @Override
    public void handle(IMessage message) {
        UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);
        UnoRoom messageRoom = message.getParameter(UnoRoom.class);
        Boolean isValid = (Boolean) message.getParameter("valid");

        UnoRoom room = (UnoRoom) client.getModel().getMenu().getRoom(messageRoom);
        UnoPlayer player = (UnoPlayer) room.getPlayer(messagePlayer);

        if (isValid) {
            try {
                player.startGame(room.getGame());
            } catch (UnoException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getAction() {
        return "start";
    }

    @Override
    public Integer getType() {
        return UnoProtocol.MESSAGE_GAME;
    }
}
