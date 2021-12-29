package ru.kpfu.itis.sem_team.gui.controllers;

import ru.kpfu.itis.sem_team.entities.cards.Color;
import ru.kpfu.itis.sem_team.gui.services.IDisplayService;
import ru.kpfu.itis.sem_team.gui.services.IMessageService;

import javax.smartcardio.Card;

public class GameController {
    IDisplayService displayService;
    IMessageService messageService;

    public GameController(IDisplayService displayService, IMessageService messageService) {
        this.displayService = displayService;
        this.messageService = messageService;
    }

    public void playCard(Card card) {}

    public void chooseColor(Color color) {}

    public void sayUno() {}

    public void sayNoUno() {}
    //MY
}
