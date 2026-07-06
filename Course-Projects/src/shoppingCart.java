import java.util.Scanner;

public class shoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What item would you like to buy: ");
        String item = scanner.nextLine();

        System.out.print("What is the price for each: ");
        double price = scanner.nextDouble();

        System.out.print("How many would you like: ");
        int quantity = scanner.nextInt();

        double total = price * quantity;

        System.out.printf("You have bought %d %s/s%n", quantity, item);
        System.out.printf("Your total is $%.2f", total);

        scanner.close();
    }
}
