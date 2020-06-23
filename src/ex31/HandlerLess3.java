package ex31;

import ex12.Transport;

import java.io.*;

public class HandlerLess3 implements ChainOfResponsibilityMy{
    @Override
    public void writeToFile(Transport transport) throws IOException {
        if (transport.getCountOfModel()<=3) {
            try {
                FileWriter fw = new FileWriter("src/ex31/out1.txt");
                fw.write(transport.getBrand() + " ");
                //fw.write(" ");
                String[] allName = transport.getNameAllModel();
                double[] allPrice = transport.getPriceAllModel();
                for (int i = 0; i < transport.getCountOfModel(); i++) {
                    fw.write(allName[i] + " ");
                    fw.write(Double.toString(allPrice[i]) + " ");
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
        ChainOfResponsibilityMy nextHandler = new HandlerMore3();
        nextHandler.writeToFile(transport);
    }
}

//Первая реализация этого интерфейса в цепочке выводит информацию в одну строку, если количество моделей меньше или равно 3.