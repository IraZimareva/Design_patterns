package ex12.factory;

import ex12.Car;
import ex12.Transport;

public class AutoFactory implements TransportFactory {
    @Override

    public Transport createInstance(String brand, int length) {
        return new Car(brand, length);
    }
}
