import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()_+-=[]{}|;:.?<>";
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRestart = true;

        while(isRestart) {
            System.out.println("Enter the length of the password (between 8 and 12 characters): ");
            int length = scanner.nextInt();

            if (length < 8 || length > 12) {
                System.out.println("Invalid password length. Please enter a length between 8 and 12 characters.");
                continue;
            }

            String password = generatePassword(length);
            System.out.println("Generated password: \n" + password);

            System.out.println("Do you want to generate another password? (yes/no): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("yes")) {
                isRestart = false;
            }
        }

        scanner.close();
    }

    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        String allChars = LOWER + UPPER + DIGITS + SPECIAL;

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
