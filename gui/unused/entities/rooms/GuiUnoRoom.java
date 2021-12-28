package ru.kpfu.itis.sem_team.entities.rooms;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ru.kpfu.itis.sem_team.entities.games.AbstractGame;
import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.event.Event;
import ru.kpfu.itis.sem_team.event.IEvent;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

import java.util.List;

public class GuiUnoRoom extends AbstractRoom {
    private Parent menuDisplay;
    private AbstractPlayer currentPlayer;
    private UnoRoom room;

    public GuiUnoRoom(UnoRoom room, AbstractPlayer currentPlayer) {
        super(room.getMaxNumberOfParticipants());
        this.currentPlayer = currentPlayer;
        this.room = room;
    }

    public Parent getMenuDisplay() {
        if (menuDisplay == null) buildMenuDisplay();
        return menuDisplay;
    }

    private void buildMenuDisplay() {
        VBox box = new VBox();
        box.getChildren().add(new Label("Admin: " + getAdmin().getName()));
        getParticipants().stream()
                .filter(player -> !player.equals(getAdmin()))
                .forEach(player -> box.getChildren().add(new Label(player.getName())));

        Button enterButton = new Button("Enter group");
        //disable button if currentPlayer is not an admin
        if (room.getAdmin().equals(currentPlayer)) {
            enterButton.setOnAction((event) -> {
                currentPlayer.joinRoom(room);
                notifyJoinedRoom();
            });
        } else {
            enterButton.setDisable(true);
        }
        box.getChildren().add(enterButton);

        menuDisplay = box;
    }

    private void notifyJoinedRoom() {
        IEvent event = new Event();
        event.addParameter("type", UnoProtocol.MESSAGE_PLAYER);
        event.addParameter("action", "connect");
        notifyObservers(event);
    }

    @Override
    public AbstractGame getGame() {
        return room.getGame();
    }

    @Override
    public void delete() {
        room.delete();
    }

    @Override
    public void setGame(AbstractGame game) {
        room.setGame(game);
    }

    @Override
    public List<AbstractPlayer> getParticipants() {
        return room.getParticipants();
    }

    @Override
    public void setParticipants(List<AbstractPlayer> participants) {
        room.setParticipants(participants);
    }

    @Override
    public AbstractPlayer getAdmin() {
        return room.getAdmin();
    }

    @Override
    public void setAdmin(AbstractPlayer admin) {
        room.setAdmin(admin);
    }

    @Override
    public void addPlayer(AbstractPlayer player) {
        room.addPlayer(player);
    }

    @Override
    public void removePlayer(AbstractPlayer player) {
        room.removePlayer(player);
    }

    @Override
    public int getMaxNumberOfParticipants() {
        return room.getMaxNumberOfParticipants();
    }
}
