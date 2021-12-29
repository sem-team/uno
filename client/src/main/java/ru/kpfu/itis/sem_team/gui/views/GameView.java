package ru.kpfu.itis.sem_team.gui.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import ru.kpfu.itis.sem_team.entities.cards.Color;
import ru.kpfu.itis.sem_team.entities.cards.UnoCard;
import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.gui.controllers.GameController;
import ru.kpfu.itis.sem_team.util.Observable;


import javax.smartcardio.Card;
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
        view.setTop(buildНCardPack("UnoCard"));
        if (count == 3) {
            view.setLeft(buildVCardPack("UnoCard"));
        }
        if (count == 4) {
            view.setLeft(buildVCardPack("UnoCard"));
            view.setRight(buildVCardPack("UnoCard"));
        }

        HBox discardPack = new HBox();
        discardPack.setSpacing(5);
        discardPack.getChildren().add(drawCard("UnoCard"));
        discardPack.setAlignment(Pos.CENTER);
        Button uno = new Button("UNO!");
        uno.getStyleClass().add("gameButton");
        discardPack.getChildren().add(uno);
        view.setCenter(discardPack);

        //MY
        HBox playerCard = new HBox();
        playerCard.setSpacing(5);
        playerCard.setAlignment(Pos.CENTER);
        for(int i = 0; i < 8; i++){
            UnoBoard board = (UnoBoard) game.getBoard();
            UnoCard card =  board.getCard();
            String color = card.getColor().toString().toUpperCase();
            if(color.equals("COLORLESS")){
                ImageView cardView = drawCard("Wild_Four");
                Button cardBtn = new Button("",cardView);
                playerCard.getChildren().add(cardBtn);
            }
            else {
                ImageView cardView = drawCard(card.getColor().toString().toUpperCase(), card.getNumber());
                Button cardBtn = new Button("",cardView);
                playerCard.getChildren().add(cardBtn);
            }
            /*
            UnoCard card = game.getNextActivePlayer().getCards().get(i);
            String color = card.getColor().toString();
            int number = game.getNextActivePlayer().getCards().get(i).getNumber();
            ImageView cardView = drawCard(color, number);
            Button cardBtn = new Button("",cardView);
            cardBtn.setOnAction(event -> controller.playCard();

             */
        }
        view.setBottom(playerCard);
    }

    private Node buildНCardPack(String name) {
        HBox pack = new HBox();
        pack.setAlignment(Pos.CENTER);
        pack.setSpacing(5);
        pack.setPadding(new Insets(10, 10, 10, 10));
        for (int i = 0; i < 8; i++) {
            pack.getChildren().add(drawCard(name));
        }
        return pack;
    }

    private ImageView drawCard(String name) {
        ImageView logoView = null;
        try (FileInputStream is = new FileInputStream("./client/images/" + name +".png")) {
            Image logo = new Image(is);
            logoView = new ImageView(logo);
            logoView.setFitHeight(100);
            logoView.setFitWidth(72);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return logoView;
        }
    }


    private ImageView drawCard(String name, int number) {
        ImageView logoView = null;
        try (FileInputStream is = new FileInputStream("./client/images/" + name + number + ".png")) {
            Image logo = new Image(is);
            logoView = new ImageView(logo);
            logoView.setFitHeight(100);
            logoView.setFitWidth(72);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return logoView;
        }
    }

    private Node buildVCardPack(String name){
        VBox pack = new VBox();
        pack.setAlignment(Pos.CENTER);
        pack.setSpacing(5);
        pack.setPadding(new Insets(10,10,10,10));
        for(int i = 0; i < 8; i++) {
            pack.getChildren().add(drawCard(name));
        }
        return pack;
    }

    @Override
    public Parent asParent() {
        return view;
    }

    @Override
    public void update(Observable o, IEvent event) {
        Integer type = (Integer) event.getParameter("type");
        String action = (String) event.getParameter("action");

    }
}
