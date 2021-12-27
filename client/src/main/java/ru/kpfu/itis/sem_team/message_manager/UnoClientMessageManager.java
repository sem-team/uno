package ru.kpfu.itis.sem_team.message_manager;

import ru.kpfu.itis.sem_team.client.IClient;

public class UnoClientMessageManager extends ClientMessageManager {

    @Override
    public void register(IClient client) {
        super.register(client);
        init();
    }

    private void init() {
        this.addMessageListener(new GetAppMessageListener());
    }
}
