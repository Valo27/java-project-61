package hexlet.code;

/**
 * Основной класс приложения, содержащий точку входа main
 * Представляет собой меню выбора различных игр
 */
public class App {
    public static void main(String[] args) {
        // Выводим приветственное сообщение и список доступных игр
        System.out.println("Please enter the game number and press Enter.");

        // Список доступных игр
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        // Запрос выбора у пользователя
        System.out.print("Your choice: ");

        // Получаем выбор пользователя через метод из класса Engine
        String choice = Engine.getChoice();

        // Запускаем выбранную игру
        Engine.startChosenGame(choice);

        // Закрываем приложение
        Engine.setClose();
    }
}
