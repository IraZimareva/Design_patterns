package ex12.factory;

import ex12.Transport;
import ex12.exceptions.DuplicateModelNameException;

public interface TransportFactory {
    Transport createInstance (String brand, int length) throws DuplicateModelNameException;
}