import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Lesson 13: Activity - GradeBook
 *
 * @author CS121 Instructors
 * @version CS121-002, Spring 2020
 * @author Jason Dudley
 */
public class GradeBook {

	public static void main(String[] args) throws FileNotFoundException { 
		
		/* TODO: 1. Create a new ArrayList of Student objects called gradebook. */
		ArrayList<Student> gradebook = new ArrayList<Student>();
		
		/* TODO: 2. Create a new File object for gradebook.csv and 
		 * a new Scanner object to parse it. Catch any required 
		 * exceptions and display a useful message to the user.
		 */
		File file = new File("students.csv");
		if (file.exists()) {
			try {
				Scanner fileScan = new Scanner(new File ("students.csv"));
				/* TODO: 3. Use a while loop and the Scanner created above to iterate 
				 * through the lines in the gradebook.csv file.
				 */
				while (fileScan.hasNextLine()) {
					/* TODO: 4. For each line (student record), use a second 
					 * Scanner object to tokenize the line using a comma (',')
					 * as the delimiter, extract values for lastName, firstName,
					 * id and grade and store them to local variables.
				 	 */
					String rawStudent = fileScan.nextLine();
					Scanner studentScan = new Scanner(rawStudent);
					studentScan.useDelimiter(",");
					String lastName = studentScan.next();
					String firstName = studentScan.next();
					int id = studentScan.nextInt();
					int rawGrade = studentScan.nextInt();
				 	/* TODO: 5. Create a new Student object using the local variables
				 	 * create above, set the student's grade, and finally add the 
				 	 * new Student object to the gradebook ArrayList. 
					 */
					Student student = new Student(firstName, lastName, id);
					student.setGrade(rawGrade);
					gradebook.add(student);
					studentScan.close();
				}
				/* TODO: 6. Use a foreach loop to print out contents of the gradebook */
				for (Student student : gradebook) {
					System.out.println(student);
				}
				fileScan.close();
			}
			catch(FileNotFoundException e) {
				System.out.println("File not found: " + file);
			}
		}
	}
}
