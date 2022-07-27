import java.util.Random;

public class PasswordGenerator {
    private static final String[] chars = new String[] {
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "0123456789",
            "!@#$%&*()_+-=[]|,./?><"
    };

    public static String generate(byte length) {
        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        for (short i = 0; i < length; i++) {
            String _char = chars[random.nextInt(chars.length)];
            int position = random.nextInt(_char.length());
            password.append(_char.charAt(position));
        }
        return new String(password);
    }
}
