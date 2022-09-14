import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static int length = 6;
    private static boolean useSpecial = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("> How many characters will be in the password?");
                length = scanner.nextInt();

                System.out.println("> Use special symbols? (yes/no)");
                useSpecial = Objects.equals(scanner.next(), "yes");

                System.out.println("> How many password will be generated?");
                int passwords = scanner.nextInt();

                System.out.println("\nGenerated Passwords:");
                for (int i = 0; i < passwords; i++) {
                    System.out.printf("%d. %s %n", i + 1, generatePassword());
                }
                System.out.println();
            } catch (InputMismatchException ignored) {
                System.out.println("ERROR: Input error!");
                System.exit(0);
            }
        }
    }

    public static String generatePassword() {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String special = "!@#$%&*()_+-=[]|,./?><";

        String chars;
        if (useSpecial) chars = symbols + special;
        else chars = symbols;

        SecureRandom random = new SecureRandom();
        return IntStream.range(0, length)
                .map(i -> random.nextInt(chars.length()))
                .mapToObj(randomI -> String.valueOf(chars.charAt(randomI)))
                .collect(Collectors.joining());
    }
}
