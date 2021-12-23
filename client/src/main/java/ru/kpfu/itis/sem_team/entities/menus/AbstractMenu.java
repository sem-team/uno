package main.java.ru.kpfu.itis.sem_team.entities.menus;

import main.java.ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import main.java.ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;

import java.util.List;

public abstract class AbstractMenu {
    protected List<AbstractRoom> rooms;
    protected List<AbstractPlayer> players;
}
