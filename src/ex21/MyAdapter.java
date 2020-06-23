package ex21;

import java.io.*;

public class MyAdapter {

    public static void outputByte(String[] array) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("src/ex21/out.txt");
            //OutputStream fos = new PrintStream(System.out); //PrintStream если в консоль
            for (int i = 0; i < array.length; i++) {
                fos.write(array[i].getBytes());
            }
            System.out.println("ЗАПИСАНО!");
            fos.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }//метод записи данных в байтовый поток

    public static void inputByte () throws IOException{
        try {
            InputStream is = new FileInputStream("src/ex21/out.txt"); //InputStreamReader (System.in)
            System.out.printf("File size: %d bytes \n", is.available());
            int i = -1;
                while((i = is.read()) != -1){
                System.out.print((char) i);
            }
            is.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }//метод чтения данных из байтового потока
}


//Реализовать класс адаптера, метод которого принимает в качестве параметра массив строк
// и записывает их по очереди в выходной байтовый поток (OutputStream), который он «адаптирует».
// Продемонстрировать работу в методе main().