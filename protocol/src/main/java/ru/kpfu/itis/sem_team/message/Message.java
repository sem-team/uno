package ru.kpfu.itis.sem_team.message;
import ru.kpfu.itis.sem_team.exceptions.MessageException;

import java.io.*;
import java.util.*;

public class Message implements IMessage {
    private final Map<String, Object> parameters;

    public Message() {
        this.parameters = new HashMap<>();
    }

    public Message(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(parameters, message.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameters);
    }

    @Override
    public String toString() {
        return "Message{" +
                "parameters=" + parameters +
                '}';
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

    @Override
    public void addParameter(String name, Object value) {
        parameters.put(name, value);
    }

    @Override
    public byte[] formMessage() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.flush();
            byte[] dataBytes = bos.toByteArray();

            int messageSize = dataBytes.length;
            byte[] messageSizeBytes = new byte[4];
            int i = 0;
            messageSizeBytes[i++] = (byte) (messageSize >> 24);
            messageSizeBytes[i++] = (byte) (messageSize >> 16);
            messageSizeBytes[i++] = (byte) (messageSize >> 8);
            messageSizeBytes[i] = (byte) (messageSize /*>> 0*/);

            ByteArrayOutputStream messageBytes = new ByteArrayOutputStream();
            messageBytes.write(messageSizeBytes);
            messageBytes.write(dataBytes);

            return messageBytes.toByteArray();
        } catch (IOException e) {
            throw new MessageException("Unable to serialize message", e);
        }
    }

}
