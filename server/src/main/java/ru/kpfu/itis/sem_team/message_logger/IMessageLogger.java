package ru.kpfu.itis.sem_team.message_logger;

import ru.kpfu.itis.sem_team.message.IMessage;

import java.util.List;

public interface IMessageLogger {
    void logMessage(IMessage message);
    List<IMessage> getLogs();
}
