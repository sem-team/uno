package ru.kpfu.itis.sem_team.client;

import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.message_manager.IClientMessageManager;

import java.io.Closeable;

public interface IClient extends Closeable {
    void connect();
    void sendMessage(IMessage message);
    void listen();
    IClientMessageManager getMessageManager();
    void setMessageManager(IClientMessageManager manager);
}
