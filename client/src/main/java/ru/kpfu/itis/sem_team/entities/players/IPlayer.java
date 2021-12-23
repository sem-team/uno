package main.java.ru.kpfu.itis.sem_team.entities.players;

import main.java.ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;

public interface IPlayer {
    public void joinRoom(AbstractRoom room);
    public void leaveRoom(AbstractRoom room);
    public void createRoom();
    public void deleteRoom(AbstractRoom room);
}
