package ex12.exceptions;

//Объявляемое
//ошибка дублирования названия моделей
public class DuplicateModelNameException extends Exception {
    public DuplicateModelNameException() {
        super("Название моделей дублируется");
    }
}
