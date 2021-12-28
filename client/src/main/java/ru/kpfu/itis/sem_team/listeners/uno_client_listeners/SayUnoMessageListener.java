package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.exceptions.UnoException;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class SayUnoMessageListener extends AbstractUnoClientMessageListener {

    public static final int TYPE = UnoProtocol.MESSAGE_PLAYER;
    public static final String ACTION = "uno";

    @Override
    public void handle(IMessage message) {
        UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);

        UnoRoom room = (UnoRoom) client.getModel().getMenu().getRoomByPlayer(messagePlayer);
        UnoPlayer player = (UnoPlayer) room.getPlayer(messagePlayer);
        Boolean isValid = (Boolean) message.getParameter("valid");

        if (isValid) {
            try {
                player.sayUno();
            } catch (UnoException e) {
                e.printStackTrace();
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
