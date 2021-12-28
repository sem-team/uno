package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.exceptions.UnoException;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class SayNoUnoMessageListener extends AbstractUnoClientMessageListener {

    public static final int TYPE = UnoProtocol.MESSAGE_PLAYER;
    public static final String ACTION = "noUno";

    @Override
    public void handle(IMessage message) {
        UnoPlayer messageSourcePlayer = (UnoPlayer) message.getParameter("sourcePlayer");
        UnoPlayer messageDestinationPlayer = (UnoPlayer) message.getParameter("destinationPlayer");
        Boolean isValid = (Boolean) message.getParameter("valid");

        UnoRoom room = (UnoRoom) client.getModel().getMenu().getRoomByPlayer(messageSourcePlayer);
        UnoPlayer sourcePlayer = (UnoPlayer) room.getPlayer(messageSourcePlayer);
        UnoPlayer destinationPlayer = (UnoPlayer) room.getPlayer(messageDestinationPlayer);

        if (isValid) {
            try {
                sourcePlayer.sayNotUno(destinationPlayer, (UnoGame) room.getGame());
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
