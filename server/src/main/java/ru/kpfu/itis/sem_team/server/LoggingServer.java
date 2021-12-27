package ru.kpfu.itis.sem_team.server;

import ru.kpfu.itis.sem_team.message.IMessage;
import ru.kpfu.itis.sem_team.message_logger.IMessageLogger;

public class LoggingServer extends Server {
    private IMessageLogger logger;

    public LoggingServer(IMessageLogger logger, int port) {
        super(port);
        this.logger = logger;
    }

    @Override
    public void sendMessage(int connectionId, IMessage message) {
        super.sendMessage(connectionId, message);
        logger.logMessage(message);
    }

    @Override
    public void sendMessageBroadcast(IMessage message) {
        super.sendMessageBroadcast(message);
        logger.logMessage(message);
    }

    public IMessageLogger getLogger() {
        return logger;
    }
}
