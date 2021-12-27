package ru.kpfu.itis.sem_team.exceptions;

public class ClientMessageListenerException extends RuntimeException {
    public ClientMessageListenerException() {
    }

    public ClientMessageListenerException(String message) {
        super(message);
    }

    public ClientMessageListenerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientMessageListenerException(Throwable cause) {
        super(cause);
    }

    public ClientMessageListenerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
