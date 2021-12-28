package ru.kpfu.itis.sem_team.controllers;

import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.message.Message;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;
import ru.kpfu.itis.sem_team.services.IDisplayService;
import ru.kpfu.itis.sem_team.services.IGameService;
import ru.kpfu.itis.sem_team.services.IMessageService;

public class MenuController {
    private IDisplayService displayService;
    private IGameService gameService;
    private IMessageService messageService;

    public MenuController(IDisplayService displayService, IGameService gameService, IMessageService messageService) {
        this.displayService = displayService;
        this.gameService = gameService;
        this.messageService = messageService;
    }

    public void addRoom() {
        IMessage message = new Message();
        message.addParameter("type", UnoProtocol.MESSAGE_ROOM);
        message.addParameter("action", "create");
        message.addParameter("player", gameService.getCurrentPlayer());

        messageService.sendMessage(message);
    }

    public void joinRoom(UnoRoom room) {
        IMessage message = new Message();
        message.addParameter("type", UnoProtocol.MESSAGE_PLAYER);
        message.addParameter("action", "join");
        message.addParameter("player", gameService.getCurrentPlayer());
        message.addParameter("room", room);
    }

    public void displayRoom() {
        displayService.displayRoom();
    }

}
