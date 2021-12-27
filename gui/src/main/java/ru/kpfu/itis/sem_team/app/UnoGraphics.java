package ru.kpfu.itis.sem_team.app;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.kpfu.itis.sem_team.gui_graphics.game.GameGraphics;
import ru.kpfu.itis.sem_team.gui_graphics.menu.MenuGraphics;
import ru.kpfu.itis.sem_team.gui_graphics.room.RoomGraphics;

public class UnoGraphics extends Application {
    private Stage stage;
    private MenuGraphics menuGraphics;
    private RoomGraphics roomGraphics;
    private GameGraphics gameGraphics;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setMenu();
        stage.show();
    }

    public void setMenu() {
        stage.setScene(menuGraphics.getScene());
    }

    public void setRoom() {
        stage.setScene(roomGraphics.getScene());
    }

    public void setGame() {
        stage.setScene(gameGraphics.getScene());
    }
}
