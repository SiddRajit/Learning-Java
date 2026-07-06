import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};
        Boolean gameOver = false;
        int playerScore = 0;
        int computerScore = 0;

        do {
            System.out.print("Enter your move (rock, paper, scissors): ");
            String playerChoice = scanner.nextLine().toLowerCase();

            if (!playerChoice.equals("rock") &&
                    !playerChoice.equals("paper") &&
                    !playerChoice.equals("scissors")) {
                System.out.println("Invalid choice");
            }

            String computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer choice: " + computerChoice);

            if (playerChoice.equals(computerChoice)) {
                System.out.println("Its a tie");
            } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                    (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
                System.out.println("You win");
                playerScore++;
            } else {
                System.out.println("You lose");
                computerScore++;
            }

            if (playerScore == 3) {
                System.out.println("You win by a score of " + playerScore + "-" + computerScore);
                gameOver = true;
            } else if (computerScore == 3){
                System.out.println("Computer wins by a score of " + computerScore + "-" + playerScore);
                gameOver = true;
            }

        } while(!gameOver);


        scanner.close();
    }
}
