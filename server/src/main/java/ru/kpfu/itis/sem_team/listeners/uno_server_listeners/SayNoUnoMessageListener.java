package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.entities.exceptions.UnoException;
import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class SayNoUnoMessageListener extends UnoServerMessageListener {

    public static final int TYPE = 1;
    public static final String ACTION = "noUno";

    @Override
    public void handle(int connectionId, IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        if (isMessageTypeAcceptable(type, UnoProtocol.MESSAGE_PLAYER)) {
            UnoPlayer messageSourcePlayer = (UnoPlayer) message.getParameter("sourcePlayer");
            UnoPlayer messageDestinationPlayer = (UnoPlayer) message.getParameter("destinationPlayer");

            UnoRoom room = (UnoRoom) server.getUnoApp().getMenu().getRoomByPlayer(messageSourcePlayer);
            UnoPlayer sourcePlayer = (UnoPlayer) room.getPlayer(messageSourcePlayer);
            UnoPlayer destinationPlayer = (UnoPlayer) room.getPlayer(messageDestinationPlayer);
            UnoGame game = (UnoGame) room.getGame();

            try {
                sourcePlayer.sayNotUno(destinationPlayer, game);
                server.sendMessageBroadcast(message);
            } catch (UnoException e) {
                message.addParameter("valid", false);
                server.sendMessage(connectionId, message);
            }
        }
    }
}
