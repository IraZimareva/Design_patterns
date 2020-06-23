package ex38Visitor;

import ex12.Car;
import ex12.Motorcycle;

import java.util.Iterator;

public class PrintVisitor implements Visitor{

    @Override
    public void visitCar(Car car) {
        System.out.print(car.getBrand()+ "   ");
        Iterator iter = car.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next().toString() + " ");
        }
    } // (первый метод, выводит всё в одну строку)

    @Override
    public void visitMoto(Motorcycle moto) {
        System.out.println(moto.getBrand());
        String[] allName = moto.getNameAllModel();
        double[] allPrice = moto.getPriceAllModel();
        for (int i = 0; i < moto.getCountOfModel(); i++) {
            System.out.println(allName[i] + ":");
            System.out.println(Double.toString(allPrice[i]));
        }
    }//(второй метод, выводит модели и цены в столбик)
}
