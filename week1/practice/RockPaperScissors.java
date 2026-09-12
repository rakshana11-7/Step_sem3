
package week1.practice;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String getComputerMove() {
        String[] moves = { "Rock", "Paper", "Scissors" };
        Random random = new Random();

        return moves[random.nextInt(3)];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        // Arrays to store round details
        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        System.out.println("=== Rock-Paper-Scissors Game ===");
        System.out.println("Enter Rock, Paper, or Scissors");

        for (int i = 0; i < n; i++) {

            System.out.print("\nRound " + (i + 1) + " - Player: ");
            String playerMove = sc.next();

            while (!playerMove.equalsIgnoreCase("Rock") &&
                    !playerMove.equalsIgnoreCase("Paper") &&
                    !playerMove.equalsIgnoreCase("Scissors")) {

                System.out.print("Invalid move! Enter Rock, Paper, or Scissors: ");
                playerMove = sc.next();
            }

            playerMove = playerMove.substring(0, 1).toUpperCase() + playerMove.substring(1).toLowerCase();

            String computerMove = getComputerMove();

            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);
        }

        System.out.println("\n========== FINAL SUMMARY ==========");
        System.out.printf("%-8s %-15s %-17s %-18s%n", "Round", "Player Move", "Computer Move", "Result");

        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d %-15s %-17s %-18s%n",
                    i + 1,
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        double winPercentage = ((double) wins / n) * 100;
        System.out.println("\nWins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.1f%%%n", winPercentage);

        sc.close();
    }
}
