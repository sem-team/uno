package ru.kpfu.itis.sem_team.message_logger;

import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.protocol.UnoProtocol;

import java.util.ArrayList;
import java.util.List;

public class UnoMessageLogger implements IMessageLogger {
    public List<IMessage> messages;
    public static final List<Integer> SUITABLE_MESSAGE_TYPES;
    public static final List<String> SUITABLE_ACTIONS;
     static {
        SUITABLE_MESSAGE_TYPES = new ArrayList<>();
        SUITABLE_MESSAGE_TYPES.add(UnoProtocol.MESSAGE_ROOM);
        SUITABLE_MESSAGE_TYPES.add(UnoProtocol.MESSAGE_PLAYER);

        SUITABLE_ACTIONS = new ArrayList<>();
        SUITABLE_ACTIONS.add("create");
        SUITABLE_ACTIONS.add("remove");
        SUITABLE_ACTIONS.add("connect");
        SUITABLE_ACTIONS.add("leave");
        SUITABLE_ACTIONS.add("start");
    }

    public UnoMessageLogger() {
        this.messages = new ArrayList<>();
    }

    @Override
    public void logMessage(IMessage message) {
        Integer type = (Integer) message.getParameter("type");
        String action = (String) message.getParameter("action");
        if (SUITABLE_MESSAGE_TYPES.contains(type) && SUITABLE_ACTIONS.contains(action) && !messages.contains(message)) {
            if (type == UnoProtocol.MESSAGE_PLAYER && action.equals("create"))
                return;
            messages.add(message);
        }
    }

    @Override
    public List<IMessage> getLogs() {
        return messages;
    }
}
