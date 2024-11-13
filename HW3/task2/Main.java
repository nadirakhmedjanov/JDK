/*
Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
если они одинаковые, и false в противном случае.
Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
 */

package HW3.task2;

import HW3.task2.fruits.Apple;
import HW3.task2.fruits.Orange;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Массивы соответствуют условию: " + compareArrays(arr1, arr2));

        String[] arr3 = {"1", "2", "3", "4", "5"};
        String[] arr4 = {"1", "2", "3", "4", "5"};
        System.out.println("Массивы соответствуют условию: " + compareArrays(arr3, arr4));

        Apple[] arr5 = {new Apple(), new Apple(), new Apple(), new Apple(), new Apple()};
        Orange[] arr6 = {new Orange(), new Orange(), new Orange(), new Orange(), new Orange()};
        System.out.println("Массивы соответствуют условию: " + compareArrays(arr5, arr6));


        Float[] arr7 = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        Float[] arr8 = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        System.out.println("Массивы соответствуют условию: " + compareArrays(arr7, arr8));

        Integer[] arr9 = {1, 2, 3, 4, 5};
        Integer[] arr10 = {1, 2, 3, 4, 5, 6};
        System.out.println("Массивы соответствуют условию: " + compareArrays(arr9, arr10));
    }

    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].getClass().equals(arr2[i].getClass())) return false;
        }
        return true;
    }
}