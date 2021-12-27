package ru.kpfu.itis.sem_team.app;

import ru.kpfu.itis.sem_team.event_manager.IEventManager;
import ru.kpfu.itis.sem_team.entities.menus.UnoMenu;
import ru.kpfu.itis.sem_team.event_manager.UnoEventManager;


public class Uno implements IApp {
    private UnoMenu menu;
    private IEventManager manager;

    public Uno() {
        init();
    }

    private void init() {
        // strong relation used to simplify game app's initialization
        menu = new UnoMenu();
        manager = new UnoEventManager();
    }

    public UnoMenu getMenu() {
        return menu;
    }

    public IEventManager getManager() {
        return manager;
    }
}
