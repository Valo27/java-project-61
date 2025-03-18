package hexlet.code;

import java.util.Scanner;

public class GreetGame {
    public static void start(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
