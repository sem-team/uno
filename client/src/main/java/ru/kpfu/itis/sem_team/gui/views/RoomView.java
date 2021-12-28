package ru.kpfu.itis.sem_team.gui.views;

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

        HBox playersBox = new HBox();

        AbstractPlayer admin = room.getAdmin();

        playersBox.getChildren().add(new Label(admin.getName()));

        room.getParticipants().stream()
                .filter(player -> !player.equals(admin))
                .forEach(player -> playersBox.getChildren().add(new Label(player.getName())));

        view.setCenter(playersBox);

        VBox buttonsBox = new VBox();

        Button joinRoomButton = new Button("Start");
        joinRoomButton.setOnAction(event -> controller.startGame());
        buttonsBox.getChildren().add(joinRoomButton);

        Button leaveRoomButton = new Button("Leave");
        leaveRoomButton.setOnAction(event -> controller.leaveRoom());
        buttonsBox.getChildren().add(leaveRoomButton);

        view.setBottom(buttonsBox);
    }

    @Override
    public Parent asParent() {
        return view;
    }

    @Override
    public void update(Observable o, IEvent event) {
        buildView();
    }
}
