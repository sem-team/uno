package ru.kpfu.itis.sem_team.client;

import ru.kpfu.itis.sem_team.gui.models.ClientUnoModel;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.message.Message;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

public class UnoClient extends Client {
    private ClientUnoModel model;

    public UnoClient(String host, int port) {
        super(host, port);
        model = new ClientUnoModel();
    }

    @Override
    public void connect() {
        super.connect();
        askCurrentPlayer();
        fetchGameState();
    }

    private void fetchGameState() {
        IMessage message = new Message();
        message.addParameter("type", UnoProtocol.MESSAGE_APP);
        message.addParameter("action", "get");
        sendMessage(message);
    }

    public void askCurrentPlayer() {
        IMessage message = new Message();
        message.addParameter("type", UnoProtocol.MESSAGE_PLAYER);
        message.addParameter("action", "create");
        sendMessage(message);
    }

    public ClientUnoModel getModel() {
        return model;
    }
}
