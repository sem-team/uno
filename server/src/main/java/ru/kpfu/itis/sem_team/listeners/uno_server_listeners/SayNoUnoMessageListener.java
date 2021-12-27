package ru.kpfu.itis.sem_team.listeners.uno_server_listeners;

import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class SayNoUnoMessageListener extends UnoServerMessageListener {
    @Override
    public void handle(int connectionId, IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        if (isMessageTypeAcceptable(type, UnoProtocol.MESSAGE_PLAYER)) {
            UnoPlayer sourcePlayer = (UnoPlayer) message.getParameter("sourcePlayer");
            UnoPlayer destinationPlayer = (UnoPlayer) message.getParameter("destinationPlayer");
            UnoGame game = message.getParameter(UnoGame.class);

            sourcePlayer.sayNotUno(destinationPlayer, game);
            server.sendMessageBroadcast(message);
        }
    }
}
