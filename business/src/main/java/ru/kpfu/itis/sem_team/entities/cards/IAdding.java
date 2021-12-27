package ru.kpfu.itis.sem_team.entities.cards;

import ru.kpfu.itis.sem_team.entities.boards.UnoBoard;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;

public interface IAdding {
    public void addCards(UnoPlayer player, int number, UnoBoard board);
}
