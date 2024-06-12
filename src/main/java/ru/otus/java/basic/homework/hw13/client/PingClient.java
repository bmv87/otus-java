package ru.otus.java.basic.homework.hw13.client;

import ru.otus.java.basic.homework.hw13.Operation;
import ru.otus.java.basic.homework.hw13.OperationResult;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PingClient implements Closeable {

    private final ObjectInputStream in; // поток чтения из сокета
    private final ObjectOutputStream out; // поток записи в сокет

    public PingClient(Socket socket) throws IOException {
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }


    public void send(Operation operation) throws IOException {
        synchronized (out) {
            out.writeObject(operation);
            out.flush();
        }
    }

    public void read() throws IOException, ClassNotFoundException {
        Operation op = (OperationResult) in.readObject();
        System.out.println("Результат: " + op.toString());
    }

    public boolean receive() throws IOException {
        String line = null;
        synchronized (in) {
            line = in.readUTF();

            System.out.println(line);
        }
        return line != null && !line.isBlank();
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }
}