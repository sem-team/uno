package ru.kpfu.itis.sem_team.views;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import ru.kpfu.itis.sem_team.controllers.MenuController;
import ru.kpfu.itis.sem_team.entities.menus.UnoMenu;
import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;
import ru.kpfu.itis.sem_team.util.Observable;

public class MenuView implements IView {
    private UnoMenu menu;
    private MenuController controller;
    private BorderPane view;

    public MenuView(UnoMenu menu, MenuController controller) {
        this.menu = menu;
        this.controller = controller;
        menu.addObserver(this);

        buildView();
    }

    public void buildView() {
        view = new BorderPane();
        Group roomGroup = new Group();

        for (AbstractRoom room : menu.getRooms()) {
            roomGroup.getChildren().add(buildRoomDisplay((UnoRoom) room));
        }
        view.setCenter(roomGroup);

        Button createRoomButton = new Button("Create room");
        createRoomButton.setOnAction(event -> controller.addRoom());
    }

    public Parent buildRoomDisplay(UnoRoom room) {
        VBox box = new VBox();

        AbstractPlayer admin = room.getAdmin();

        box.getChildren().add(new Label(admin.getName()));

        room.getParticipants().stream()
                .filter(player -> !player.equals(admin))
                .forEach(player -> box.getChildren().add(new Label(player.getName())));

        Button joinRoomButton = new Button("Join");
        joinRoomButton.setOnAction(event -> controller.joinRoom(room));

        return box;
    }


    @Override
    public Parent asParent() {
        return view;
    }

    @Override
    public void update(Observable o, IEvent event) {
        Integer type = (Integer) event.getParameter("type");
        String action = (String) event.getParameter("action");
        if (type == UnoProtocol.MESSAGE_PLAYER & action.equals("join")) {
            controller.displayRoom();
            return;
        }
        // refresh view if other updates occurred
        buildView();
    }
}
