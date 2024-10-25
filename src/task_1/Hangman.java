import java.util.Scanner;
import java.util.Random;

public class Hangman {
    private static final String[] WORDS = {"java", "programming", "hangman", "computer", "algorithm"};
    private static final int MAX_LIVES = 6;
    private static final String[] HANGMAN_STAGES = {
            "If you're reading this, then everything is cool, well done!",
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "  |   |\n" +
                    " / \\  |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "  |   |\n" +
                    " / \\  |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    " x-x  |\n" +
                    " /|\\  |\n" +
                    "  |   |\n" +
                    " / \\  |\n" +
                    "         "
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRestart = true;

        while(isRestart) {
            String wordToGuess = selectWordToGuess();
            char[] guessedWord = new char[wordToGuess.length()];
            int lives = MAX_LIVES;

            for (int i = 0; i < wordToGuess.length(); i++) {
                guessedWord[i] = '_';
            }

            while (lives > 0) {
                System.out.println("Word: " + String.valueOf(guessedWord));
                System.out.println("Lives left: " + lives);
                System.out.println(HANGMAN_STAGES[MAX_LIVES - lives]);
                System.out.println("Enter a letter: ");
                char guess = scanner.next().charAt(0);
                System.out.println("-------------");

                boolean isExist = false;
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedWord[i] = guess;
                        isExist = true;
                    }
                }

                if (!isExist) {
                    lives--;
                }

                if (wordToGuess.equals(String.valueOf(guessedWord))) {
                    System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                    break;
                }
            }

            if (lives == 0) {
                System.out.println(HANGMAN_STAGES[MAX_LIVES - lives]);
                System.out.println("You ran out of lives. The word was: " + wordToGuess);
                System.out.println("Do you want to try again? (yes/no): ");
                String choice = scanner.next();
                if(!choice.equalsIgnoreCase("yes")) {
                    isRestart = false;
                }
                System.out.println("-------------");
            }
        }

        scanner.close();
    }

    private static String selectWordToGuess() {
        Random random = new Random();
        int index = random.nextInt(WORDS.length);
        return WORDS[index];
    }
}