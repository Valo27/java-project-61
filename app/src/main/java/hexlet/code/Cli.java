package hexlet.code;

/**
 * Класс для взаимодействия с пользователем через командную строку
 * Содержит метод запуска приветствия
 */
public class Cli {

    /**
     * Метод запуска приветствия
     * Выполняет:
     * 1. Приветственное сообщение
     * 2. Запрос имени пользователя
     * 3. Вывод персонализированного приветствия
     */
    public static void startGame() {
        // Выводим пустую строку для форматирования вывода
        System.out.println();

        // Приветственное сообщение игры
        System.out.println("Welcome to the Brain Games!");

        // Запрос имени пользователя
        System.out.print("May I have your name? ");

        // Получаем имя пользователя через утилиту ввода
        String nameGamer = Utils.scannerString();

        // Выводим персонализированное приветствие
        System.out.println("Hello, " + nameGamer + "!");
    }
}
