import java.util.Scanner;
/**
 * ConvertToHMS asks user for number of seconds as input
 * Outputs time in human-readable hour:minute:second format
 * 
 * @author Jason Dudley
 * @version CS 121-002, Spring 2020
 *
 */

public class ConvertToHMS {
	public static void main (String[] args) {
		int input;
		int hours, minutes, seconds;
		String output = "";
		
		// get user input in seconds
		Scanner scan = new Scanner(System.in);
		System.out.print("Seconds: ");
		input = scan.nextInt();
		scan.close();
		
		if (input >= 3600) {
			// get hours
			seconds = input % 3600;
			hours = (input - seconds) / 3600;
			output += hours;
			if (hours > 1)
				output += " hours, ";
			else
				output += " hour, ";
			input = seconds;
		}
		if (input > 60) {
			// get minutes
			seconds = input % 60;
			minutes = (input - seconds) / 60;
			output += minutes;
			if (minutes > 1)
				output += " minutes, ";
			else
				output += " minute, ";
			input = seconds;
		}
		if (input > 1)
			output += input + " seconds";
		if (input == 1)
			output += input + " second";
		System.out.println(output);
		
	}
}
