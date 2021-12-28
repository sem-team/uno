package ru.kpfu.itis.sem_team.listeners.uno_client_listeners;

import ru.kpfu.itis.sem_team.entities.menus.UnoMenu;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class CreateRoomMessageListener extends AbstractUnoClientMessageListener {

    public static final Integer TYPE = UnoProtocol.MESSAGE_ROOM;
    public static final String ACTION = "create";

    @Override
    public void handle(IMessage message) {
        UnoPlayer messagePlayer = message.getParameter(UnoPlayer.class);

        UnoMenu menu =  client.getUnoApp().getMenu();
        UnoPlayer player = (UnoPlayer) menu.getPlayer(messagePlayer);
        menu.addRoom(new UnoRoom(player));
    }
}
