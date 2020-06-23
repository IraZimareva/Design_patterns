package ex36Strategy;

//аргументы в программе передаются через командную строку:
//edit configurations -->
//Programm arguments  -->
// src\ex36Strategy\student.xml src\ex36Strategy\output.xml

public class Main36 {

    private static Strategy rootStrategy;

    public static Strategy getRootStrategy() {
        return rootStrategy;
    }

    public static void setRootStrategy(Strategy rootStrategy) {
        Main36.rootStrategy = rootStrategy;
    }

    public static void main(String[] args) {
        String inputURI = args[0];
        String outputURI = args[1];
        System.out.println("Yours config input: " + inputURI);
        System.out.println("Yours config output: " + outputURI);

        //setRootStrategy(new ReaderDOM());
        setRootStrategy(new ReaderSAX());
        rootStrategy.parseXML(inputURI,outputURI);
    }
}


