package ru.kpfu.itis.sem_team.gui_graphics.menu.menu_elements;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.event.Event;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.gui_graphics.AbstractGraphicsElement;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;
import ru.kpfu.itis.sem_team.util.Observable;

public class MenuRoomDisplay extends AbstractGraphicsElement {
    private UnoRoom room;
    private VBox playersList;

    @Override
    protected void build() {
        playersList = new VBox();

        for(AbstractPlayer player: room.getParticipants()) {
            playersList.getChildren().add(new Label(player.getName()));
        }

        Button connectButton = new Button("Enter");
        connectButton.setOnAction(event -> connectToRoom());

        node = playersList;
    }

    public void bindToRoom(UnoRoom room) {
        this.room = room;
        room.addObserver(this);
        this.addObserver(room);
    }

    private void connectToRoom() {
        IEvent event = new Event();
        event.addParameter("type", UnoProtocol.MESSAGE_PLAYER);
        event.addParameter("action", "connect");
        event.addParameter("room", room);

        notifyObservers(event);
    }

    @Override
    public void update(Observable o, IEvent event) {
        int type = (int) event.getParameter("type");
        if (type == UnoProtocol.MESSAGE_PLAYER) {
            handlePlayerMessage(event);
        }
    }

    private void handlePlayerMessage(IEvent event) {
        String action = (String) event.getParameter("action");
        UnoPlayer player = (UnoPlayer) event.getParameter("player");

        switch (action) {
            case "connect":
                playersList.getChildren().add(new Label(player.getName()));
                break;
            case "leave":
                playersList.getChildren().forEach(node -> {
                    Label label = (Label) node;
                    if (label.getText().equals(player.getName()))
                        playersList.getChildren().remove(label);
                });
                break;
        }
    }

    public UnoRoom getRoom() {
        return room;
    }
}
