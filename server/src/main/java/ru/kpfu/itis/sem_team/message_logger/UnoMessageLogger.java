package ru.kpfu.itis.sem_team.message_logger;

import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

import java.util.ArrayList;
import java.util.List;

public class UnoMessageLogger implements IMessageLogger {
    public List<IMessage> messages;
    public static final List<Integer> SUITABLE_MESSAGE_TYPES;
    static {
        SUITABLE_MESSAGE_TYPES = new ArrayList<>();
        SUITABLE_MESSAGE_TYPES.add(UnoProtocol.MESSAGE_ROOM);
        SUITABLE_MESSAGE_TYPES.add(UnoProtocol.MESSAGE_PLAYER);
    }

    public UnoMessageLogger() {
        this.messages = new ArrayList<>();
    }

    @Override
    public void logMessage(IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        if (SUITABLE_MESSAGE_TYPES.contains(type) && !messages.contains(message)) {
            messages.add(message);
        }
    }

    @Override
    public List<IMessage> getLogs() {
        return messages;
    }
}
