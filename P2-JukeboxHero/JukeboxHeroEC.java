import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * JukeboxHeroEC
 * 
 * 
 * @author Jason Dudley
 * @version CS121-002, Spring 2020
 *
 */
public class JukeboxHeroEC {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		String choice = "";
		ArrayList<Song> songList = new ArrayList<Song>();
		// Menu
		displayMenu();
		// Loop until q selected
		while (!choice.equals("q")) {
			// Prompt for choice
			System.out.print("Please enter a command (press m for Menu): ");
			choice = scan.nextLine().toLowerCase();
			switch (choice) {
			case "m": // Display menu
				displayMenu();
				break;
			case "l": // Load catalog
				loadCatalog(songList, scan);
				break;
			case "s": // Search catalog
				searchCatalog(songList, scan);
				break;
			case "a": // Analyse catalog
				analyseCatalog(songList);
				break;
			case "p": // Print catalog
				printCatalog(songList);
				break;
			default:
				System.out.println("Error: Input not recognized. Please enter valid selection.");
			}
		}
		System.out.println("Goodbye!");
	}

	private static void displayMenu() {
		String menuHeader = "*****************************\n*      Program Menu         *\n*****************************";
		String[] menuOptions = { "(L)oad catalog", "(S)earch catalog", "(A)nalyse catalog", "(P)rint catalog", "(Q)uit"};
		System.out.println(menuHeader);
		for (String option : menuOptions) {
			System.out.println("       " + option);
		}
	}

	private static void loadCatalog(ArrayList<Song> sl, Scanner kbd) {
		System.out.println("Load Catalog...");
		System.out.print("Please enter catalog file to load: ");
		File catalogFile = new File(kbd.nextLine());
		if (catalogFile.exists()) {
			try {
				sl.clear(); // Clear before loading catalog
				Scanner fileScan = new Scanner(catalogFile);
				while (fileScan.hasNextLine()) { // For each song in csv
					String songStr = fileScan.nextLine();
					Scanner songScan = new Scanner(songStr);
					songScan.useDelimiter(",");
					String artist = songScan.next();
					String album = songScan.next();
					String title = songScan.next();
					int playTime = songScan.nextInt();
					sl.add(new Song(title, artist, album, playTime));
					songScan.close();
				}
				System.out.println("Successfully loaded " + sl.size() + " songs!");
				fileScan.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not found: " + catalogFile);
			}
		} else {
			System.out.println("Unable to open file: " + catalogFile.getName());
		}
	}

	private static void searchCatalog(ArrayList<Song> sl, Scanner kbd) {
		System.out.println("Search Catalog...");
		System.out.print("Please enter the search query: ");
		String searchQuery = kbd.nextLine().toLowerCase();
		ArrayList<Song> searchResults = new ArrayList<Song>();
		for (int i = 0; i < sl.size(); i++) {
			if (sl.get(i).getTitle().toLowerCase().contains(searchQuery)) {
				searchResults.add(sl.get(i));
			}
		}
		System.out.println("Found " + searchResults.size() + (searchResults.size() == 1 ? " match" : " matches"));
		String divider = "";
		for (int i = 0; i < 88; i++)
			divider = divider + "-";
		System.out.println(divider);
		for (int i = 0; i < searchResults.size(); i++) {
			System.out.println(searchResults.get(i));
		}
	}

	private static void printCatalog(ArrayList<Song> sl) {
		System.out.println("Song list contains " + sl.size() + " songs...");
		String divider = "";
		for (int i = 0; i < 88; i++)
			divider = divider + "-";
		System.out.println(divider);
		for (Song song : sl) {
			System.out.println(song);
		}
	}
	
	private static void analyseCatalog(ArrayList<Song> sl) {
		System.out.println("Catalog Analysis...");
		ArrayList<String> artistList = new ArrayList<String>();
		ArrayList<String> albumList = new ArrayList<String>();
		int playTime = 0;
		for (Song song : sl) {
			if (!artistList.contains(song.getArtist())) {
				artistList.add(song.getArtist());
			}
			if (!albumList.contains(song.getAlbum())) {
				albumList.add(song.getAlbum());
			}
			playTime += song.getPlayTime();
		}
		System.out.println("\tNumber of Artists: " + artistList.size());
		System.out.println("\tNumber of Albums: " + albumList.size());
		System.out.println("\tNumber of Songs: " + sl.size());
		System.out.println("\tCatalog Playtime: " + playTime);
	}
}
