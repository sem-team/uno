package ru.kpfu.itis.sem_team.gui.services;

import ru.kpfu.itis.sem_team.gui.models.ClientUnoModel;
import ru.kpfu.itis.sem_team.entities.games.AbstractGame;
import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;

public class GameService implements IGameService {
    private ClientUnoModel uno;

    public GameService(ClientUnoModel uno) {
        this.uno = uno;
    }

    @Override
    public AbstractPlayer getCurrentPlayer() {
        return uno.getCurrentPlayer();
    }

    @Override
    public AbstractRoom getCurrentRoom() {
        return uno.getCurrentRoom();
    }

    @Override
    public AbstractGame getCurrentGame() {
        return uno.getCurrentGame();
    }
}
