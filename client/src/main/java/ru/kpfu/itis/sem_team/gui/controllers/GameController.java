package ru.kpfu.itis.sem_team.gui.controllers;

import ru.kpfu.itis.sem_team.gui.services.IDisplayService;
import ru.kpfu.itis.sem_team.gui.services.IMessageService;

public class GameController {
    IDisplayService displayService;
    IMessageService messageService;

    public GameController(IDisplayService displayService, IMessageService messageService) {
        this.displayService = displayService;
        this.messageService = messageService;
    }
}
