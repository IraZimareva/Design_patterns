package ex31;

import ex12.Transport;

import java.io.IOException;

public interface ChainOfResponsibilityMy {
    void writeToFile (Transport transport) throws IOException;
    void nextHandler(Transport transport) throws IOException;
}


//В интерфейсе должен быть описан метод записи, в качестве параметра принимающий Транспортное средство,
// а также метод установки следующего в цепочке.