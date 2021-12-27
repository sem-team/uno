package ru.kpfu.itis.sem_team.gui_elements.menu;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.event.Event;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.gui_elements.AbstractGuiElement;
import ru.kpfu.itis.sem_team.gui_elements.menu.menu_elements.MenuRoomDisplay;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;
import ru.kpfu.itis.sem_team.util.Observable;

import java.util.List;

public class MenuElement extends AbstractGuiElement {
    List<MenuRoomDisplay> rooms;

    @Override
    protected void build() {
        BorderPane pane = new BorderPane();

        Group roomsGroup = new Group();
        for(MenuRoomDisplay room: rooms) {
            roomsGroup.getChildren().add(room.getNode());
        }
        pane.setCenter(roomsGroup);

        Button createRoomButton = new Button("Create new Room");
        createRoomButton.setOnAction(event -> createRoom());

        pane.setBottom(createRoomButton);
        node = pane;
    }

    private void createRoom() {
        IEvent event = new Event();
        event.addParameter("type", UnoProtocol.MESSAGE_ROOM);
        event.addParameter("action", "create");

        notifyObservers(event);
    }

    @Override
    public void update(Observable o, IEvent event) {
        int type = (int) event.getParameter("type");
        if (type == UnoProtocol.MESSAGE_ROOM) {
            handleRoomMessage(event);
        }
    }

    private void handleRoomMessage(IEvent event) {
        String action = (String) event.getParameter("action");
        UnoRoom room = event.getParameter(UnoRoom.class);
        switch (action) {
            case "create":
                MenuRoomDisplay newMenuRoomDisplay = new MenuRoomDisplay();
                newMenuRoomDisplay.bindToRoom(room);
                rooms.add(newMenuRoomDisplay);
                break;
            case "remove":
                rooms.forEach(menuRoomDisplay -> {
                    if (menuRoomDisplay.getRoom().equals(room))
                        rooms.remove(menuRoomDisplay);
                });
        }
    }

}
