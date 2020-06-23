package ex38Visitor;

import ex12.Car;
import ex12.Motorcycle;

public interface Visitor {
    void visitCar (Car car);
    void visitMoto (Motorcycle moto);
}
