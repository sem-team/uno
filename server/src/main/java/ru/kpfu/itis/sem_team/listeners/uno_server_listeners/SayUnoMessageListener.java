package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.exceptions.UnoException;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class SayUnoMessageListener extends UnoServerMessageListener {

    public static final int TYPE = 1;
    public static final String ACTION = "uno";

    @Override
    public void handle(int connectionId, IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        if (isMessageTypeAcceptable(type, UnoProtocol.MESSAGE_PLAYER)) {
            UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);

            UnoRoom room = (UnoRoom) server.getUnoApp().getMenu().getRoomByPlayer(messagePlayer);
            UnoPlayer player = (UnoPlayer) room.getPlayer(messagePlayer);
            try {
                player.sayUno();
                server.sendMessageBroadcast(message);
            } catch (UnoException e) {
                message.addParameter("valid", false);
                server.sendMessage(connectionId, message);
            }
        }
    }

    @Override
    public Integer getType() {
        return TYPE;
    }

    @Override
    public String getAction() {
        return ACTION;
    }
}
