package ru.kpfu.itis.sem_team.gui_graphics;

import javafx.scene.Parent;
import javafx.scene.Scene;

public abstract class AbstractGuiGraphics extends AbstractGuiElement {
    private Scene scene;

    public Scene getScene() {
        if (scene == null) {
            scene = new Scene((Parent) getNode());
        }
        return scene;
    }

}
