package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.exceptions.UnoException;
import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class SayNoUnoMessageListener extends UnoServerMessageListener {

    @Override
    public void handle(int connectionId, IMessage message) {
        UnoPlayer messageSourcePlayer = (UnoPlayer) message.getParameter("sourcePlayer");
        UnoPlayer messageDestinationPlayer = (UnoPlayer) message.getParameter("destinationPlayer");

        UnoRoom room = (UnoRoom) server.getUnoApp().getMenu().getRoomByPlayer(messageSourcePlayer);
        UnoPlayer sourcePlayer = (UnoPlayer) room.getPlayer(messageSourcePlayer);
        UnoPlayer destinationPlayer = (UnoPlayer) room.getPlayer(messageDestinationPlayer);
        UnoGame game = (UnoGame) room.getGame();

        try {
            sourcePlayer.sayNotUno(destinationPlayer, game);
            message.addParameter("valid", true);
            server.sendMessageBroadcast(message);
        } catch (UnoException e) {
            message.addParameter("valid", false);
            server.sendMessage(connectionId, message);
        }
    }

    @Override
    public Integer getType() {
        return UnoProtocol.MESSAGE_PLAYER;
    }

    @Override
    public String getAction() {
        return "noUno";
    }
}
