package ru.kpfu.itis.sem_team.gui.views;

import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.gui.controllers.GameController;
import ru.kpfu.itis.sem_team.util.Observable;

public class GameView implements IView {
    private UnoGame game;
    private GameController controller;
    private Parent view;

    public GameView(UnoGame game, GameController controller) {
        this.game = game;
        this.controller = controller;
        game.addObserver(this);
        buildView();
    }

    private void buildView() {
        if (view == null) {
            view = new BorderPane();
        }
        view.getStyleClass().add("gameStage");
    }

    @Override
    public Parent asParent() {
        return view;
    }

    @Override
    public void update(Observable o, IEvent event) {

    }
}
