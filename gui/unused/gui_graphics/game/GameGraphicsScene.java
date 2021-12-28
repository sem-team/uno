package ru.kpfu.itis.sem_team.gui_graphics.game;

import javafx.scene.Parent;
import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.gui_graphics.AbstractGraphicsScene;

public class GameGraphicsScene extends AbstractGraphicsScene {
    private UnoGame game;

    @Override
    protected void build() {
    }

    public void bindToGame(UnoGame game) {
        this.game = game;
        this.addObserver(game);
        game.addObserver(this);
    }


    @Override
    public Parent getGraphics() {
        return null;
    }
}
