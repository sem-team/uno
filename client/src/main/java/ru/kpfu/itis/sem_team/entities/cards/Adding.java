package main.java.ru.kpfu.itis.sem_team.entities.cards;

import main.java.ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import main.java.ru.kpfu.itis.sem_team.entities.players.UnoPlayer;

public interface Adding {
    public void addCards(UnoPlayer player, int number, UnoBoard board);
}
