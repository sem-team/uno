package ru.kpfu.itis.sem_team.message;

import java.util.Map;


public interface IMessage {
    Map<String, Object> getParameters();
    Object getParameter(String name);
    <T> T getParameter(Class<T> c);
    void addParameter(String name, Object value);
    /**
     * Forms message into byte array suitable for sending by server/client
     */
    byte[] formMessage();
}
