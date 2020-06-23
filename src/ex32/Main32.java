package ex32;

import ex12.Car;

import java.io.FileWriter;
import java.io.IOException;

public class Main32 {
    public static void main(String[] args) throws IOException {
        FileWriter fw1 = new FileWriter("src/ex32/out1.txt");
        Car car1 = new Car("Volvo", 3);
        car1.print(fw1);

        FileWriter fw2 = new FileWriter("src/ex32/out2.txt");
        Car car2 = new Car("Лада", 4);
        car2.print(fw2);
    }
}
