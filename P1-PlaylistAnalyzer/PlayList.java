import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * PlayList gathers data from users to create song listings and then
 * analyzes them by playtime and sorts before printing.
 * 
 * @author Jason Dudley
 * @version CS121-002, Spring 2020
 * 
 */
public class PlayList {
	public static void main (String[] args) {
		final int LIST_LENGTH = 3; // Set number of songs to gather from user and process
		Scanner scan = new Scanner(System.in);
		DecimalFormat decFmt = new DecimalFormat("0.00"); // Set format for average length
		ArrayList<Song> newSongs = new ArrayList<Song>(); // New song array
		
		// Gather data from user
		for (int x = 0; x < LIST_LENGTH; x++) {
			System.out.print("Enter title: ");
			String title = scan.nextLine(); // Scan title
			System.out.print("Enter artist: ");
			String artist = scan.nextLine(); // Scan artist
			System.out.print("Enter album: ");
			String album = scan.nextLine(); // Scan album
			System.out.print("Enter play time (mm:ss): ");
			String timeStr = scan.nextLine(); // time as mm:ss format string
			// Time conversion to seconds
			int min = 0, sec;
			if (timeStr.indexOf(':') > 0) { // If properly formatted, parse
				min = Integer.parseInt(timeStr.substring(0, timeStr.indexOf(':')));
				sec = Integer.parseInt(timeStr.substring(timeStr.indexOf(':')+1));
			} else { // Assume seconds
				sec = Integer.parseInt(timeStr);				
			}
			int timeInt = min * 60 + sec; // time in seconds
			// Create song object
			newSongs.add(new Song(title, artist, album, timeInt));
		}
		
		// Variables to calculate average and find song closest to 4 minutes playtime
		double avgSum = 0;
		int closestDiff = Math.abs(newSongs.get(0).getPlayTime() - 240); // save first for comparison
		Song closestSong = newSongs.get(0); // first initially considered closest
		// Loop through songs to compare length and calculate average
		for (Song song : newSongs) {
			if (Math.abs(song.getPlayTime() - 240) < closestDiff) { // If closer than closest
				closestDiff = Math.abs(song.getPlayTime() - 240);
				closestSong = song;
			}
			// For average calculation
			avgSum += song.getPlayTime();
		}
		// Print average and closest
		System.out.print("\n\nAverage playtime for songs: ");
		System.out.print(decFmt.format(avgSum / LIST_LENGTH)); // Print formatted average time
		System.out.print("\n\nSong with the play time closest to 240 secs: ");
		System.out.println(closestSong.getTitle() + "\n"); // Print closest song title
		
		// Sort songs
		for (int x = 0; x < LIST_LENGTH - 1; x++) { // song(0)..song(n-1)
			// while song(x) is longer than song(x+1), delete and add to end
			while (newSongs.get(x).getPlayTime() > newSongs.get(x+1).getPlayTime()) {
				Song song = newSongs.get(x); // save song to variable
				newSongs.remove(x); // delete from wrong spot
				newSongs.add(song); // add to end
				// Handles sorting back, condition short-circuits if at index 0
				if (x > 0 && newSongs.get(x-1).getPlayTime() > newSongs.get(x).getPlayTime())
					x--;
			}
		}
		
		// Create header string variables and fill
		String header = String.format("%-30s %-20s %-30s %5s","Title","Artist","Album","Time");
		String divider = "";
		for (int i = 0; i < 88; i++) // Fill divider string: 30 + 1 + 20 + 1 + 30 + 1 + 5 = 88
			divider = divider + "=";
		// Print header
		System.out.println(divider);
		System.out.println(header);
		System.out.println(divider);
		// Print songs using custom toString override
		for (Song song : newSongs) {
			System.out.println(song);
		}
		System.out.println(divider);
		// Close scanner
		scan.close();
	}
}

