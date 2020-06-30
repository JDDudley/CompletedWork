import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Lesson 4: Activity - Using Classes and Objects
 * 
 * Uses the MiniFig class to draw a custom avatar.
 * 
 * @author CS121 instructors
 * @author Jason Dudley
 * @version CS121-002, Spring 2020
 * 
 */
@SuppressWarnings("serial")
public class MyAvatar extends JPanel
{
	public final int INITIAL_WIDTH = 800;
	public final int INITIAL_HEIGHT = 600;
	
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param canvas The drawing area of the window.
	 */
	public void paintComponent (Graphics g)
	{
		/* Store the height and width of the panel at the time
		 * the paintComponent() method is called.
		 */
		int currentHeight = getHeight();
		int currentWidth = getWidth();
		
		/* This is the anchor point for the MiniFig (x,y) -> (mid,top) */
		int mid = currentWidth / 2;
		int top = 50;
		
		/* This is the scaler that is used to calculate the dimensions (height / width) 
		 * of each of the MiniFig components. It uses the Math.min() function to select
		 * the smaller of currentWidth/INITIAL_WIDTH and currentHeight/INITIAL_HEIGHT.
		 * This way all the components are scaled to fit within the smaller of the two 
		 * panel dimensions.
		 */
		double scaleFactor = Math.min(currentWidth/(double)INITIAL_WIDTH,currentHeight/(double)INITIAL_HEIGHT );

		Point anchor = new Point(mid,top);
		MiniFig pete = new MiniFig(g, scaleFactor, anchor);
		
		Color myBlue = new Color (0,0,112);

		Point basePoint = pete.getBaseMidPoint();
		int grassYOffset = basePoint.y;
		Color grassGreen = new Color (60,80,38);
		g.setColor(grassGreen);
		g.fillRect(0, grassYOffset, currentWidth, currentHeight - grassYOffset);
		MiniFig peter = pete;
		Color myWhite = new Color (255,255,255);
		
		peter.setTorsoColor(myWhite);
		peter.setLegColor(myBlue);
		peter.setArmColor(Color.gray);
		peter.setBeltColor(Color.black);
		peter.setFootColor(Color.black);
		peter.draw();
		
		// Glasses
		int glassesHeight = pete.getFaceHeight() / 3;
		int glassesWidth = pete.getFaceWidth();
		int glassesX = pete.getCapPoint().x - glassesWidth / 2;
		int glassesY = pete.getCapPoint().y + glassesWidth / 3;
		g.setColor(Color.black);
		g.fillRect(glassesX,  glassesY, glassesWidth, glassesHeight / 2);
		g.fillOval(glassesX + glassesWidth / 12, glassesY - glassesHeight / 6,
				glassesWidth * 5 / 12, glassesHeight);
		g.fillOval(glassesX + glassesWidth / 2, glassesY - glassesHeight / 6,
				glassesWidth * 5 / 12, glassesHeight);
		// Bat in hand
		Point batBasePoint = pete.getRightHandCenterPoint();
		int batHeight = pete.getHeight() / 2;
		int batWidth = pete.getWidth() / 12;
		int batTopY = batBasePoint.y - batHeight - batWidth;
		int batX[] = {batBasePoint.x - batWidth / 2,batBasePoint.x - batWidth,
				batBasePoint.x + batWidth, batBasePoint.x + batWidth / 2};
		int batY[] = {batBasePoint.y, batBasePoint.y - batHeight,
				batBasePoint.y - batHeight, batBasePoint.y};
		int batPoints = 4;
		Color batColor = new Color (210,180,140);
		g.setColor(batColor);
		g.fillPolygon(batX, batY, batPoints);
		g.fillOval(batBasePoint.x - batWidth, batTopY,
				batWidth * 2, batWidth * 2);
		g.fillOval(batBasePoint.x - batWidth, batBasePoint.y - batWidth, 
				batWidth * 2, batWidth * 2);
		
		// Printer
		int printerHeight = pete.getHeight() / 3;
		int printerWidth = pete.getWidth();
		int printerX = pete.getBaseMidPoint().x + printerWidth / 2;
		int printerY = pete.getBaseMidPoint().y - printerHeight;
		g.setColor(Color.lightGray);
		g.fillRect(printerX, printerY, printerWidth, printerHeight);
		g.setColor(Color.darkGray);
		g.fillRect(printerX, printerY + printerHeight * 2 / 3, 
				printerWidth, printerHeight / 3);
		
		// Printer display
		g.setColor(Color.white);
		g.fillRect(printerX + printerWidth / 12, printerY + printerWidth / 12, 
				printerWidth / 3, printerHeight / 3);
		
		// Printer outlines, details, text
		g.setColor(Color.black);
		g.fillRect(printerX + printerWidth / 12, printerY,
				printerWidth * 10 / 12, printerHeight / 12);
		g.drawRect(printerX, printerY, printerWidth, printerHeight);
		g.drawRect(printerX, printerY + printerHeight * 2 / 3, 
				printerWidth, printerHeight / 3);
		g.drawRect(printerX + printerWidth / 12, printerY + printerWidth / 12, 
				printerWidth / 3, printerHeight / 3);
		g.drawLine(printerX + printerWidth / 2, printerY + printerWidth / 12, 
				printerX + printerWidth * 11 / 12, printerY + printerWidth / 12);
		g.drawLine(printerX + printerWidth / 2, printerY + printerWidth / 6, 
				printerX + printerWidth * 11 / 12, printerY + printerWidth / 6);
		g.drawLine(printerX + printerWidth / 2, printerY + printerWidth / 4, 
				printerX + printerWidth * 11 / 12, printerY + printerWidth / 4);
		g.drawString("PC Load", printerX + printerWidth * 3 / 24, 
				printerY + printerWidth * 2 / 12);
		g.drawString("Letter", printerX + printerWidth * 3 / 24,
				printerY + printerWidth * 3 / 12);
	}


	/**
	 * Constructor (panel initialization)
	 */
	public MyAvatar()
	{
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
	}

	/**
	 * Sets up a JFrame and the MiniFigDriver panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MyAvatar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MyAvatar());
		frame.pack();
		frame.setVisible(true);
	}
}
