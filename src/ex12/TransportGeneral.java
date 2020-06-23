package ex12;

import ex12.exceptions.DuplicateModelNameException;
import ex12.factory.AutoFactory;
import ex12.factory.TransportFactory;
import ex22.MyDecorator;

import java.util.Arrays;

public class TransportGeneral {
    private static TransportFactory factory = new AutoFactory();

    public static double getAveragePriceModel (Transport transport){
        double average=0;
        for (double i:transport.getPriceAllModel()){
            average = average + i;
        }
        average = average/transport.getCountOfModel();
        return average;
    }
    public static void printAllModel (Transport transport){
        System.out.println(Arrays.toString(transport.getNameAllModel()));
    }
    public static void printAllPrice(Transport transport){
        System.out.println(Arrays.toString(transport.getPriceAllModel()));
    }

    public static void setTransportFactory(TransportFactory factory){
        TransportGeneral.factory = factory;
    }
    public static Transport createInstance(String name, int length) throws DuplicateModelNameException {
        return factory.createInstance(name,length);
    }

    public synchronized static Transport getTransport (Transport t){
        Transport myDecorator = new MyDecorator(t);
        return myDecorator;
    }
}
