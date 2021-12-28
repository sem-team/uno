package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.exceptions.UnoException;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class StartGameMessageListener extends UnoServerMessageListener {

    private static final int TYPE = 3;
    private static final String ACTION = "start";

    @Override
    public void handle(int connectionId, IMessage message) {
        UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);
        UnoRoom messageRoom = message.getParameter(UnoRoom.class);

        UnoRoom room = (UnoRoom) server.getUnoApp().getMenu().getRoom(messageRoom);
        UnoPlayer player = (UnoPlayer) room.getPlayer(messagePlayer);
        try {
            player.startGame(room.getGame());
            message.addParameter("valid", true);
            server.sendMessageBroadcast(message);
        } catch (UnoException e) {
            message.addParameter("valid", false);
            server.sendMessage(connectionId, message);
        }
    }

    @Override
    public Integer getType() {
        return UnoProtocol.MESSAGE_GAME;
    }

    @Override
    public String getAction() {
        return "start";
    }
}
