package ru.kpfu.itis.sem_team.entities.players;

import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;
import ru.kpfu.itis.sem_team.entities.menus.AbstractMenu;

public interface IPlayer {
    public void joinRoom(AbstractRoom room);
    public void leaveRoom(AbstractRoom room);
    public void createRoom(AbstractMenu menu);
    public void deleteRoom(AbstractRoom room);
}
