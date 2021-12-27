package ru.kpfu.itis.sem_team.event;

import java.util.Map;

public interface IEvent {
    Map<String, Object> getParameters();
    Object getParameter(String name);
    <T> T getParameter(Class<T> c);
    void addParameter(String key, Object value);
}
