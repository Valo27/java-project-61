

package hexlet.code;

/**
 * Класс для запуска всех игровых модулей
 * Содержит главный метод, который управляет выбором игры
 */

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class App {
    /**
     * Основной метод приложения
     * Выводит меню выбора игр и обрабатывает пользовательский ввод
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Выводим меню выбора игр
        System.out.print("""
                    Please enter the game number and press Enter.
                    1 - Greet
                    2 - Even
                    3 - Calc
                    4 - GCD
                    5 - Progression
                    6 - Prime
                    0 - Exit
                    Your choice:\s""");

        // Получаем выбор пользователя
        String choiceGame = Utils.scannerString();

        // Обрабатываем выбор пользователя через switch
        switch (choiceGame) {
            case "1":
                // Запускаем базовую игру приветствия
                Cli.startGame();
                return;
            case "2":
                // Запускаем игру "Even" - проверка на четность
                Even.gameEven();
                break;
            case "3":
                // Запускаем игру "Calc" - математические вычисления
                Calc.gameCalc();
                break;
            case "4":
                // Запускаем игру "GCD" - нахождение НОД
                GCD.gameGCD();
                break;
            case "5":
                // Запускаем игру "Progression" - работа с арифметической прогрессией
                Progression.gameProgression();
                break;
            case "6":
                // Запускаем игру "Prime" - проверка на простоту числа
                Prime.gamePrime();
                break;
            default:
                // Если введен неверный номер или 0 - завершаем программу
                System.exit(0);
                break;
        }
    }
}
