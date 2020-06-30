/**
 * Temperature conversion
 * 
 * @author Jason Dudley
 * @version CS 121-002, Spring 2020
 * 
 */
import java.util.Scanner;

public class MyTempConverter
{
	public static void main (String[] args)
	{
		// Get input
		String input;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter temperature for conversion, "+
		  "including unit of measurement (e.g., 32F): ");
		input = scan.nextLine();
		System.out.println("You entered " + input + ".");
		// Read units
		char units_in;
		units_in = input.charAt(input.length()-1);
		// read value, cast
		double value_in = Double.valueOf(input.substring(0,input.length()-1).trim());
		// execute conversion
		double value_out;
		char units_out;
		if (units_in == 'F' || units_in == 'f')
		{
			// fahrenheit to celcius
			value_out = (value_in - 32) * 5/9;
			units_out = 'C';
		}
		else {
			// celcius to fahrenheit
			value_out = (value_in * 9/5) + 32;
			units_out = 'F';
		}
		// print result
		System.out.println(input + " -> " + Math.round(value_out) + units_out);
	}
}
