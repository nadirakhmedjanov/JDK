/*
Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
а также переопределение метода toString(), возвращающее строковое представление пары.
 */

package HW3.task3;

import HW3.task2.fruits.Apple;
import HW3.task2.fruits.Orange;

public class Main {
    public static void main(String[] args) {
        Pair<Orange, Apple> pair = new Pair<>(new Orange(), new Apple());
        System.out.println(pair);
    }
}