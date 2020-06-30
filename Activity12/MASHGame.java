import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * Lesson 12: Activity - ArrayLists
 *
 * @author CS121 Instructors
 * @version CS121-002, Spring 2020
 * @author Jason Dudley
 */
public class MASHGame {

	public static void main(String[] args) {

		/* Define list of options */
		ArrayList<String> homeList = new ArrayList<String>();
		ArrayList<String> femaleSpouseList = new ArrayList<String>();
		ArrayList<String> maleSpouseList = new ArrayList<String>();
		ArrayList<String> occupationList = new ArrayList<String>();
		ArrayList<String> transportationList = new ArrayList<String>();
		ArrayList<String> hometownList = new ArrayList<String>();

		/* Add items to home list */
		homeList.add("mansion");
		homeList.add("apartment");
		homeList.add("shack");
		homeList.add("house");

		/* TODO: 1. Add items to femaleSpouseList */
		femaleSpouseList.add("Marge");
		femaleSpouseList.add("Lisa");
		femaleSpouseList.add("Maggie");
		femaleSpouseList.add("Patty");
		femaleSpouseList.add("Selma");
		femaleSpouseList.add("Ms. Krabappel");
		femaleSpouseList.add("Maude");

		/* TODO: 2. Add items to maleSpouseList */
		maleSpouseList.add("Homer");
		maleSpouseList.add("Bart");
		maleSpouseList.add("Ned");
		maleSpouseList.add("Krusty");
		maleSpouseList.add("Ralph");
		maleSpouseList.add("Milhouse");
		
		/* TODO: 3. Add items to occupationList */
		occupationList.add("nuclear power technician");
		occupationList.add("clown");
		occupationList.add("teacher");
		occupationList.add("skateboarder");
		occupationList.add("police chief");

		/* TODO: 4. Add items to transportationList */
		transportationList.add("ride");
		transportationList.add("drive");
		transportationList.add("walk");
		transportationList.add("skateboard");
		transportationList.add("pedal");

		/* TODO: 5. Add items to hometownList */
		hometownList.add("Springfield");
		hometownList.add("Shelbyville");
		hometownList.add("New York");
		hometownList.add("Los Angeles");
		
		/* Print the database */
		System.out.println("--------------------- Future Possibilities Database ------------------------");
		System.out.print("Home List: ");
		for (String item: homeList) {
			System.out.print(item + " ");
		}
		System.out.println();
		
		/* TODO: 6. Print the items in the femaleSpouseList using the ArrayList toString() method */
		System.out.print("Female Spouse List: ");
		System.out.print(femaleSpouseList);
		System.out.println();
		
		/* TODO: 7. Print the items in the maleSpouseList using a for loop (IE: use indexes to print items ) */
		System.out.print("Male Spouse List: ");
		for (int i = 0; i < maleSpouseList.size(); i++) {
			System.out.print(maleSpouseList.get(i) + ", ");
		}
		System.out.println();
		
		/* TODO: 8. Print the items in the occupationList using the ArrayList iterator and a while loop */
		System.out.print("Occupation List: ");
		Iterator<String> occupations = occupationList.iterator();
		while (occupations.hasNext()) {
			System.out.print(occupations.next() + ", ");
		}
		System.out.println();
		/* TODO: 9. Print the items in the transportationList using a foreach loop */
		System.out.print("Transportation List: ");
		for (String transport : transportationList) {
			System.out.print(transport + ", ");
		}
		System.out.println();
		/* TODO: 10. Print the items in the hometownList using the method of your choice */
		System.out.print("Hometown List: ");
		for (String hometown : hometownList) {
			System.out.print(hometown + ", ");
		}
		System.out.println();
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("\n");

		/* Ask the player for their name */
		Scanner kbd = new Scanner(System.in);
		System.out.print("Please enter your name: ");
		String name = kbd.nextLine();
		kbd.close();
		System.out.println("\n\n");
		
		/* Randomly choose items from each List */
		Random rand = new Random();
		String firstHome = homeList.get(rand.nextInt(homeList.size()));	
		
		/* TODO: 11. Use rand object to select each of the following future 
		 * components from above lists. 
		 * */
		String secondHome = homeList.get(rand.nextInt(homeList.size()));
		String occupation = occupationList.get(rand.nextInt(occupationList.size()));
		String transportation = transportationList.get(rand.nextInt(transportationList.size()));
		String hometown = hometownList.get(rand.nextInt(hometownList.size()));
		
		/* TODO: 12. Use the coin to determine whether player's spouse is male or female, 
		 * then randomly select spouse from the corresponding list.
		 */
		boolean coin = rand.nextBoolean();
		String spouse = "?";
		if (coin) { // female
			spouse = femaleSpouseList.get(rand.nextInt(femaleSpouseList.size()));
		}
		else { // male
			spouse = maleSpouseList.get(rand.nextInt(maleSpouseList.size()));
		}

		/* Randomly choose number of years player will be married */
		int yearsOfMarriage = rand.nextInt(30) + 1;

		/* Print the player's future*/
		System.out.println("Welcome "+ name + ", this is your future...");
		System.out.println("You will marry " + spouse + " and live in " + (firstHome.charAt(0) == 'a'?"an ":"a ") + firstHome + ".");
		System.out.println("After " + yearsOfMarriage + (yearsOfMarriage == 1?" year":" years") +" of marriage, you will finally get your dream job of being a " + occupation + ".");
		System.out.println("Your family will move to " + (secondHome.charAt(0) == 'a'?"an ":"a ") + secondHome + " in " + hometown + " where you will " + transportation + " to work each day.");

	}

}
