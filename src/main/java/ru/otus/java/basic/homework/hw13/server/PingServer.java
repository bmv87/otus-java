package ru.otus.java.basic.homework.hw13.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class PingServer {
    public static final int PORT = 7777;
    public static List<SocketWrapper> serverList = new ArrayList<>(); // список всех нитей

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            while (true) {
                var client = serverSocket.accept();
                System.out.println("Client connected: " + client.getRemoteSocketAddress());

                try {
                    var wrapper = new SocketWrapper(client);

                    wrapper.send("Доступные операции: +/-/*");

                    serverList.add(wrapper);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            for (SocketWrapper socketWrapper : serverList) {
                socketWrapper.close();
            }
        }
    }
}
