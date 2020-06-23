package ex32;

import ex12.Car;

import java.io.FileWriter;
import java.io.IOException;

public class PrintLine implements CommandMy{
    @Override
    public void print(Car car, FileWriter fw) {
        try {
            fw.write(car.getBrand() + " ");
            //fw.write(" ");
            String[] allName = car.getNameAllModel();
            double[] allPrice = car.getPriceAllModel();
            for (int i = 0; i < car.getCountOfModel(); i++) {
                fw.write(allName[i] + " ");
                fw.write(Double.toString(allPrice[i]) + " ");
            }
            System.out.println("ЗАПИСАНО!");
            fw.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
