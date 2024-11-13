package HW3.task1;

public class Calc {
    public static <T extends Number> double sum(T firstNum, T secondNum) {
        return firstNum.doubleValue() + secondNum.doubleValue();
    }

    public static <T extends Number> double subtract(T firstNum, T secondNum) {
        return firstNum.doubleValue() - secondNum.doubleValue();
    }

    public static <T extends Number> double multiply(T firstNum, T secondNum) {
        return firstNum.doubleValue() * secondNum.doubleValue();
    }

    public static <T extends Number> double divide(T firstNum, T secondNum) {
        if (secondNum.doubleValue() == 0) {
            throw new ArithmeticException("На ноль делить запрещено!");
        }
        return firstNum.doubleValue() / secondNum.doubleValue();
    }
}