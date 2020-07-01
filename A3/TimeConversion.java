/**
  * TimeConversion is used to convert times
  *
  * @author Jason Dudley
  * @version CS121-002, Spring 2020
**/
import java.util.Scanner;

public class TimeConversion
{
	public static void main (String[] args)
	{
		// Ask user for input
		int input;
		Scanner scan = new Scanner(System.in);
		System.out.print("Seconds? ");
		input = scan.nextInt();
		// get hours
		int remainder = input % 3600;
		int hours = (input - remainder) / 3600;
		input = remainder;
		// get minutes
		remainder = input % 60;
		int minutes = (input - remainder) / 60;
		int seconds = remainder;
		// output
		System.out.println(hours + " hours, " + minutes + " minutes, " + seconds + " seconds.");
	}
}