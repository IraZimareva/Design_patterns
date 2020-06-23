package ex13;

import ex12.Car;
import ex12.Motorcycle;
import ex12.TransportGeneral;
import ex12.exceptions.DuplicateModelNameException;
import ex12.exceptions.NoSuchModelNameException;

import java.util.Arrays;

public class MainTest3 {
    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException {

//ТЕСТЫ КЛОНА КЛАССА АВТОМОБИЛЬ
/*
        Car car1 = new Car("Volvo", 4);
        System.out.println("First auto:" + car1.getBrand());
        System.out.println(Arrays.toString(car1.getNameAllModel()));
        System.out.println(Arrays.toString(car1.getPriceAllModel()));

        Car cloneCar = (Car) car1.clone();
        System.out.println("\n Clone auto:" + cloneCar.getBrand());
        TransportGeneral.printAllModel(cloneCar);
        TransportGeneral.printAllPrice(cloneCar);

        cloneCar.setBrand("Honda");
        cloneCar.setNameModel("Car2","Machina");
        cloneCar.setPriceModel("Car0",468.6);
        System.out.println("\n Change \n");

        System.out.println("First auto after change:" + car1.getBrand());
        System.out.println(Arrays.toString(car1.getNameAllModel()));
        System.out.println(Arrays.toString(car1.getPriceAllModel()));

        System.out.println("\n Clone auto after change:" + cloneCar.getBrand());
        TransportGeneral.printAllModel(cloneCar);
        TransportGeneral.printAllPrice(cloneCar);
*/
//ТЕСТЫ КЛОНА КЛАССА АВТОМОБИЛЬ


//ТЕСТЫ КЛОНА КЛАССА МОТОЦИКЛ

        Motorcycle motorcycle1 = new Motorcycle("Harley Davidson", 5);
        System.out.println("First moto:" + motorcycle1.getBrand());
        TransportGeneral.printAllModel(motorcycle1);
        TransportGeneral.printAllPrice(motorcycle1);

        Motorcycle cloneMoto = (Motorcycle) motorcycle1.clone();
        System.out.println("\n Clone moto:" + cloneMoto.getBrand());
        TransportGeneral.printAllModel(cloneMoto);
        TransportGeneral.printAllPrice(cloneMoto);

        cloneMoto.setBrand("Урал");
        cloneMoto.setNameModel("Mot2","Bike");
        cloneMoto.setPriceModel("Mot0",468.6);
        System.out.println("\n Change \n");

        System.out.println("First moto after change:" + motorcycle1.getBrand());
        System.out.println(Arrays.toString(motorcycle1.getNameAllModel()));
        System.out.println(Arrays.toString(motorcycle1.getPriceAllModel()));

        System.out.println("\n Clone moto after change:" + cloneMoto.getBrand());
        TransportGeneral.printAllModel(cloneMoto);
        TransportGeneral.printAllPrice(cloneMoto);

//ТЕСТЫ КЛОНА КЛАССА МОТОЦИКЛ
/*
        //создание прототипа
        Car prototype = (Car) car1.clone();

        System.out.println("\n Prototype car2:" + prototype.getBrand());
        System.out.println(Arrays.toString(prototype.getNameAllModel()));
        System.out.println(Arrays.toString(prototype.getPriceAllModel()));
*/
    }
}
