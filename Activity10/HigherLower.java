import java.util.Random;
import java.util.Scanner;

/**
 * Lesson 10: Activity - while Loops and Iterators 
 * 
 * @author Java Foundations
 * @author CS121 Instructors
 * @author Jason Dudley
 * @version CS121-002, Spring 2020
 * 
 */
public class HigherLower
{
	public static void main(String[] args)
	{
		final int MAX = 10;
		int answer;
		int guess;
		
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		boolean keepPlaying = true;
		
		while (keepPlaying) {
			answer = random.nextInt(MAX) + 1;
			boolean correctAnswer = false;
			
			System.out.print("\nI'm thinking of a number between 1 and " + MAX + ". ");
			System.out.print("Guess what it is: ");
			
			guess = scan.nextInt();
			while (!correctAnswer) {
				if (guess < 1 || guess > MAX) {
					System.out.println("Error: Didn't guess in requested range.");
					System.out.print("Guess again: ");
					guess = scan.nextInt();
				}
				else if (guess == answer) {
					System.out.println("You got it! Good guessing!");
					correctAnswer = true;
				}
				else if (guess < answer) {
					System.out.print("Higher. Guess again: ");
					guess = scan.nextInt();
				}
				else if (guess > answer) {
					System.out.print("Lower. Guess again: ");
					guess = scan.nextInt();
				}
				else {
					System.out.println("Error: Guess validation failed.");
				}
			}
			// Check if player wants to continue with another game
			System.out.print("Would you like to play again (y/n)? ");
			String playAgain = scan.next();
			if (playAgain.toLowerCase().charAt(0) == 'y') {
				keepPlaying = true;
			}
			else if (playAgain.toLowerCase().charAt(0) == 'n') {
				keepPlaying = false;
			}
			else {
				System.out.println("Error: Input not recognized. Exiting now.");
				keepPlaying = false;
			}
		}
		
		System.out.println("Game over. Goodbye!");
		
		scan.close();
	}
}
