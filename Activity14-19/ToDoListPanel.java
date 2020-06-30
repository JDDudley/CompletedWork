import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * ToDoListPanel
 * Extends JPanel
 * Container for ToDoList printout
 * 
 * @author Jason Dudley
 * @version CS121-002, Spring 2020
 */
public class ToDoListPanel extends JPanel {
	ToDoList list;
	
	public ToDoListPanel(String name) {
		list = new ToDoList(name); // Create ToDoList
		JLabel listName = new JLabel(name); // Create label
		this.add(listName);
		setLayout(new BoxLayout (this, BoxLayout.Y_AXIS)); // Set layout
	}
	/**
	 * addTask
	 * Add task to ToDo list
	 * @param Task t
	 */
	public void addTask(Task t) {
		list.addTask(t); // Add task to list
		TaskButton taskButton = new TaskButton(t); // Create button
		this.add(taskButton); // add button\
		revalidate();
	}
	/**
	 * showWorkDialog
	 * Displays dialog with next task
	 * @return Task next task
	 */
	
	public void showWorkDialog() {
		Task t = list.getWork();
		if (t == null) {
			JOptionPane.showMessageDialog(null, "No upcoming tasks.");
		}
		else {
			// Show next task
			JOptionPane.showMessageDialog(null, t.toString());
		}
	}
	
}
