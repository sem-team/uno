package ru.kpfu.itis.sem_team.gui.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.gui.controllers.GameController;
import ru.kpfu.itis.sem_team.util.Observable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameView implements IView {
    private UnoGame game;
    private GameController controller;
    private BorderPane view;

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
        int count = game.getNumberOfActivePlayer();
        view.setTop(buildНCardPack());
        if(count == 3) {
            view.setLeft(buildVCardPack());
        }
        if(count == 4) {
            view.setRight(buildVCardPack());
        }

    }

    private Node buildНCardPack(){
        HBox pack = new HBox();
        pack.setAlignment(Pos.CENTER);
        pack.setSpacing(5);
        pack.setPadding(new Insets(10,10,10,10));
        for(int i = 0; i < 8; i++) {
            try (FileInputStream is = new FileInputStream("./client/images/unoCard.png")) {
                Image logo = new Image(is);
                ImageView logoView = new ImageView(logo);
                logoView.setFitHeight(100);
                logoView.setFitWidth(72);
                pack.getChildren().add(logoView);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pack;
    }
    private Node buildVCardPack(){
        VBox pack = new VBox();
        pack.setAlignment(Pos.CENTER);
        pack.setSpacing(5);
        pack.setPadding(new Insets(10,10,10,10));
        for(int i = 0; i < 8; i++) {
            try (FileInputStream is = new FileInputStream("./client/images/unoCard.png")) {
                Image logo = new Image(is);
                ImageView logoView = new ImageView(logo);
                logoView.setFitHeight(100);
                logoView.setFitWidth(72);
                pack.getChildren().add(logoView);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pack;
    }

    @Override
    public Parent asParent() {
        return view;
    }

    @Override
    public void update(Observable o, IEvent event) {
//        Integer type = (Integer) event.getParameter("type");
//        String action = (String) event.getParameter("action");
//        boolean isValid = event.getParameter(Boolean.class);
//
//        if (type == UnoProtocol.MESSAGE_GAME && action.equals("start") && isValid) {
//            controller.
//        }
    }
}
