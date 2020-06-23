package ex42;

import ex12.Car;
import ex12.exceptions.DuplicateModelNameException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface InterfaceForDAOObject {
    void writeData(Car car) throws IOException;
    Car readData() throws IOException, DuplicateModelNameException;
}
