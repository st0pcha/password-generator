import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("How many characters will be in the password? (1-127):");
            byte length = scanner.nextByte();

            System.out.println("How many passwords will be generated? (1-127)");
            byte amount = scanner.nextByte();

            for (byte i = 0; i < amount; i++) {
                System.out.println("\n" + PasswordGenerator.generate(length));
            }
        } catch (InputMismatchException e) {
            System.out.println("Input error!");
        }
    }
}