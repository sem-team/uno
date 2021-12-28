package ru.kpfu.itis.sem_team.models;

import ru.kpfu.itis.sem_team.entities.menus.UnoMenu;


public class UnoModel implements IModel {
    private UnoMenu menu;

    public UnoModel() {
        init();
    }

    private void init() {
        // strong relation used to simplify game app's initialization
        menu = new UnoMenu();
    }

    public UnoMenu getMenu() {
        return menu;
    }

}
