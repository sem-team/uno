package ru.kpfu.itis.sem_team.app;

import ru.kpfu.itis.sem_team.protocol.UnoProtocol;
import ru.kpfu.itis.sem_team.server.IServer;
import ru.kpfu.itis.sem_team.server.Server;

public class Main {
    public static void main(String[] args) {
        IServer server = new Server(UnoProtocol.STANDARD_PORT);
        server.init();

        server.listen();
    }
}
