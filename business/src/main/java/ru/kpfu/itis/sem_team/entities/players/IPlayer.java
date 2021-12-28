package ru.kpfu.itis.sem_team.entities.players;

import ru.kpfu.itis.sem_team.exceptions.UnoException;
import ru.kpfu.itis.sem_team.entities.games.AbstractGame;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;
import ru.kpfu.itis.sem_team.entities.menus.AbstractMenu;

import java.io.Serializable;

public interface IPlayer extends Serializable {
    public void joinRoom(AbstractRoom room);
    public void leaveRoom(AbstractRoom room);
    public void createRoom(AbstractMenu menu);
    public void deleteRoom(AbstractRoom room) throws UnoException;
    public void startGame(AbstractGame game) throws UnoException;
}
