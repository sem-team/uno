package ru.kpfu.itis.sem_team.app;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UnoGraphics extends Application {
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Group group = new Group();
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane);

    }
}
