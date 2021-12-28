package ru.kpfu.itis.sem_team.gui.controllers;

import ru.kpfu.itis.sem_team.gui.services.IDisplayService;
import ru.kpfu.itis.sem_team.gui.services.IGameService;
import ru.kpfu.itis.sem_team.gui.services.IMessageService;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.message.Message;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class RoomController {
    private IDisplayService displayService;
    private IGameService gameService;
    private IMessageService messageService;

    public RoomController(IDisplayService displayService, IGameService gameService, IMessageService messageService) {
        this.displayService = displayService;
        this.gameService = gameService;
        this.messageService = messageService;
    }

    public void startGame() {
        IMessage message = new Message();
        message.addParameter("type", UnoProtocol.MESSAGE_GAME);
        message.addParameter("action", "start");
        message.addParameter("player", gameService.getCurrentPlayer());
        message.addParameter("game", gameService.getCurrentRoom());

        messageService.sendMessage(message);
    }

    public void leaveRoom() {
        IMessage message = new Message();
        message.addParameter("type", UnoProtocol.MESSAGE_PLAYER);
        message.addParameter("action", "leave");
        message.addParameter("player", gameService.getCurrentPlayer());
        message.addParameter("room", gameService.getCurrentRoom());

        messageService.sendMessage(message);
    }

    public void displayGame() {
        displayService.displayGame();
    }


}
