package ru.kpfu.itis.sem_team.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.kpfu.itis.sem_team.app.GuiUno;
import ru.kpfu.itis.sem_team.views.MenuView;

public class UnoGraphics extends Application {
    private Stage stage;
    private MenuView menuView;

    public UnoGraphics(GuiUno unoApp) {
        init(unoApp);
    }

    private void init(GuiUno unoApp) {

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage.show();
    }


    public void displayMenu() {
        stage.setScene(new Scene(menuView.asParent()));
    }

    public void displayRoom() {}

}
