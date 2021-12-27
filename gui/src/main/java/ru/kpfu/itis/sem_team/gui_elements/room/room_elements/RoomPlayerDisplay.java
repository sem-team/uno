package ru.kpfu.itis.sem_team.gui_elements.room.room_elements;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.gui_elements.AbstractGuiElement;

public class RoomPlayerDisplay extends AbstractGuiElement {
    private UnoPlayer player;


    @Override
    protected void build() {
        VBox panel = new VBox();

        panel.getChildren().add(new Label(player.getName()));

        node = panel;
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
