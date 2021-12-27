package ru.kpfu.itis.sem_team.client;

import ru.kpfu.itis.sem_team.app.GuiUno;
import ru.kpfu.itis.sem_team.event_manager.IEventManager;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.message.Message;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class UnoClient extends Client {
    private GuiUno unoApp;

    public UnoClient(String host, int port) {
        super(host, port);
        init();
    }

    private void init() {
        getUnoApp();
    }

    public UnoClient(String host, int port, IEventManager manager) {
        super(host, port);
    }

    private void getUnoApp() {
        IMessage message = new Message();
        message.addParameter("type", UnoProtocol.MESSAGE_APP);
        message.addParameter("action", "getState");
        sendMessage(message);
    }

    public GuiUno getApp() {
        return unoApp;
    }
}
