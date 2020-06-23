package ex23;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket (5000);
            System.out.println("Жду клиента");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Соединение установлено");

            DataInputStream is = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());

            double first = is.readDouble();
            double second = is.readDouble();
            double result = first * second;

            os.writeDouble(result);

            is.close();
            os.close();
            serverSocket.close();
        }
        catch (IOException e) {
            System.out.println(
                    "Error");
            System.exit(-1);
        }
    }
}

// Серверное приложение должно прослушивать порт 5000
// и выполнять операцию умножения двух вещественных чисел для подключающихся клиентов.

// Проиллюстрировать работу клиента в методе main().