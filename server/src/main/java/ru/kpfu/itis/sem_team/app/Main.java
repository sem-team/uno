package ru.kpfu.itis.sem_team.app;

import ru.kpfu.itis.sem_team.message_managers.IServerMessageManager;
import ru.kpfu.itis.sem_team.message_managers.ServerMessageManager;
import ru.kpfu.itis.sem_team.listeners.ConsolePingServerMessageListener;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;
import ru.kpfu.itis.sem_team.server.IServer;
import ru.kpfu.itis.sem_team.server.Server;

public class Main {
    public static void main(String[] args) {

        IServer server = new Server(UnoProtocol.STANDARD_PORT);

        IServerMessageManager manager = new ServerMessageManager();
        manager.addMessageListener(new ConsolePingServerMessageListener());
        manager.register(server);

        server.init();
        server.listen();
    }
}
