package ru.kpfu.itis.sem_team.client;

import ru.kpfu.itis.sem_team.exceptions.ClientException;
import ru.kpfu.itis.sem_team.listeners.IClientEventListener;
import ru.kpfu.itis.sem_team.message.IMessage;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client implements IClient{
    private final List<IClientEventListener> eventListeners;
    private Thread listenThread;
    private SocketChannel channel;
    private Selector selector;
    private String host;
    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
        eventListeners = new ArrayList<>();
    }


    @Override
    public void connect() {
        try {
            InetAddress hostAddress = InetAddress.getByName(host);
            InetSocketAddress clientAddress = new InetSocketAddress(hostAddress, port);

            channel = SocketChannel.open(clientAddress);

            selector = Selector.open();
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);

            System.out.println("Own address " + channel);
            System.out.println("Connected to server " + host + ":" + port);
        } catch (IOException e) {
            throw new ClientException("Unable to connect to server", e);
        }
    }

    @Override
    public void sendMessage(IMessage message) {
        try {
            ByteBuffer messageBuffer = ByteBuffer.wrap(message.formMessage());
            channel.write(messageBuffer);
        } catch (IOException e) {
            throw new ClientException("Unable to send message", e);
        }
    }

    @Override
    public void listen() {
        listenThread = new Thread(() -> {
            while (selector.isOpen()) {
                try {
                    int num = selector.selectNow();
                    if (num == 0) continue;
                    Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                    while(it.hasNext()) {
                        SelectionKey key = it.next();
                        processKey(key);
                        it.remove();
                    }
                } catch (IOException e) {
                    throw new ClientException("Something happened while listening for new messages", e);
                }
            }
        });
        listenThread.start();
    }

    private void processKey(SelectionKey key) {
        if (!key.isValid()) {
            return;
        }

        if (key.isReadable()) {
            readMessage();
        }
    }

    private void readMessage() {
        try {

            // get message size
            ByteBuffer messageSizeBuffer = ByteBuffer.allocate(4);
            channel.read(messageSizeBuffer);
            messageSizeBuffer.rewind();
            int messageSize = messageSizeBuffer.getInt();

            // get message
            ByteBuffer messageBuffer = ByteBuffer.allocate(messageSize);
            channel.read(messageBuffer);
            messageBuffer.rewind();
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(messageBuffer.array()));
            IMessage message = (IMessage) ois.readObject();

            //pass message to listeners
            eventListeners.forEach(eventListener -> eventListener.handle(message));
        } catch (IOException | ClassNotFoundException e) {
            throw new ClientException("Unable to get message", e);
        }
    }

    @Override
    public void addListener(IClientEventListener eventListener) {
        eventListener.init(this);
        eventListeners.add(eventListener);
    }

    @Override
    public void close() throws IOException {
        //TODO: make client close correctly, currently the app is still up even after connection is closed, probably
        //      it's related to threads
        listenThread.interrupt();
        channel.close();
        System.out.println("Connection closed");
    }
}
