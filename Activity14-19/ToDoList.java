import java.util.ArrayList;
import java.util.Collections;

/*
 * ToDoList contains a group of tasks
 * 
 * @author Jason Dudley
 * @version CS121-002, Spring 2020
 * 
 */

public class ToDoList implements ToDoListInterface {
	private String name;
	private ArrayList<Task> tasks;
	/**
	 * ToDoList Constructor takes list name
	 * @param String name
	 */
	public ToDoList(String name) {
		this.name = name;
		this.tasks = new ArrayList<Task>();
	}
	/**
	 * getName returns name of list
	 * @return String
	 */
	public String getName() {
		return name;
	}
	/**
	 * addTask adds task to to do list
	 * @param Task t
	 */
	public void addTask(Task t) {
		tasks.add(t);
	}
	/**
	 * addTask adds task to to do list
	 * @param String description
	 */
	public void addTask(String description) {
		tasks.add(new Task(description));
	}
	/**
	 * addTask adds task to to do list
	 * @param Task t
	 */
	public void addTask(String description, Category category) {
		Task task = new Task(description);
		task.setCategory(category);
		tasks.add(task);
	}
	/**
	 * getWork returns next incomplete task with highest priority
	 * @return Task
	 */
	public Task getWork() {
		if (tasks.isEmpty()) {
			return null;
		}
		else {
			Task maxTask = Collections.max(tasks);
			if (maxTask.isComplete()) {
				return null;
			}
			else {
				return maxTask;
			}
		}
	}
	
	/**
	 * getTaskList returns the list of tasks
	 * @return ArrayList<Task>
	 */
	public ArrayList<Task> getTaskList() {
		return tasks;
	}
	
	public String toString() {
		String output = "";
		String delim = "";
		for (int i = 0; i < this.name.length(); i++) {
			delim += "=";
		}
		// add header
		output += delim + "\n" + this.name + "\n" + delim + "\n";
		// print each task
		for (Task task : tasks) {
			output += task + "\n";
		}
		return output;
	}
}