package ru.kpfu.itis.sem_team.services;

import ru.kpfu.itis.sem_team.graphics.UnoGraphics;

public class DisplayService implements IDisplayService {
    private UnoGraphics graphics;

    public DisplayService(UnoGraphics graphics) {
        this.graphics = graphics;
    }


    @Override
    public void displayMenu() {
        graphics.displayMenu();
    }

    @Override
    public void displayRoom() {
        graphics.displayRoom();
    }

    @Override
    public void displayGame() {

    }
}
