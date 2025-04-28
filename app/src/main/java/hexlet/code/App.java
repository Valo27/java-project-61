package hexlet.code;

import hexlet.code.games.*;

public class App {

    private static final String CHOICE_PROMPT = "Your choice: ";
    private static final String WELCOME_MESSAGE = "Please enter the game number and press Enter.";

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
        startChosenGame(choice);
        Engine.setClose();
    }

    public static void startChosenGame(String choice) {
        if (choice.equals("1")) {
            Engine.getGreeting("");
        }

        if (choice.equals("2")) {
            Even.gameStart();
        }

        if (choice.equals("3")) {
            Calc.gameStart();
        }

        if (choice.equals("4")) {
            GCD.gameStart();
        }

        if (choice.equals("5")) {
            Progression.gameStart();
        }

        if (choice.equals("6")) {
            Prime.gameStart();
        }

        if (choice.equals("0")) {
            System.out.println("Bye.");
        }
    }
}
