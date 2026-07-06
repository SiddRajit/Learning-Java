import java.util.Scanner;

public class weightConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Weight Conversion Program");
        System.out.println("1: Convert lbs to kgs");
        System.out.println("2: Convert kgs to lbs");

        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        if (choice == 1) {

            System.out.print("Enter your weight in lbs: ");

            double weight = scanner.nextDouble();
            double newWeight = weight * 0.453592;

            System.out.print("Your new weight is kgs is " + newWeight);

        } else if (choice == 2) {

            System.out.print("Enter your weight in kgs: ");

            double weight = scanner.nextDouble();
            double newWeight = weight * 2.20462;

            System.out.println("Your new weight is lbs is " + newWeight);

        } else {
            System.out.println("You have not entered a valid choice!");
        }

        scanner.close();
    }
}
