package ex42;

import ex12.Car;

import java.io.*;

public class SerializedCar implements InterfaceForDAOObject {
    private File file = new File("src/ex42/out2.bin");

    public  void writeData(Car car){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(car);
            System.out.println("ЗАПИСАНО");
            out.close();
        }
        catch(IOException e) {
            e.getMessage();
        }
    }
    public  Car readData(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            Car car = (Car) in.readObject();
            in.close();
            System.out.println("ПРОЧИТАНО");
            return car;
        }
        catch (IOException ex) {
            ex.getMessage();
        }
        catch (ClassNotFoundException clas) {
            clas.getMessage();
        }
        return null;
    }
}
