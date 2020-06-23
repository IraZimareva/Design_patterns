package ex42;

import ex12.Car;
import ex12.exceptions.DuplicateModelNameException;
import ex38Visitor.PrintVisitor;

import java.io.IOException;

public class MainClient42 {
    public static void main(String[] args) throws IOException, DuplicateModelNameException {
        //InterfaceForDAOObject data = DAO.getData(1);
        InterfaceForDAOObject data = DAO.getData(2);
        Car car1 = new Car("Volvo", 3);

        data.writeData(car1);
        Car readCar = data.readData();
        readCar.accept(new PrintVisitor()); //вывод в консоль
    }
}
