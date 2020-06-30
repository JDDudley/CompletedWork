import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lesson 18-19: Activity - Task Master GUI
 * 
 * This class represents the main TaskMaster JPanel. 
 * 
 * It contains a ToDoListPanel and the control sub-panel.
 * 
 * @author CS121 Instructors
 * @version CS121-002, Spring 20200
 * @author Jason Dudley
 */
@SuppressWarnings("serial")
public class TaskMasterPanel extends JPanel
{	
	// Instance variables
	private JLabel listName = new JLabel();
	private JButton addTask;
	private JButton getWork;
	private Task task;
	private ToDoListPanel listPanel;
	JTextField descriptionField;
	private JScrollPane toDoListScrollPane;
//	ToDoList list = new ToDoList("GUI To Do List");
	
	public TaskMasterPanel()
	{
		JPanel controlPanel = new JPanel();
		descriptionField = new JTextField(15);
		this.setPreferredSize(new Dimension(500, 400));
		this.setBackground(Color.GRAY);
		setLayout(new BorderLayout());
		listPanel = new ToDoListPanel("Activity 19 List");
		toDoListScrollPane = new JScrollPane(listPanel);
		toDoListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		toDoListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(toDoListScrollPane, BorderLayout.CENTER);
		listPanel.addTask(new Task("Activity 19"));
		listPanel.addTask(new Task("Activity 20"));
		listPanel.addTask(new Task("Activity 21"));
		this.addTask = new JButton("Add Task");
		this.getWork = new JButton("Get Work");
		this.addTask.addActionListener(new AddTaskButtonListener());
		this.getWork.addActionListener(new GetWorkButtonListener());
		controlPanel.add(descriptionField);
		controlPanel.add(addTask);
		controlPanel.add(getWork);
		this.add(controlPanel, BorderLayout.SOUTH);
	}
	
	// Listeners
	private class AddTaskButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String description = descriptionField.getText();
			listPanel.addTask(new Task(description));
		}
		
	}
	
	private class GetWorkButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			listPanel.showWorkDialog();
		}
		
	}
}