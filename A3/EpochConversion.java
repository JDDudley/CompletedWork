/**
  * EpochConversion is used to convert epoch time to human-readable format
  *
  * @author Jason Dudley
  * @version CS121-002, Spring 2020
**/
import java.util.Scanner;

public class EpochConversion
{
	public static void main (String[] args)
	{
		// Ask user for input
		Scanner scan = new Scanner(System.in);
		System.out.print("Seconds Epoch Time? ");
		double input = scan.nextDouble();
		String output = "";
		// // get ms, input to s
		// int ms = (int) (input % 1000);
		// input = (input - ms) / 1000;
		// output = ms + "ms";
		if (input > 60) {
			// get s, input to m
			int s = (int) input % 60;
			input = (input - s) / 60;
			output = s + "s ";
			if (input > 60)
			{
				// get m, input to h
				int m = (int) input % 60;
				input = (input - m) / 60;
				output = m + "m " + output;		
				if (input > 24)
				{
					// get h, input to d
					int h = (int) input % 24;
					input = (input - h) / 24;
					output = h + "h " + output;
					if (input > 365) {
						// get d, input to y
						int d = (int) input % 365;
						int y = (int) input / 365;
						int leapDays = 0;
						if (d > 59) //past feb, check for leap days
							leapDays = (int) (y+2)/4;
						else
							leapDays = (int) (y+1)/4;
						d = d - leapDays;
						// convert to readable calendar year
						int year = 1970 + y;
						output = year + ": " + d + "d " + output;
					}
					else
					{
						int d = (int) input;
						output = d + "d " + output;
					}
				}
				else
				{
					int h = (int) input;
					output = h + "h " + output;
				}
			}
			else
			{
				int m = (int) input;
				output = m + "m " + output;
			}
		}
		else
		{
			int s = (int) input;
			output = s + "s " + output;
		}
		// // get years *** NOTE: NOT ACCURATE LEAP YEAR HANDLING ***
		// int remainder = (int) input % (86400 * 365);
		// int years = (int) (input - remainder) / 365;
		// // get days
		// remainder = (int) input % 86400;
		// int days = (int) (input - remainder) / 86400;
		// input = remainder;
		// // get hours
		// remainder = (int) input % 3600;
		// int hours = (int) (input - remainder) / 3600;
		// input = remainder;
		// // get minutes
		// remainder = (int) input % 60;
		// double minutes = (input - remainder) / 60;
		// double seconds = remainder;
		// // output
		// String output = ms + "ms.";
		// if (seconds > 0)
		// 	output = seconds + "s " + output;
		// if (minutes > 0)
		// 	output = minutes + "m " + output;
		// if (hours > 0)
		// 	output = hours + "h " + output;
		// if (days > 0)
		// 	output = days + "d " + output;
		// if (years > 0)
		// 	output = years + "y " + output;
		System.out.println(output);
	}
}