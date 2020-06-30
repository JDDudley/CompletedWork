/*
 * 
 * Task class
 * Contains description, priority, and completion information
 * 
 * @author Jason Dudley
 * @version CS121-002, Spring 2020
 * 
 */
enum Category {Personal,Work,School,None};

public class Task implements Comparable<Task> {
	private String description;
	private int priority;
	private boolean complete;
	private Category category;
	/**
	 * Create new task object
	 * @param description
	 * @param priority
	 * @param category
	 */
	public Task (String description, int priority, Category category) {
		this.description = description;
		this.priority = priority;
		this.complete = false;
		this.category = category;
	}
	/**
	 * Create new task object
	 * @param description
	 * @param priority
	 */
	public Task (String description, int priority) {
		this.description = description;
		this.priority = priority;
		this.complete = false;
		this.category = Category.None;
	}
	/**
	 * Create new task object with only description (default priority 0)
	 * @param description
	 */
	public Task (String description) {
		this.description = description;
		this.priority = 0;
		this.complete = false;
		this.category = Category.None;
	}
	/**
	 * setDescription
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * getDescription
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * setPriority
	 * @param priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * getPriority
	 * @return priority
	 */
	public int getPriority() {
		return this.priority;
	}
	/**
	 * setCategory
	 * @param Category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	/**
	 * getCategory
	 * @return Category
	 */
	public Category getCategory() {
		return this.category;
	}	
	
	/**
	 * setComplete
	 * @param complete
	 */
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	/**
	 * isComplete
	 * @return complete
	 */
	public boolean isComplete() {
		return this.complete;
	}
	/**
	 * equals: compare if description & category are same as parameter task
	 * @param Task for comparison
	 * @return boolean
	 */
	public boolean equals(Task comparison) {
		if (this.description.equalsIgnoreCase(comparison.description) && 
				this.category.equals(comparison.category)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * compareTo: compare priority of this task with parameter
	 * @param Task
	 * @return int 
	 */
	public int compareTo(Task comparison) {
		if (this.isComplete() && !comparison.isComplete()) { // this task is less
			return -1;
		}
		else if (!this.isComplete() && comparison.isComplete()) { // this task is more
			return 1;
		}
		else { // both are complete or incomplete
			if (this.getPriority() < comparison.getPriority()) { // this task is less
				return -1;
			}
			else if (this.getPriority() > comparison.getPriority()) { // this task is more
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	@Override
	public String toString() {
		String output = "";
		output += ((this.complete)? "[X]" : "[ ]") + " " + description + ", " + category + ", " + priority;
		return output;
	}
}
