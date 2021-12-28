package ru.kpfu.itis.sem_team.app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import ru.kpfu.itis.sem_team.client.UnoClient;
import ru.kpfu.itis.sem_team.gui.controllers.GameController;
import ru.kpfu.itis.sem_team.gui.services.*;
import ru.kpfu.itis.sem_team.gui.views.GameView;
import ru.kpfu.itis.sem_team.gui.views.MenuView;
import ru.kpfu.itis.sem_team.gui.controllers.MenuController;
import ru.kpfu.itis.sem_team.gui.controllers.RoomController;
import ru.kpfu.itis.sem_team.gui.views.RoomView;
import ru.kpfu.itis.sem_team.message_manager.UnoClientMessageManager;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

import java.io.File;
import java.io.FileInputStream;

public class UnoGraphics extends Application {
    private Stage stage;
    private MenuView menuView;
    private RoomView roomView;
    private GameView gameView;

    //business logic
    private UnoClient client;

    //services
    private IGameService gameService;
    private IMessageService messageService;
    private IDisplayService displayService;

    //controllers
    private MenuController menuController;
    private RoomController roomController;
    private GameController gameController;


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
        roomController = new RoomController(displayService, gameService, messageService);
        gameController = new GameController(displayService, messageService);

        //create views
        menuView = new MenuView(client.getModel().getMenu(), menuController);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        VBox startBanner = new VBox();
        FileInputStream is = new FileInputStream("./client/images/logo.png");
        Image logo = new Image(is);
        ImageView logoView = new ImageView(logo);
        Button startButton = new Button("Start");
        startButton.setOnAction(event -> displayMenu());
        Media menuMusic = new Media(new File("./client/music/Naell - Музыка для игры в шахматы.mp3").toURI().toString());
        MediaPlayer menuPlayer = new MediaPlayer(menuMusic);
        menuPlayer.setCycleCount(999999999);
        menuPlayer.setVolume(0.3);
        menuPlayer.setAutoPlay(true);
        ToggleButton musicButton = new ToggleButton("Music on/off");
        musicButton.setOnAction(event -> {
            if (musicButton.isSelected()) {
                menuPlayer.pause();
            }else {
                menuPlayer.play();
            }
        });
        startBanner.setSpacing(70);
        startBanner.setAlignment(Pos.CENTER);
        startBanner.getChildren().add(logoView);
        startBanner.getChildren().add(startButton);
        startBanner.getChildren().add(musicButton);
        Scene scene = new Scene(startBanner, 800, 600);
        scene.getStylesheets().add(new File("./client/css/style.css").toURI().toString());
        startButton.getStyleClass().add("menuBtn");
        startBanner.getStyleClass().add("menuStage");
        musicButton.getStyleClass().add("menuBtn");
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

    public void displayGame() {
        //create view when new game started
        gameView = new GameView(client.getModel().getCurrentGame(), gameController);
        stage.getScene().setRoot(gameView.asParent());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
