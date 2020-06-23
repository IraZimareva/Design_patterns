package ex42;

import ex12.Car;
import ex12.exceptions.DuplicateModelNameException;

import java.io.*;
import java.util.Scanner;

public class TxtCar implements InterfaceForDAOObject {
    private File file = new File("src/ex42/out1.txt");

    public void writeData(Car car) {
        try {
            FileWriter fw = new FileWriter(file);
            car.print(fw);
        }
        catch (IOException ex) {
            ex.getMessage();
        }
    }

    public Car readData() throws DuplicateModelNameException {
        try {
            FileReader fr = new FileReader(file);
            Scanner scan = new Scanner(fr);
            Car car = new Car(scan.next(),0);
            while (scan.hasNext()) {
                String nameModel = scan.next();
                double priceModel = Double.parseDouble(scan.next());
                car.addModel(nameModel,priceModel);
            }
            //System.out.println(scan.next());
            System.out.println("ПРОЧИТАНО");
            fr.close();
            return car;
        }
        catch (IOException ex) {
            ex.getMessage();
        }
        return null;
    }
}
