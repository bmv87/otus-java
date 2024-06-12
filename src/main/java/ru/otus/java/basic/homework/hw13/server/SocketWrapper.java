package ru.otus.java.basic.homework.hw13.server;

import ru.otus.java.basic.homework.hw13.Operation;
import ru.otus.java.basic.homework.hw13.OperationResult;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketWrapper extends Thread implements Closeable {
    private final Socket socket; // сокет, через который сервер общается с клиентом,
    // кроме него - клиент и сервер никак не связаны
    private final ObjectInputStream in; // поток чтения из сокета
    private final ObjectOutputStream out; // поток записи в сокет

    public SocketWrapper(Socket socket) throws IOException {
        this.socket = socket;
        // если потоку ввода/вывода приведут к генерированию исключения, оно пробросится дальше
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
        start();
    }

    @Override
    public void run() {
        try {
            receive();
        } catch (IOException e) {
            System.out.println("Произошла ошибка. Подключение клиента завершено.");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void receive() throws IOException, ClassNotFoundException {
        while (true) {
            Operation op = null;
            synchronized (in) {
                op = (Operation) in.readObject();
            }
            if (op != null) {
                System.out.println("Запрошена операция: " + op);

                var result = calculate(op);
                send(result);
            }
        }
    }

    private void send(OperationResult result) throws IOException {
        synchronized (out) {
            out.writeObject(result);
            out.flush();
            System.out.println("Отправлен результат: " + result);
        }
    }

    public void send(String msg) throws IOException {
        synchronized (out) {
            out.writeUTF(msg);
            out.flush();
        }
    }

    private OperationResult calculate(Operation operation) throws IOException {
        return switch (operation.getOperation()) {
            case PLUS -> new OperationResult(operation, operation.getOperandOne() + operation.getOperandTwo());
            case MINUS -> new OperationResult(operation, operation.getOperandOne() - operation.getOperandTwo());
            case MULTIPLICATION ->
                    new OperationResult(operation, operation.getOperandOne() * operation.getOperandTwo());
        };
    }

    @Override
    public void close() throws IOException {
        out.close();
        in.close();
        socket.close();
    }
}
