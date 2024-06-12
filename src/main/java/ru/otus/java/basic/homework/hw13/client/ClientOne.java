package ru.otus.java.basic.homework.hw13.client;

import ru.otus.java.basic.homework.hw13.Operation;
import ru.otus.java.basic.homework.hw13.OperationsEnum;
import ru.otus.java.basic.homework.hw13.server.PingServer;

import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ClientOne {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    protected static void start() {
        try (Socket socket = new Socket("localhost", PingServer.PORT);
             PingClient pingClient = new PingClient(socket)) {
            while (!pingClient.receive()) {

            }
            while (true) {
                var op = new Operation();
                var intPattern = Pattern.compile("\\d{1,3}$");
                var opPattern = Pattern.compile("[-+*]{1}$");

                var intMessage = "Калькулятор может произвести операцию только с целочисленным значением не более 3 знаков.";

                System.out.println("Введите первый операнд:");
                tryWile(intPattern, intMessage);
                op.setOperandOne(scanner.nextInt());

                System.out.println("Введите операцию:");
                tryWile(opPattern, "Допустимые операции: - + *");
                op.setOperation(OperationsEnum.tryParse(scanner.next(opPattern).charAt(0)));
                System.out.println("Введите второй операнд:");
                tryWile(intPattern, intMessage);
                op.setOperandTwo(scanner.nextInt());

                pingClient.send(op);
                pingClient.read();


                System.out.println("Наигрались? Y/N");
                var exit = scanner.next();
                if (exit.equalsIgnoreCase("Y")) {
                    break;
                }
            }

        } catch (Error | Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    private static void tryWile(Pattern pattern, String message) {
        while (!scanner.hasNext(pattern)) {
            System.out.println(message);
            scanner.next();
        }
    }
}
