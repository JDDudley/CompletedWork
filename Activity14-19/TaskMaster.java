/*
 * 
 * Task Manager
 * Use custom task class to create task list.
 * 
 * @version CS121-002, Spring 2020
 * @author Jason Dudley
 * 
 */

public class TaskMaster {
	public static void main (String[] args) {

		ToDoList list = new ToDoList("Back to School Checklist");
		// create tasks
		Task task1 = new Task("Finish Activity 16", 10);
		Task task2 = new Task("Finish Activity 17", 8);		
		task1.setComplete(true); // Set task1 to complete
		task1.setCategory(Category.School);
		task2.setCategory(Category.School);
		// add to list
		list.addTask(task1);
		list.addTask(task2);
		list.addTask("Finish Activity 18",Category.School);
		// print list
		System.out.println(list);
		// get work
		System.out.println(list.getWork());
	}
}
