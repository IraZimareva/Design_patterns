package ex12;

import ex12.exceptions.DuplicateModelNameException;
import ex12.exceptions.NoSuchModelNameException;
import ex38Visitor.PrintVisitor;

import java.util.Arrays;
import java.util.Iterator;

public class MainTest {
    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException {

//ТЕСТЫ КЛАССА АВТОМОБИЛЬ
/*
        Car car1 = new Car("Volvo", 4);
        System.out.println(Arrays.toString(car1.getNameAllModel()));
        System.out.println(Arrays.toString(car1.getPriceAllModel()));

        car1.setNameModel("Car1", "Jeap");
        System.out.println(Arrays.toString(car1.getNameAllModel()));
        //car1.setPriceModel("Jeap",50.5);
        //System.out.println(car1.getPriceModel("Jeap"));
        System.out.println(Arrays.toString(car1.getPriceAllModel()));
        car1.addModel("Sedan",250.56);
        car1.removeModel("Car2");
        //System.out.println(car1.getCountOfModel());
*/
//ТЕСТЫ КЛАССА АВТОМОБИЛЬ


//ТЕСТЫ КЛАССА МОТОЦИКЛ
/*
        ex12.Motorcycle motorcycle1 = new ex12.Motorcycle("Harley Davidson", 5);
        System.out.println(Arrays.toString(motorcycle1.getNameAllModel()));
        System.out.println(Arrays.toString(motorcycle1.getPriceAllModel()));

        motorcycle1.setNameModel("Mot1","Bang");
        motorcycle1.setPriceModel("Bang",50.5);
        System.out.println(motorcycle1.getPriceModel("Bang"));
        motorcycle1.addModel("Jo",250.56);
        motorcycle1.removeModel("Mot0");
        System.out.println(Arrays.toString(motorcycle1.getNameAllModel()));
        System.out.println(Arrays.toString(motorcycle1.getPriceAllModel()));
        System.out.println(motorcycle1.getCountOfModel());
*/
//ТЕСТЫ КЛАССА МОТОЦИКЛ

//ТЕСТЫ КЛАССА TRANSPORTGENERAL
        /*
        System.out.println(ex12.TransportGeneral.getAveragePriceModel(car1));
        System.out.println(ex12.TransportGeneral.getAveragePriceModel(motorcycle1));

        ex12.TransportGeneral.printAllModel(car1);
        ex12.TransportGeneral.printAllPrice(car1);
        */
//ТЕСТЫ КЛАССА TRANSPORTGENERAL

//ТЕСТЫ ФАБРИЧНОГО МЕТОДА
        /*
        Transport car2 = TransportGeneral.createInstance("Opel",2);
        TransportGeneral.printAllModel(car2);
        TransportGeneral.printAllPrice(car2);
        System.out.println(car2.getClass());

        TransportGeneral.setTransportFactory(new MotoFactory());
        Transport motorcycle2 = TransportGeneral.createInstance("Урал",3);
        TransportGeneral.printAllModel(motorcycle2);
        TransportGeneral.printAllPrice(motorcycle2);
        System.out.println(motorcycle2.getClass());
        */
//ТЕСТЫ ФАБРИЧНОГО МЕТОДА

//ТЕСТЫ ИТЕРАТОРА
/*
        Car car1 = new Car("Volvo", 4);
        Iterator iter = car1.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next().toString());
        }
*/
//ТЕСТЫ ИТЕРАТОРА

//ТЕСТЫ MEMENTO
/*
        Car car1 = new Car("Volvo", 4);
        System.out.println(Arrays.toString(car1.getNameAllModel()));
        System.out.println(Arrays.toString(car1.getPriceAllModel()));
        Car.Memento memento = car1.createMemento();

        System.out.println("\n Change name, price");
        car1.setNameModel("Car1", "Jeap");
        car1.setPriceModel("Jeap",50.5);

        System.out.println(Arrays.toString(car1.getNameAllModel()));
        System.out.println(Arrays.toString(car1.getPriceAllModel()));

        System.out.println("\n Restore");
        car1.setMemento(memento);

        System.out.println(Arrays.toString(car1.getNameAllModel()));
        System.out.println(Arrays.toString(car1.getPriceAllModel()));
*/
//ТЕСТЫ MEMENTO

//ТЕСТЫ VISITOR

        PrintVisitor pv = new PrintVisitor();
        Car car1 = new Car("Volvo", 4);
        car1.accept(pv);
        System.out.println("\n");
        Motorcycle motorcycle1 = new Motorcycle("Harley Davidson", 5);
        motorcycle1.accept(pv);

//ТЕСТЫ VISITOR
    }
}