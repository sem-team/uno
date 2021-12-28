package ru.kpfu.itis.sem_team.event;

import ru.kpfu.itis.sem_team.message.IMessage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Event implements IEvent {
    private Map<String, Object> parameters = new HashMap<>();

    public Event() {
    }

    public Event(Integer type, String action) {
        addParameter("type", type);
        addParameter("action", action);
    }

    @Override
    public Map<String, Object> getParameters() {
        return parameters;
    }

    @Override
    public Object getParameter(String name) {
        return parameters.get(name);
    }

    @Override
    public <T> T getParameter(Class<T> c) {
        Collection<Object> values = parameters.values();
        for(Object value: values) {
            if (value.getClass().equals(c)) {
                return (T) value;
            }
        }
        return null;
    }

    private void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void addParameter(String key, Object value) {
        parameters.put(key, value);
    }

    public static Event from(IMessage message) {
        Event event = new Event();
        event.setParameters(message.getParameters());
        return event;
    }
}
