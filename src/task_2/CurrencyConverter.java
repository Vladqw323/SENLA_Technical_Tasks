import java.util.Scanner;

public class CurrencyConverter {
    private static final double USD_RATE = 0.3031;
    private static final double EUR_RATE = 0.2807;
    private static final double RUB_RATE = 29.1926;
    private static final double PLN_RATE = 1.2186;
    private static final double CNY_RATE = 2.1472;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRestart = true;

        while(isRestart) {
            System.out.print("Enter the amount in BYN to convert: ");
            double amountBYN = scanner.nextDouble();

            double amountUSD = amountBYN * USD_RATE;
            double amountEUR = amountBYN * EUR_RATE;
            double amountRUB = amountBYN * RUB_RATE;
            double amountPLN = amountBYN * PLN_RATE;
            double amountCNY = amountBYN * CNY_RATE;

            System.out.println("Amount in USD: " + amountUSD);
            System.out.println("Amount in EUR: " + amountEUR);
            System.out.println("Amount in RUB: " + amountRUB);
            System.out.println("Amount in PLN: " + amountPLN);
            System.out.println("Amount in CNY: " + amountCNY);

            System.out.println("Do you want to continue? (yes/no): ");
            String choice = scanner.next();
            if(!choice.equalsIgnoreCase("yes")) {
                isRestart = false;
            }
        }

        scanner.close();
    }
}
