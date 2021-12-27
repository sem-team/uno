package entities.players;

import main.java.ru.kpfu.itis.sem_team.entities.cards.UnoCard;
import main.java.ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;

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
        //TODO: use room's corresponding method
    }

    @Override
    public void leaveRoom(AbstractRoom room) {
        //TODO: use room's corresponding method
    }

    @Override
    public void createRoom() {
        //TODO: use room's corresponding method
    }

    @Override
    public void deleteRoom(AbstractRoom room) {
        //TODO: use room's corresponding method
    }
}
