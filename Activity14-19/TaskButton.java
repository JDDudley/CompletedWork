import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/*
 * TaskButton class defines one task button for panel
 */
@SuppressWarnings("serial")
public class TaskButton extends JButton {
	// Instance variables
	Task task;
	// Constructor
	public TaskButton(Task task) {
		this.task = task;
		this.setText(task.toString());
		this.addActionListener(new TaskButtonListener());
	}
	// Methods
	
	// Listeners
	private class TaskButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (task.isComplete()) {
				// set to incomplete
				task.setComplete(false);
				setForeground(Color.BLACK);
				setText(task.toString());
			}
			else {
				// set to complete
				task.setComplete(true);
				setForeground(Color.GRAY);
				setText(task.toString());
			}
		}
		
	}
}