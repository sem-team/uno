package ru.kpfu.itis.sem_team.server;

import ru.kpfu.itis.sem_team.app.Uno;

public class UnoServer extends Server {
    private Uno unoApp;

    public UnoServer(int port) {
        super(port);
        init();
    }

    private void init() {
        unoApp = new Uno();
    }

    public Uno getUnoApp() {
        return unoApp;
    }
}
