package ru.kpfu.itis.sem_team.exceptions;

public class MessageManagerException extends RuntimeException {
    public MessageManagerException() {
    }

    public MessageManagerException(String message) {
        super(message);
    }

    public MessageManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageManagerException(Throwable cause) {
        super(cause);
    }

    public MessageManagerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
