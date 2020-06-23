package ex11;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MySingleton {
    private static MySingleton uniqueInstance = new MySingleton();
    private Properties property = new Properties();

    private MySingleton(){
        try {
            FileInputStream fis = new FileInputStream("src/ex11/config.properties");
            property.load(fis);
        }
        catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public synchronized static MySingleton getInstance () {
        return uniqueInstance;
    }

    public Properties getProperties (){
        return property;
    }
}

    //Написать класс с использованием паттерна Singleton,
    //который будет загружать данный файл (один раз)
    //и отдавать экземпляр Properties по запросу.