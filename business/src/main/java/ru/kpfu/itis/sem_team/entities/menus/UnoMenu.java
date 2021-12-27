package ru.kpfu.itis.sem_team.entities.menus;


import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;

public class UnoMenu extends AbstractMenu {

    public UnoPlayer getPlayerByName(String playerName) {
        for (AbstractPlayer player: players) {
            if (player.getName().equals(playerName))
                return (UnoPlayer) player;
        }
        return null;
    }

}
