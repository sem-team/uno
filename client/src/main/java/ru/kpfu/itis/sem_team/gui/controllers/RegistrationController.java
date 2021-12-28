package ru.kpfu.itis.sem_team.gui.controllers;

import ru.kpfu.itis.sem_team.gui.services.IDisplayService;
import ru.kpfu.itis.sem_team.gui.services.IMessageService;
import ru.kpfu.itis.sem_team.entities.players.UnoPlayer;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.message.Message;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class RegistrationController {
    IDisplayService displayService;
    IMessageService messageService;

    public RegistrationController(IDisplayService displayService, IMessageService messageService) {
        this.displayService = displayService;
        this.messageService = messageService;
    }

    public void displayMenu() {
        displayService.displayMenu();
    }

    public void register(UnoPlayer player) {
        IMessage message = new Message();
        message.addParameter("type", UnoProtocol.MESSAGE_PLAYER);
        message.addParameter("action", "create");
        message.addParameter("player", player);

        messageService.sendMessage(message);
    }
}
