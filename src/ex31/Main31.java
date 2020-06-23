package ex31;

import ex12.Car;
import ex12.Motorcycle;
import ex12.exceptions.DuplicateModelNameException;

import java.io.IOException;

public class Main31 {
    public static void main(String[] args) throws DuplicateModelNameException, IOException {
        ChainOfResponsibilityMy myHandler = new HandlerLess3();
        Motorcycle moto1 = new Motorcycle("Harley Davidson", 5);
        myHandler.writeToFile(moto1);

        Car car1 = new Car("Volvo", 3);
        myHandler.writeToFile(car1);
        }
    }
