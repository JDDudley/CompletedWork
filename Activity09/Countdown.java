import java.util.Scanner;
/*
 * @author Jason Dudley
 * @version CS121-002, Spring 2020
 */
public class Countdown {
	public static void main (String[] args) {
		// Read number from user
		System.out.print("Enter number between 1 and 5:");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		// Use switch to print countdown from that number
		switch (input) {
		case 5:
			System.out.println(5);
		case 4:
			System.out.println(4);
		case 3:
			System.out.println(3);
		case 2:
			System.out.println(2);
		case 1:
			System.out.println(1);
			break;
		default:
			System.out.println("Input not within range.");
		}
		// 5,4,3 print hello
		// 2, 1 print goodbye
		switch(input) {
		case 5:
		case 4:
		case 3:
			System.out.println("Hello");
			break;
		case 2:
		case 1:
			System.out.println("Goodbye");
			break;
		default:
			System.out.println("Error");
		}
	}

}
