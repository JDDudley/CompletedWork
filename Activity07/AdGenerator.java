import java.util.Scanner;
import java.text.NumberFormat;

/*
 * Ad generator that uses string methods and number formatting.
 * Centers ad text using maximum width of any lines in ad.
 * 
 * @author Jason Dudley
 * @version CS121-002, Spring 2020
 */
public class AdGenerator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		
		// Introduce to user
		System.out.println("Welcome to AdGenerator!");
		System.out.println("Please enter your profile information.");
		for (int x = 0; x < 40; x++)
			System.out.print("=");
		System.out.print("\n");
		// Gather input
		System.out.print("First Name:");
		String firstName = scan.nextLine();
		System.out.print("Middle Name:");
		String middleName = scan.nextLine();
		System.out.print("Last Name:");
		String lastName = scan.nextLine();
		System.out.print("Job Title:");
		String jobTitle = scan.nextLine();
		System.out.print("Phone Number (10 Digit):");
		String phone = scan.nextLine();
		System.out.print("Hourly Rate:");
		double hourlyRate = scan.nextDouble();
		scan.close();
		// Formatting
		String phoneFormatted = "(" + phone.substring(0,3) + ") " + 
				phone.substring(3,6) + "-" + phone.substring(6,10);
		String nameFormatted = firstName + " " + middleName.charAt(0) + ". " + lastName;
		String rateFormatted = currencyFormat.format(hourlyRate);
		// Space
		System.out.print("\n\n");
		// Create ad strings
		String adLine1 = "Need a " + jobTitle + "?";
		String adLine2 = "CALL NOW! " + phoneFormatted;
		String adLine3 = "Ask for " + nameFormatted;
		String adLine4 = "(Rates start at " + rateFormatted + "/hour!)";
		// Calculate max
		int max = Math.max(adLine1.length(), adLine2.length());
		max = Math.max(max, adLine3.length());
		max = Math.max(max, adLine4.length());
		// Print ad
		for (int x = 0; x < max; x++)
			System.out.print("=");
		System.out.print("\n");
		for (int x = 0; x < (max - adLine1.length()) / 2; x++)
			System.out.print(" ");
		System.out.println(adLine1);
		for (int x = 0; x < (max - adLine2.length()) / 2; x++)
			System.out.print(" ");
		System.out.println(adLine2);
		for (int x = 0; x < (max - adLine3.length()) / 2; x++)
			System.out.print(" ");
		System.out.println(adLine3);
		for (int x = 0; x < (max - adLine4.length()) / 2; x++)
			System.out.print(" ");
		System.out.println(adLine4);
		for (int x = 0; x < max; x++)
			System.out.print("=");
		System.out.print("\n");
	}
}
