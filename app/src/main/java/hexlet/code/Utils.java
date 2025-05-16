package hexlet.code;

import java.util.Random;
import java.util.Scanner;

/**
 * Утилитный класс для общих операций.
 * Содержит методы для работы с вводом и генерацией случайных чисел
 */
public class Utils {

    /**
     * Метод для получения строки от пользователя.
     * Создает новый объект Scanner и возвращает введенную строку
     * @return введенная пользователем строка
     */
    public static String scannerString() {
        return new Scanner(System.in).nextLine();
    }

    /**
     * Метод генерации случайного числа с одним параметром.
     * Вызывает основную реализацию метода random с начальным значением 1
     * @param number максимальное значение случайного числа
     * @return случайное число в диапазоне от 1 до number
     */
    public static int random(int number) {
        return random(1, number);
    }

    /**
     * Основной метод генерации случайного числа.
     * Генерирует случайное число в заданном диапазоне
     * @param numberFirstStep начальное значение диапазона (включительно)
     * @param numberLength конечное значение диапазона (не включительно)
     * @return случайное число в заданном диапазоне
     */
    public static int random(int numberFirstStep, int numberLength) {
        Random rnd = new Random();
        int result = rnd.nextInt(numberLength);

        // Если сгенерированное число меньше начального значения диапазона,
        // добавляем разницу к результату
        if (result < numberFirstStep) {
            result += numberFirstStep;
        }
        return result;
    }
}
