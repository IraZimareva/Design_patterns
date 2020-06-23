package ex12.factory;

import ex12.Motorcycle;
import ex12.Transport;
import ex12.exceptions.DuplicateModelNameException;

public class MotoFactory implements TransportFactory {
    @Override
    public Transport createInstance(String brand, int length) throws DuplicateModelNameException {
        return new Motorcycle(brand, length);
    }
}
