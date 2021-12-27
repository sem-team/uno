package ru.kpfu.itis.sem_team.server;

import ru.kpfu.itis.sem_team.app.Uno;
import ru.kpfu.itis.sem_team.message_logger.UnoMessageLogger;

public class UnoServer extends LoggingServer {
    private Uno unoApp;

    public UnoServer(UnoMessageLogger logger, int port) {
        super(logger, port);
        init();
    }

    private void init() {
        unoApp = new Uno();
    }

    public Uno getUnoApp() {
        return unoApp;
    }

}
