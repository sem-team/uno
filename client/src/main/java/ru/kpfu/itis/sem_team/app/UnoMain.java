package ru.kpfu.itis.sem_team.app;

import ru.kpfu.itis.sem_team.client.UnoClient;
import ru.kpfu.itis.sem_team.message_manager.IClientMessageManager;
import ru.kpfu.itis.sem_team.message_manager.UnoClientMessageManager;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

import java.io.IOException;

public class UnoMain {
    public static void main(String[] args) {
        try (UnoClient client = new UnoClient("127.0.0.1", UnoProtocol.STANDARD_PORT)) {
            IClientMessageManager manager = new UnoClientMessageManager();
            manager.register(client);

            client.connect();
            client.listen();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
