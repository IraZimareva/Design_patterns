package ex23;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyProxy {
    public double getMultipl (double first, double second){
        try {
            Socket clientSocket = new Socket(InetAddress.getLocalHost(), 5000); //"128.71.125.90"

            DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream is = new DataInputStream(clientSocket.getInputStream());

            os.writeDouble(first);
            os.writeDouble(second);

            double result = is.readDouble();

            os.close();
            is.close();
            clientSocket.close();

            return result;
        }

        catch (UnknownHostException e) {
            System.err.println("Неизвестный хост");
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println("Соединение не установлено");
            System.exit(1);
        }

        return 0;
    }
}

// На клиенте разработать прокси-класс, содержащий метод для перемножения двух вещественных чисел,
// но не осуществляющий собственно перемножение,
// а отправляющий эти два числа в серверную часть (порт 5000)
// и возвращающий ответ сервера в качестве результата.
