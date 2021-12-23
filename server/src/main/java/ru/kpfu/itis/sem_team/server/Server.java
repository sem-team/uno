package ru.kpfu.itis.sem_team.server;

import ru.kpfu.itis.sem_team.exceptions.ServerException;
import ru.kpfu.itis.sem_team.listeners.IServerEventListener;
import ru.kpfu.itis.sem_team.message.IMessage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Server implements IServer {
    private ServerSocketChannel server;
    private Selector selector;
    private final List<IServerEventListener> listeners;
    private final int port;
    private final List<SocketChannel> channels;

    public Server(int port) {
        this.listeners = new ArrayList<>();
        this.channels = new ArrayList<>();
        this.port = port;
    }

    @Override
    public void init() {
        try {
            server = ServerSocketChannel.open();
            InetSocketAddress addr = new InetSocketAddress(this.port);

            server.bind(addr);
            server.configureBlocking(false);

            selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("Server started");
        } catch (IOException e) {
            throw new ServerException("Unable to start server", e);
        }
    }

    @Override
    public void listen() {
        while (selector.isOpen()) {
            try {
                int num = selector.select();
                if (num == 0) continue;
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while(it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    processKey(key);
                }
            } catch (IOException e) {
                throw new ServerException("Something happened while listening for new messages", e);
            }
        }
    }

    private void processKey(SelectionKey key) {
        if (key.isAcceptable()) {
            acceptConnection();
        }
        else if (key.isReadable()) {
            SocketChannel channel = (SocketChannel) key.channel();
            readMessage(channel);
        }
    }

    private void acceptConnection() {
        try {
            SocketChannel channel = server.accept();
            System.out.println("New connection "+ channel);
            channels.add(channel);
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } catch (IOException e) {
            throw new ServerException("Unable to accept connection", e);
        }
    }

    private void readMessage(SocketChannel channel) {
        try {
            int connectionId = channels.indexOf(channel);
            //get message size
            ByteBuffer messageSizeBuffer = ByteBuffer.allocate(4);
            channel.read(messageSizeBuffer);
            messageSizeBuffer.rewind();
            int messageSize = messageSizeBuffer.getInt();

            if (messageSize == 0) {
                closeConnection(connectionId);
                return;
            }

            //deserialize message
            ByteBuffer messageBuffer = ByteBuffer.allocate(messageSize);
            channel.read(messageBuffer);
            messageBuffer.rewind();
            ObjectInputStream ois = new ObjectInputStream( new ByteArrayInputStream(messageBuffer.array()));
            IMessage message = (IMessage) ois.readObject();

            //pass message to listeners
            listeners.forEach(listener -> listener.handle(connectionId, message));

        } catch (ClassNotFoundException | IOException e) {
            throw new ServerException("Unable to read message", e);
        }
    }

    private void closeConnection(int connectionId) {
        try {
            SocketChannel channel = channels.get(connectionId);
            channel.close();
            System.out.println("Connection " + connectionId + " closed");
        } catch (IOException e) {
            throw new ServerException("Unable to close connection", e);
        }
    }

    @Override
    public void addEventListener(IServerEventListener eventListener) {
        eventListener.init(this);
        listeners.add(eventListener);
    }

    @Override
    public void sendMessage(int connectionId, IMessage message) {
        try {
            SocketChannel channel = channels.get(connectionId);
            ByteBuffer messageBuffer = ByteBuffer.wrap(message.formMessage());
            channel.write(messageBuffer);
        } catch (IOException e) {
            throw new ServerException("Unable to send message", e);
        }
    }
}
