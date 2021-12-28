package ru.kpfu.itis.sem_team.gui.views;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ru.kpfu.itis.sem_team.gui.controllers.RoomController;
import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;
import ru.kpfu.itis.sem_team.util.Observable;

public class RoomView implements IView {
    private UnoRoom room;
    private RoomController controller;
    private BorderPane view;

    public RoomView(UnoRoom room, RoomController controller) {
        this.room = room;
        this.controller = controller;
        room.addObserver(this);

        buildView();
    }

    private void buildView() {
        if (view == null) {
            view = new BorderPane();
        }
        view.getStyleClass().add("menuStage");
        HBox playersBox = new HBox();
        playersBox.setSpacing(20);
        playersBox.setAlignment(Pos.CENTER);
        AbstractPlayer admin = room.getAdmin();
        Label label = new Label(admin.getName());
        label.getStyleClass().add("label");
        playersBox.getChildren().add(label);

        room.getParticipants().stream()
                .filter(player -> !player.equals(admin))
                .forEach(player -> playersBox.getChildren().add(new Label(player.getName())));

        view.setCenter(playersBox);

        VBox buttonsBox = new VBox();
        buttonsBox.setAlignment(Pos.CENTER);
        Button joinRoomButton = new Button("Start");
        joinRoomButton.getStyleClass().add("menuBtn");
        joinRoomButton.setOnAction(event -> controller.startGame());
        buttonsBox.getChildren().add(joinRoomButton);

        Button leaveRoomButton = new Button("Leave");
        leaveRoomButton.setOnAction(event -> controller.leaveRoom());
        buttonsBox.getChildren().add(leaveRoomButton);
        leaveRoomButton.getStyleClass().add("menuBtn");
        buttonsBox.setSpacing(20);
        buttonsBox.setPadding(new Insets(10,10,10,10));
        view.setBottom(buttonsBox);
    }

    @Override
    public Parent asParent() {
        return view;
    }

    @Override
    public void update(Observable o, IEvent event) {
        Integer type = (Integer) event.getParameter("type");
        String action = (String) event.getParameter("action");

        if (type == UnoProtocol.MESSAGE_GAME && action.equals("start")) {
            controller.displayGame();
            return;
        }

        Platform.runLater(this::buildView);
    }
}
