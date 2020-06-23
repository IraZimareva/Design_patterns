package ex11;

import java.io.*;
import java.util.Properties;

public class MainSingleton {
    public static void main(String[] args) {
        Properties property = MySingleton.getInstance().getProperties();

        String nameDeveloper = property.getProperty("nameDeveloper");
        String yearOfBirthday = property.getProperty("yearOfBirthday");
        String university = property.getProperty("university");
        String grade = property.getProperty("grade");
        String smile = property.getProperty("smile");
        String site = property.getProperty("site");

            System.out.println(" nameDeveloper: " + nameDeveloper
                    + ", \n yearOfBirthday: " + yearOfBirthday
                    + ", \n university: " + university
                    + ", \n grade: " + grade
                    + ", \n smile: " + smile
                    + ", \n site: " + site);

    }

}