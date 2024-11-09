package Exceptions;

public class CarOverload extends RuntimeException {
    public CarOverload(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Возникла ошибка: Машина перегружена (не хватает посадочных мест)";
    }
}
