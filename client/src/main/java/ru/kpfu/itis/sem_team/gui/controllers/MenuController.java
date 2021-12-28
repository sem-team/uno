package ru.kpfu.itis.sem_team.gui.controllers;

import ru.kpfu.itis.sem_team.entities.players.AbstractPlayer;
import ru.kpfu.itis.sem_team.gui.services.IDisplayService;
import ru.kpfu.itis.sem_team.gui.services.IGameService;
import ru.kpfu.itis.sem_team.gui.services.IMessageService;
import ru.kpfu.itis.sem_team.entities.rooms.UnoRoom;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.message.Message;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class MenuController {
    private IDisplayService displayService;
    private IGameService gameService;
    private IMessageService messageService;

    public MenuController(IDisplayService displayService, IGameService gameService, IMessageService messageService) {
        this.displayService = displayService;
        this.gameService = gameService;
        this.messageService = messageService;
    }

    public AbstractPlayer getCurrentPlayer() {
        return gameService.getCurrentPlayer();
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
        message.addParameter("action", "connect");
        message.addParameter("player", gameService.getCurrentPlayer());
        message.addParameter("room", room);

        messageService.sendMessage(message);
    }

    public void displayRoom() {
        displayService.displayRoom();
    }

}
