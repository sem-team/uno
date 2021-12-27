package ru.kpfu.itis.sem_team.exceptions;

public class EventListenerException extends RuntimeException {
    public EventListenerException() {
    }

    public EventListenerException(String message) {
        super(message);
    }

    public EventListenerException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventListenerException(Throwable cause) {
        super(cause);
    }

    public EventListenerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
