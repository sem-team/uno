package ru.kpfu.itis.sem_team.gui.services;

import ru.kpfu.itis.sem_team.entities.games.AbstractGame;
import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;

public interface IGameService {
    AbstractPlayer getCurrentPlayer();
    AbstractRoom getCurrentRoom();
    AbstractGame getCurrentGame();
}
