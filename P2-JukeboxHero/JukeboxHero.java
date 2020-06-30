import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * JukeboxHero
 * 
 * @author Jason Dudley
 * @version CS121-002, Spring 2020
 *
 */
public class JukeboxHero {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		String choice = "";
		ArrayList<Song> songList = new ArrayList<Song>();
		String divider = "";
		for (int i = 0; i < 88; i++) // Fill divider string: 30 + 1 + 20 + 1 + 30 + 1 + 5 = 88
			divider = divider + "-";
		// Program menu
		String menuHeader = "*****************************\n*      Program Menu         *\n*****************************";
		String[] menuOptions = { "(L)oad catalog", "(S)earch catalog", "(A)nalyse catalog", "(P)rint catalog", "(Q)uit",
				"\n" };
		for (String option : menuOptions) {
			System.out.println("       " + option);
		}
		while (!choice.equals("q")) {
			// Prompt for choice
			System.out.print("Please enter a command (press m for Menu): ");
			choice = scan.nextLine().toLowerCase();
			switch (choice) {
			case "m": // Display menu
				System.out.println(menuHeader);
				for (String line : menuOptions) {
					System.out.println("       " + line);
				}
				break;
			case "l": // Load catalog
				System.out.println("Load Catalog...");
				System.out.print("Please enter catalog file to load: ");
				File catalogFile = new File(scan.nextLine());
				if (catalogFile.exists()) {
					try {
						songList.clear(); // Clear before loading catalog
						Scanner fileScan = new Scanner(catalogFile);
						while (fileScan.hasNextLine()) { // For each song in csv
							String songStr = fileScan.nextLine();
							Scanner songScan = new Scanner(songStr);
							songScan.useDelimiter(",");
							String artist = songScan.next();
							String album = songScan.next();
							String title = songScan.next();
							int playTime = songScan.nextInt();
							songList.add(new Song(title, artist, album, playTime));
							songScan.close();
						}
						System.out.println("Successfully loaded " + songList.size() + " songs!");
						fileScan.close();
					} catch (FileNotFoundException e) {
						System.out.println("File not found: " + catalogFile);
					}
				} else {
					System.out.println("Unable to open file: " + catalogFile.getName());
				}
				break;
			case "s": // Search catalog
				System.out.println("Search Catalog...");
				System.out.print("Please enter the search query: ");
				String searchQuery = scan.nextLine().toLowerCase();
				ArrayList<Song> searchResults = new ArrayList<Song>();
				for (int i = 0; i < songList.size(); i++) {
					if (songList.get(i).getTitle().toLowerCase().contains(searchQuery)) {
						searchResults.add(songList.get(i));
					}
				}
				System.out
						.println("Found " + searchResults.size() + (searchResults.size() == 1 ? " match" : " matches"));
				System.out.println(divider);
				for (int i = 0; i < searchResults.size(); i++) {
					System.out.println(searchResults.get(i));
				}
				break;
			case "a": // Analyse catalog
				System.out.println("Catalog Analysis...");
				ArrayList<String> artistList = new ArrayList<String>();
				ArrayList<String> albumList = new ArrayList<String>();
				int playTime = 0;
				for (Song song : songList) {
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
				System.out.println("\tNumber of Songs: " + songList.size());
				System.out.println("\tCatalog Playtime: " + playTime);
				break;
			case "p": // Print catalog
				System.out.println("Song list contains " + songList.size() + " songs...");
				System.out.println(divider);
				for (Song song : songList) {
					System.out.println(song);
				}
				break;
			case "q":
				break;
			default:
				System.out.println("Error: Input not recognized. Please enter valid selection.");
			}
		}
		System.out.println("Goodbye!");
	}

}
