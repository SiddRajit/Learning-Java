import java.util.Scanner;

public class compoundInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the interest rate (in %): ");
        double rate = scanner.nextDouble() / 100;

        System.out.print("Enter the number of times compounded per year: ");
        int timesCompounded = scanner.nextInt();

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        double amount = principal * Math.pow(1 + rate / timesCompounded, timesCompounded * years);

        System.out.printf("The amount after %d years is $%.2f", years, amount);
        scanner.close();
    }
}
