package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("0 - Exit");

        System.out.print("Your choice: ");
        String choice = Engine.getChoice();
        Engine.startChosenGame(choice);

        Engine.setClose();
    }
}
