package ru.kpfu.itis.sem_team.app;

import ru.kpfu.itis.sem_team.client.Client;
import ru.kpfu.itis.sem_team.listeners.ConsolePingClientMessageListener;
import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.message.Message;
import ru.kpfu.itis.sem_team.message_manager.ClientMessageManager;
import ru.kpfu.itis.sem_team.message_manager.IClientMessageManager;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

import java.io.IOException;


public class TestMain {
    public static void main(String[] args){
        try (Client client = new Client("127.0.0.1", UnoProtocol.STANDARD_PORT)) {
            IClientMessageManager manager = new ClientMessageManager();
            manager.addMessageListener(new ConsolePingClientMessageListener());
            manager.register(client);

            client.connect();
            client.listen();

            for (int i = 0; i < 1; i++) {
                IMessage message = new Message();
                message.addParameter("type", "ping");
                client.sendMessage(message);
                Thread.sleep(1000);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
