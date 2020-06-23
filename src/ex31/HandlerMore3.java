package ex31;

import ex12.Transport;

import java.io.FileWriter;
import java.io.IOException;

public class HandlerMore3 implements ChainOfResponsibilityMy {
    @Override
    public void writeToFile(Transport transport) throws IOException {
        if (transport.getCountOfModel()>3) {
            try {
                FileWriter fw = new FileWriter("src/ex31/out2.txt");
                fw.write(transport.getBrand() + "\n ");
                String[] allName = transport.getNameAllModel();
                double[] allPrice = transport.getPriceAllModel();
                for (int i = 0; i < transport.getCountOfModel(); i++) {
                    fw.write(allName[i] + "\n ");
                    fw.write(Double.toString(allPrice[i]) + "\n ");
                }
                System.out.println("ЗАПИСАНО!");
                fw.close();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        else nextHandler(transport);
    }

    @Override
    public void nextHandler(Transport transport) throws IOException {
        ChainOfResponsibilityMy nextHandler = new HandlerLess3();
        nextHandler.writeToFile(transport);
    }
}

//Вторая реализация в цепочке выводит информацию в столбик, если количество моделей больше 3.