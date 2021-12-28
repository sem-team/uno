package ru.kpfu.itis.sem_team.gui_graphics.room.room_elements;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.gui_graphics.AbstractGraphicsElement;

public class RoomPlayerDisplay extends AbstractGraphicsElement {
    private UnoPlayer player;


    @Override
    protected void build() {
        VBox panel = new VBox();

        panel.getChildren().add(new Label(player.getName()));
    }

    public void bindToPlayer(UnoPlayer player) {
        this.player = player;
        addObserver(player);
        player.addObserver(this);
    }

    public UnoPlayer getPlayer() {
        return player;
    }
}
