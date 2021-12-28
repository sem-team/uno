package ru.kpfu.itis.sem_team.gui.views;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import ru.kpfu.itis.sem_team.gui.controllers.MenuController;
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
    private VBox roomGroup;

    public MenuView(UnoMenu menu, MenuController controller) {
        this.menu = menu;
        this.controller = controller;
        menu.addObserver(this);

        buildView();
    }

    public void buildView() {
        if (view == null) {
            view = new BorderPane();
        }

        roomGroup = new VBox();

        for (AbstractRoom room : menu.getRooms()) {
            roomGroup.getChildren().add(buildRoomDisplay((UnoRoom) room));
        }
        view.setCenter(roomGroup);
        view.getStyleClass().add("menuStage");
        Button createRoomButton = new Button("Create room");
        createRoomButton.getStyleClass().add("menuBtn");
        createRoomButton.setOnAction(event -> controller.addRoom());
        view.setPadding(new Insets(20,20,20,20));
        view.setBottom(createRoomButton);
    }

    public Node buildRoomDisplay(UnoRoom room) {
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        AbstractPlayer admin = room.getAdmin();
        Label label = new Label(admin.getName());
        label.getStyleClass().add("label");
        box.getChildren().add(label);

        room.getParticipants().stream()
                .filter(player -> !player.equals(admin))
                .forEach(player -> box.getChildren().addAll(new Label(player.getName())));

        Button joinRoomButton = new Button("Join");
        joinRoomButton.getStyleClass().add("mainBtn");
        joinRoomButton.setOnAction(event -> controller.joinRoom(room));
        box.getChildren().add(joinRoomButton);

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
        if (type == UnoProtocol.MESSAGE_PLAYER & action.equals("connect")) {
            controller.displayRoom();
            return;
        }
        if (type == UnoProtocol.MESSAGE_ROOM & action.equals("create")) {
            UnoRoom room = event.getParameter(UnoRoom.class);
            if (controller.getCurrentPlayer().equals(room.getAdmin())) {
                controller.displayRoom();
                return;
            }
        }

        // refresh view if other updates occurred
        Platform.runLater(this::buildView);
    }
}
