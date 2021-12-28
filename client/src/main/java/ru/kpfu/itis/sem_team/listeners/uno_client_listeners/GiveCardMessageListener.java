package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class GiveCardMessageListener extends AbstractUnoClientMessageListener {
    @Override
    public void handle(IMessage message) {
        UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);

        UnoRoom room = (UnoRoom) client.getModel().getMenu().getRoomByPlayer(messagePlayer);
        UnoPlayer player = (UnoPlayer) room.getPlayer(messagePlayer);
        UnoGame game = (UnoGame) room.getGame();
        Integer amount = (Integer) message.getParameter("amount");

        if (amount == null) {
            player.askCard(game);
        }
        else {
            player.askCards(game, amount);
        }
    }

    @Override
    public Integer getType() {
        return UnoProtocol.MESSAGE_CARD;
    }

    @Override
    public String getAction() {
        return "give";
    }
}
