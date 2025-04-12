package hexlet.code;

/**
 * Основной класс приложения, содержащий точку входа main.
 * Представляет собой меню выбора различных игр.
 */
public class App {

    private static final String CHOICE_PROMPT = "Your choice: ";
    private static final String WELCOME_MESSAGE = "Please enter the game number and press Enter.";

    /**
     * Точка входа в приложение. Выводит меню выбора игр и запускает выбранную игру.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);

        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        System.out.print(CHOICE_PROMPT);

        String choice = Engine.getChoice();
        Engine.startChosenGame(choice);
        Engine.setClose();
    }
}
