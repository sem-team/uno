package ru.kpfu.itis.sem_team.gui_graphics;

import javafx.scene.Scene;

public abstract class AbstractGraphicsScene extends AbstractGraphicsElement {
    private Scene scene;

    public Scene getScene() {
        if (scene == null) {
            scene = new Scene(getGraphics());
        }
        return scene;
    }

}
