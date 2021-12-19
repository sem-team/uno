package ru.kpfu.itis.sem_team.server;

import ru.kpfu.itis.sem_team.exceptions.ServerException;
import ru.kpfu.itis.sem_team.listeners.IServerEventListener;
import ru.kpfu.itis.sem_team.message.Message;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server implements IServer, Closeable {
    public static final int DEFAULT_PORT = 27027;
    private final List<IServerEventListener> eventListeners;
    private ServerSocket server;
    private final List<Socket> sockets;
    private final int port;

    public Server(int port) {
        this.port = port;
        this.eventListeners = new ArrayList<>();
        this.sockets = new ArrayList<>();
    }

    public Server() {
        this(DEFAULT_PORT);
    }

    @Override
    public void init() {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
        } catch (IOException e) {
            throw new ServerException("Unable to start server");
        }
    }

    @Override
    public void listen() {
        if (server == null) init();

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("New connection: " + socket.toString());
                handleConnection(socket);
            } catch (IOException e) {
                throw new ServerException("Error occurred while waiting for new connections");
            }
        }
    }

    private void handleConnection(Socket socket) {
        try {
            sockets.add(socket);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            Message message = (Message) ois.readObject();

            int socketId = sockets.lastIndexOf(socket);

            eventListeners.forEach(eventListener -> eventListener.handle(socketId, message));

        } catch (ClassNotFoundException | IOException e) {
            throw new ServerException("Unable to get message", e);
        }
    }

    /**
     * Adds event listener to server, additionally connecting listener to itself,
     * thus connecting it manually is unnecessary.
     */
    @Override
    public void addEventListener(IServerEventListener eventListener) {
        eventListener.init(this);
        eventListeners.add(eventListener);
    }

    @Override
    public void sendMessage(int connectionId, Message message) {
        try {
            Socket socket = sockets.get(connectionId);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            oos.flush();
        } catch (IOException e) {
            throw new ServerException("Unable to send message", e);
        }
    }

    @Override
    public void close() throws IOException {
        if (server != null && !server.isClosed()) {
            server.close();
        }
    }

    public int getPort() {
        return port;
    }
}
