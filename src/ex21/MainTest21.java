package ex21;

import ex12.Motorcycle;
import ex12.TransportGeneral;
import ex12.exceptions.DuplicateModelNameException;

import java.io.IOException;

public class MainTest21 {
    public static void main(String[] args) throws DuplicateModelNameException, IOException {
        Motorcycle motorcycle1 = new Motorcycle("Harley Davidson", 5);
        //TransportGeneral.printAllModel(motorcycle1);

        MyAdapter.outputByte(motorcycle1.getNameAllModel());
        MyAdapter.inputByte();
    }
}

