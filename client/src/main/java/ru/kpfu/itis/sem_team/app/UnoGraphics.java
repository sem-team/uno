package ru.kpfu.itis.sem_team.app;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.kpfu.itis.sem_team.client.UnoClient;
import ru.kpfu.itis.sem_team.gui.services.*;
import ru.kpfu.itis.sem_team.gui.views.MenuView;
import ru.kpfu.itis.sem_team.gui.controllers.MenuController;
import ru.kpfu.itis.sem_team.gui.controllers.RoomController;
import ru.kpfu.itis.sem_team.gui.views.RoomView;
import ru.kpfu.itis.sem_team.message_manager.UnoClientMessageManager;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class UnoGraphics extends Application {
    private Stage stage;
    private MenuView menuView;
    private RoomView roomView;

    //business logic
    private UnoClient client;

    //services
    IGameService gameService;
    IMessageService messageService;
    IDisplayService displayService;

    //controllers
    MenuController menuController;
    RoomController roomController;

    private void build() {
        client = new UnoClient("127.0.0.1", UnoProtocol.STANDARD_PORT);
        UnoClientMessageManager manager = new UnoClientMessageManager();
        manager.register(client);
        manager.addUnoMessageListeners();

        client.connect();
        client.listen();


        //create services
        gameService = new GameService(client.getModel());
        messageService = new MessageService(client);
        displayService = new DisplayService(this);

        //create controllers
        menuController = new MenuController(displayService, gameService, messageService);
        roomController = new RoomController(gameService, messageService);

        //create views
        menuView = new MenuView(client.getModel().getMenu(), menuController);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        BorderPane startBanner = new BorderPane();
        startBanner.setStyle("-fx-background-color: #F55;");
        Button startButton = new Button("Start");
        startButton.setOnAction(event -> displayMenu());
        startBanner.setCenter(startButton);

        Scene scene = new Scene(startBanner, 600, 800);
        stage.setScene(scene);
        stage.show();

        build();
    }

    public void displayMenu() {
        stage.getScene().setRoot(menuView.asParent());
    }

    public void displayRoom() {
        //create view when new room is selected
        roomView = new RoomView(client.getModel().getCurrentRoom(), roomController);
        stage.getScene().setRoot(roomView.asParent());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
