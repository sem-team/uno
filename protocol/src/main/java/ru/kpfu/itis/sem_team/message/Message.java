package ru.kpfu.itis.sem_team.message;
import java.util.HashMap;
import java.util.Map;

public class Message implements IMessage {
    private final Map<String, Object> parameters;

    public Message() {
        this.parameters = new HashMap<>();
    }

    public Message(Map<String, Object> parameters) {
        this.parameters = parameters;
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
    public void addParameter(String name, Object value) {
        parameters.put(name, value);
    }
}
