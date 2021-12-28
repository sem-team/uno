package ru.kpfu.itis.sem_team.server;

import ru.kpfu.itis.sem_team.models.UnoModel;
import ru.kpfu.itis.sem_team.message_logger.UnoMessageLogger;

public class UnoServer extends LoggingServer {
    private UnoModel unoModelApp;

    public UnoServer(UnoMessageLogger logger, int port) {
        super(logger, port);
        init();
    }

    private void init() {
        unoModelApp = new UnoModel();
    }

    public UnoModel getUnoApp() {
        return unoModelApp;
    }

}
