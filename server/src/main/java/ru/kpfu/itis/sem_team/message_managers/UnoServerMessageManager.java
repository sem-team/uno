package ru.kpfu.itis.sem_team.message_managers;

import ru.kpfu.itis.sem_team.listeners.uno_server_listeners.*;

public class UnoServerMessageManager extends ServerMessageManager{

    public void addUnoMessageListeners() {
        addMessageListener( new AddPlayerMessageListener());
        addMessageListener( new CreateRoomMessageListener());
        addMessageListener( new GetAppMessageListener());
        addMessageListener( new GiveCardMessageListener());
        addMessageListener( new GiveTurnMessageListener());
        addMessageListener( new JoinRoomMessageListener());
        addMessageListener( new LeaveRoomMessageListener());
        addMessageListener( new PlayCardMessageListener());
        addMessageListener( new RemoveRoomMessageListener());
        addMessageListener( new SayNoUnoMessageListener());
        addMessageListener( new SayUnoMessageListener());
        addMessageListener( new StartGameMessageListener());
    }
}
