package ru.kpfu.itis.sem_team.app;

import ru.kpfu.itis.sem_team.server.IServer;
import ru.kpfu.itis.sem_team.server.Server;

public class Main {
    public static void main(String[] args) {
        IServer server = new Server();
        server.init();

        server.listen();
    }
}
