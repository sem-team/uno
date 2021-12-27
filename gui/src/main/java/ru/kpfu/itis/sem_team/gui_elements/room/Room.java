package ru.kpfu.itis.sem_team.gui_elements.room;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.event.Event;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.gui_elements.AbstractGuiElement;
import ru.kpfu.itis.sem_team.gui_elements.room.room_elements.RoomPlayerDisplay;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;
import ru.kpfu.itis.sem_team.util.Observable;

import java.util.List;

public class Room extends AbstractGuiElement {
    private UnoRoom room;
    private List<RoomPlayerDisplay> players;

    @Override
    protected void build() {
        BorderPane pane = new BorderPane();
        HBox box  = new HBox();


        room.getParticipants().forEach(player -> {
            UnoPlayer unoPlayer = (UnoPlayer) player;
            RoomPlayerDisplay playerDisplay = new RoomPlayerDisplay();
            playerDisplay.bindToPlayer(unoPlayer);
            players.add(playerDisplay);

            box.getChildren().add(playerDisplay.getNode());
        });
        pane.setCenter(box);

        Button startGameButton = new Button("Start game");
        startGameButton.setOnAction(event -> startGame());
        pane.setBottom(startGameButton);
    }

    public void startGame() {
        IEvent event = new Event();
        event.addParameter("type", UnoProtocol.MESSAGE_GAME);
        event.addParameter("action", "start");
        event.addParameter("room", room);
    }

    @Override
    public void update(Observable o, IEvent event) {
        int type = (int) event.getParameter("type");
        if (type == UnoProtocol.MESSAGE_PLAYER) {
            handlePlayerEvent(event);
        }
    }

    private void handlePlayerEvent(IEvent event) {
        String action = (String) event.getParameter("action");
        UnoPlayer player = event.getParameter(UnoPlayer.class);
        switch (action) {
            case "connect":
                RoomPlayerDisplay newPlayerDisplay = new RoomPlayerDisplay();
                newPlayerDisplay.bindToPlayer(player);
                players.add(newPlayerDisplay);
                break;
            case "leave":
                players.removeIf(playerDisplay -> playerDisplay.getPlayer().equals(player));
        }
    }
}
