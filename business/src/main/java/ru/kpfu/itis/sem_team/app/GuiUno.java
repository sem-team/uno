package ru.kpfu.itis.sem_team.app;

import ru.kpfu.itis.sem_team.entities.games.UnoGame;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.entities.rooms.AbstractRoom;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.event_manager.IEventManager;
import ru.kpfu.itis.sem_team.event_manager.UnoEventManager;

public class GuiUno extends Uno {
    private UnoGraphics gui;
    private UnoPlayer currentPlayer;
    private IEventManager manager;

    public GuiUno() {
        init();
    }

    private void init() {
        gui = new UnoGraphics();
        manager = new UnoEventManager();
        manager.register(this);
    }

    public UnoGraphics getGraphics() {
        return gui;
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

    public UnoGame getCurrentGame() {
        return (UnoGame) getCurrentRoom().getGame();
    }

    public static GuiUno from(Uno uno) {
        GuiUno guiUno = (GuiUno) uno;
        guiUno.init();
        return guiUno;
    }
}
