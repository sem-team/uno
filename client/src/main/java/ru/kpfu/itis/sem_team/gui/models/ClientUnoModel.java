package ru.kpfu.itis.sem_team.gui.models;

import ru.kpfu.itis.sem_team.models.UnoModel;
import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.menus.UnoMenu;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;

public class ClientUnoModel extends UnoModel {
    private UnoMenu menu;
    private UnoPlayer currentPlayer;

    public ClientUnoModel() {
        super();
    }

    public UnoPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public UnoRoom getCurrentRoom() {
        for (AbstractRoom room : getMenu().getRooms()) {
            if (room.getParticipants().contains(currentPlayer))
                return (UnoRoom) room;
        }
        return null;
    }

    public void setCurrentPlayer(UnoPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public UnoGame getCurrentGame() {
        return (UnoGame) getCurrentRoom().getGame();
    }

}
