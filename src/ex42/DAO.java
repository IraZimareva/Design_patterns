package ex42;

public class DAO {

    public static final int TXT = 1;
    public static final int SERIALIZED = 2;

    public static InterfaceForDAOObject getData (int whichData) {
        switch (whichData) {
            case TXT:
                return new TxtCar();
            case SERIALIZED:
                return new SerializedCar();
            default:
                return null;
        }
    }
}
