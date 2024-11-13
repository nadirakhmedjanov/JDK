/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа,
над которыми должна быть произведена операция.
 */

package HW3.task1;


public class Main {
    public static void main(String[] args) {
        System.out.println(Calc.sum(1.4f, 8));
        System.out.println(Calc.subtract(1.4f, 8));
        System.out.println(Calc.multiply(1.4f, 8));
        System.out.println(Calc.divide(1.4f, 8));
    }
}