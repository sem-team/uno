package ru.kpfu.itis.sem_team.exceptions;

public class EventManagerException extends RuntimeException {
    public EventManagerException() {
    }

    public EventManagerException(String message) {
        super(message);
    }

    public EventManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventManagerException(Throwable cause) {
        super(cause);
    }

    public EventManagerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
