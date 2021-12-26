package main.java.ru.kpfu.itis.sem_team.entities.players;

import main.java.ru.kpfu.itis.sem_team.entities.cards.UnoCard;
import main.java.ru.kpfu.itis.sem_team.entities.menus.AbstractMenu;
import main.java.ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;
import main.java.ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;

import java.util.List;

public class UnoPlayer extends AbstractPlayer {

    private boolean saidUno;
    private List<UnoCard> cards;

    public UnoPlayer(String name) {
        super(name);
        saidUno = false;
    }

    //TODO: useCard
    //TODO: askCard
    //TODO: sayUno
    //TODO: sayNotUno

    public void addCard(UnoCard card) {
        cards.add(card);
    }

    @Override
    public void joinRoom(AbstractRoom room) {
        room.addPlayer(this);
    }

    @Override
    public void leaveRoom(AbstractRoom room) {
        room.removePlayer(this);
    }

    @Override
    public void createRoom(AbstractMenu menu) {
        UnoRoom room = new UnoRoom(this);
        menu.addRoom(room);
        room.addPlayer(this);
    }

    @Override
    public void deleteRoom(AbstractRoom room) {
        room.delete();
    }
}
