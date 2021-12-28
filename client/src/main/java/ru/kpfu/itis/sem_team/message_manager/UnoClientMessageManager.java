package ru.kpfu.itis.sem_team.message_manager;

import ru.kpfu.itis.sem_team.listeners.uno_client_listeners.*;

public class UnoClientMessageManager extends ClientMessageManager {

    public void addUnoMessageListeners() {
        addMessageListener(new AddPlayerMessageListener());
        addMessageListener(new CreateRoomMessageListener());
        addMessageListener(new GiveCardMessageListener());
        addMessageListener(new GiveTurnMessageListener());
        addMessageListener(new JoinRoomMessageListener());
        addMessageListener(new LeaveRoomMessageListener());
        addMessageListener(new PlayCardMessageListener());
        addMessageListener(new RemoveRoomMessageListener());
        addMessageListener(new SayNoUnoMessageListener());
        addMessageListener(new SayUnoMessageListener());
        addMessageListener(new StartGameMessageListener());
    }
}
