package ru.kpfu.itis.sem_team.app;

import ru.kpfu.itis.sem_team.message_logger.UnoMessageLogger;
import ru.kpfu.itis.sem_team.message_managers.UnoServerMessageManager;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;
import ru.kpfu.itis.sem_team.server.IServer;
import ru.kpfu.itis.sem_team.server.UnoServer;

public class Main {
    public static void main(String[] args) {

        UnoMessageLogger logger = new UnoMessageLogger();
        IServer server = new UnoServer(logger, UnoProtocol.STANDARD_PORT);

        UnoServerMessageManager manager = new UnoServerMessageManager();
        manager.register(server);
        manager.addUnoMessageListeners();

        server.listen();
    }
}
