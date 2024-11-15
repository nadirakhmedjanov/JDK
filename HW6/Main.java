/*В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла (Парадокс Монти Холла — Википедия ) и наглядно убедиться в верности парадокса
(запустить игру в цикле на 1000 и вывести итоговый счет).
Необходимо:
Создать свой Java Maven или Gradle проект;
Подключить зависимость lombok.
Можно подумать о подключении какой-нибудь математической библиотеки для работы со статистикой
Самостоятельно реализовать прикладную задачу;
Сохранить результат в HashMap<шаг теста, результат>
Вывести на экран статистику по победам и поражениям

Работы принимаются в виде ссылки на гит репозиторий со всеми ключевыми файлами проекта
*/

package HW6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    private static final int NUM_SIMULATIONS = 1000;

    public static void main(String[] args) {
        Map<Integer, Boolean> resultsWithoutSwitching = Simulation(false);
        Map<Integer, Boolean> resultsWithSwitching = Simulation(true);

        System.out.println("Без изменения решения по выбору двери:");
        displayResults(resultsWithoutSwitching);

        System.out.println("Результаты в случае выбора другой двери:");
        displayResults(resultsWithSwitching);
    }

    private static Map<Integer, Boolean> Simulation(boolean shouldSwitch) {
        Map<Integer, Boolean> results = new HashMap<>();
        Random random = new Random();

        for (int i = 1; i <= NUM_SIMULATIONS; i++) {
            int prizeDoor = random.nextInt(3);   // Выиграшная дверь с авто (0, 1, или 2)
            int chosenDoor = random.nextInt(3);  // Участник осуществляет выбор

            // Ищем дверь, которую можно открыть, чтобы показать, что там нет приза
            int openDoor;
            do {
                openDoor = random.nextInt(3);
            } while (openDoor == prizeDoor || openDoor == chosenDoor);

            // Участник меняет выбор, если это требуется
            if (shouldSwitch) {
                chosenDoor = 3 - chosenDoor - openDoor;
            }

            // Проверяем, выиграл ли участник
            boolean won = (chosenDoor == prizeDoor);
            results.put(i, won);
        }

        return results;
    }

    private static void displayResults(Map<Integer, Boolean> results) {
        int wins = 0;
        int losses = 0;

        for (boolean result : results.values()) {
            if (result) {
                wins++;
            } else {
                losses++;
            }
        }

        System.out.printf("Авто: %d, Козы: %d, авто доля: %.2f%%%n",
                wins, losses, (wins / (double) NUM_SIMULATIONS) * 100);
    }
}