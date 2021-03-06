package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class GiveTurnMessageListener extends AbstractUnoClientMessageListener {
    @Override
    public void handle(IMessage message) {
        UnoRoom messageRoom = message.getParameter(UnoRoom.class);

        UnoRoom room = (UnoRoom) client.getModel().getMenu().getRoom(messageRoom);
        UnoGame game = (UnoGame) room.getGame();
        game.finishTurn();
    }

    @Override
    public Integer getType() {
        return UnoProtocol.MESSAGE_GAME;
    }

    @Override
    public String getAction() {
        return "giveTurn";
    }
}
