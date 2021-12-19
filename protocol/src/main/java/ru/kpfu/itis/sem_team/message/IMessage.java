package ru.kpfu.itis.sem_team.message;

import java.util.Map;


public interface IMessage {
    Map<String, Object> getParameters();
    Object getParameter(String name);
    void addParameter(String name, Object value);
}
