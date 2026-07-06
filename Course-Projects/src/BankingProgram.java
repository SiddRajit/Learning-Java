import java.util.Scanner;

public class BankingProgram {
     static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        double balance = 0;
        Boolean isRunning = true;

        do {
            System.out.println("*****************");
            System.out.println("BANKING PROGRAM");
            System.out.println("*****************");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("*****************");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showBalance(balance);
                case 2 -> balance += deposit();
                case 3 -> balance -= withdraw();
                case 4 -> isRunning = false;
                default -> System.out.println("INVALID CHOICE!");
            }
        } while (isRunning);


        scanner.close();
    }
    static void showBalance(double balance) {
        System.out.printf("Your current balance is $%.2f\n", balance);
    }
    static double withdraw() {

        System.out.print("Enter an amount to be withdrawn: ");
        double amount = scanner.nextDouble();

        if (amount < 0) {
            System.out.println("Amount cant be negative");
            return 0;
        } else {
            return amount;
        }
    }
    static double deposit() {

        System.out.print("Enter an amount to be deposited: ");
        double amount = scanner.nextDouble();

        if (amount < 0) {
            System.out.println("Amount cant be negative");
            return 0;
        } else {
            return amount;
        }
    }
}
