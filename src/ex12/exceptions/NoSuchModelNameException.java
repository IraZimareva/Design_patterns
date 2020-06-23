package ex12.exceptions;

//Объявляемое
//ошибка задания несуществующего имени модели
public class NoSuchModelNameException extends Exception {
    public NoSuchModelNameException() {
        super("Такого имени модели не существует");
    }
}
