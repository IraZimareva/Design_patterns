package ex23;

import java.io.IOException;
import java.math.RoundingMode;

public class Client {
    public static void main(String[] args) throws IOException {
        MyProxy proxy = new MyProxy ();
        System.out.printf("Результат = " + proxy.getMultipl(4.8,2.2));
    }
}

// На клиенте разработать прокси-класс, содержащий метод для перемножения двух вещественных чисел,
// но не осуществляющий собственно перемножение,
// а отправляющий эти два числа в серверную часть (порт 5000)
// и возвращающий ответ сервера в качестве результата.