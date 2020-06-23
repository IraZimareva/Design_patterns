package ex12.exceptions;

//НЕОбъявляемое
//задание неверной цены модели
public class ModelPriceOutOfBoundsException extends Error{
    public ModelPriceOutOfBoundsException() {
        super("Неверная цена модели");
    }
}
