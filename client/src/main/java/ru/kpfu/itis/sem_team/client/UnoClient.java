package ru.kpfu.itis.sem_team.client;

import ru.kpfu.itis.sem_team.app.GuiUno;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.message.Message;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class UnoClient extends Client {
    private GuiUno unoApp;

    public UnoClient(String host, int port) {
        super(host, port);
    }

    @Override
    public void connect() {
        super.connect();
        init();
    }

    private void init() {
        fetchApp();
    }

    private void fetchApp() {
        IMessage message = new Message();
        message.addParameter("type", UnoProtocol.MESSAGE_APP);
        message.addParameter("action", "get");
        sendMessage(message);
    }

    public GuiUno getUnoApp() {
        return unoApp;
    }

    public void setUnoApp(GuiUno unoApp) {
        this.unoApp = unoApp;
    }
}
