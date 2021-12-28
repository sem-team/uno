package ru.kpfu.itis.sem_team.entities.menus;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;
import ru.kpfu.itis.sem_team.entities.rooms.GuiUnoRoom;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.util.Observable;

import java.util.List;

public class GuiUnoMenu extends UnoMenu {
    private UnoMenu menu;
    private UnoPlayer currentPlayer;
    private Screen screen;
    private Group rooms;

    public GuiUnoMenu(UnoMenu menu) {
        this.menu = menu;
    }

    public Screen getScreen() {
        if (screen == null) build();
        return screen;
    }

    private void build() {
        Group rooms = new Group();
        for (AbstractRoom room : getRooms()) {
            GuiUnoRoom guiUnoRoom = (GuiUnoRoom) room;
            rooms.getChildren().add(guiUnoRoom.getMenuDisplay());
        }

        Button createRoomButton = new Button("Create room");
        createRoomButton.setOnf
    }



    @Override
    public void addPlayer(AbstractPlayer player) {
        menu.addPlayer(player);
    }

    @Override
    public void removePlayer(AbstractPlayer player) {
        menu.removePlayer(player);
    }

    @Override
    public void addRoom(AbstractRoom room) {
        GuiUnoRoom guoUnoRoom = new GuiUnoRoom((UnoRoom) room, currentPlayer);
        menu.addRoom(guoUnoRoom);
        rooms.getChildren().add(guoUnoRoom.getMenuDisplay());
    }

    @Override
    public void removeRoom(AbstractRoom room) {
        menu.removeRoom(room);
    }

    @Override
    public List<AbstractRoom> getRooms() {
        return menu.getRooms();
    }

    @Override
    public void setRooms(List<AbstractRoom> rooms) {
        menu.setRooms(rooms);
    }

    @Override
    public List<AbstractPlayer> getPlayers() {
        return menu.getPlayers();
    }

    @Override
    public void setPlayers(List<AbstractPlayer> players) {
        menu.setPlayers(players);
    }

    @Override
    public boolean isPlayerValid(AbstractPlayer newPlayer) {
        return menu.isPlayerValid(newPlayer);
    }

    @Override
    public AbstractRoom getRoom(AbstractRoom providedRoom) {
        return menu.getRoom(providedRoom);
    }

    @Override
    public AbstractPlayer getPlayer(AbstractPlayer providedPlayer) {
        return menu.getPlayer(providedPlayer);
    }

    @Override
    public AbstractRoom getRoomByPlayer(AbstractPlayer player) {
        return menu.getRoomByPlayer(player);
    }

    @Override
    public void update(Observable o, IEvent event) {
        menu.update(o, event);
    }

    @Override
    public UnoPlayer getPlayerByName(String playerName) {
        return menu.getPlayerByName(playerName);
    }
}
