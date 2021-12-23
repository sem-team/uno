package ru.kpfu.itis.sem_team.client;

import ru.kpfu.itis.sem_team.listeners.IClientEventListener;
import ru.kpfu.itis.sem_team.message.IMessage;

import java.io.Closeable;

public interface IClient extends Closeable {
    void connect();
    void sendMessage(IMessage message);
    void listen();
    void addListener(IClientEventListener eventListener);
}
