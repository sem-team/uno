package ru.kpfu.itis.sem_team.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.kpfu.itis.sem_team.client.UnoClient;
import ru.kpfu.itis.sem_team.gui.services.*;
import ru.kpfu.itis.sem_team.gui.views.MenuView;
import ru.kpfu.itis.sem_team.gui.controllers.MenuController;
import ru.kpfu.itis.sem_team.gui.controllers.RegistrationController;
import ru.kpfu.itis.sem_team.gui.controllers.RoomController;
import ru.kpfu.itis.sem_team.gui.views.RegistrationView;
import ru.kpfu.itis.sem_team.gui.views.RoomView;
import ru.kpfu.itis.sem_team.message_manager.ClientMessageManager;
import ru.kpfu.itis.sem_team.message_manager.IClientMessageManager;
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
        IClientMessageManager manager = new ClientMessageManager();
        manager.register(client);

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
        build();
        displayMenu();
        stage.show();
    }

    public void displayMenu() {
        stage.setScene(new Scene(menuView.asParent()));
    }

    public void displayRoom() {
        //create view when new room is selected
        roomView = new RoomView(client.getModel().getCurrentRoom(), roomController);
        stage.setScene(new Scene(roomView.asParent()));
    }

    public static void main(String[] args) {
        launch(args);
    }

}
