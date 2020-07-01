/** 
 * This is a program that prints ASCII art cross
 * 
 * Jason Dudley
 * CS121-002, Spring 2020
**/
public class AsciiArtCross
{
  public static void main (String[] args)
  {
	char border = '#';
	char draw = '.';
	char cross = 'X';
	char space = ' ';

	int columns = 80;
	int rows = 20;
	int column = 0;
	int row = 1;

	// top border
	while (column < columns)
	{
		System.out.print(border);
		column++;
	}
	System.out.println();

	// center section
	column = 1;
	while (row < rows)
	{
		System.out.print(border);
		while (column < (columns - 1))
		{
			if ((row*4) == column || (row*4) == (columns - column) ||(row*2) == column || (row*2) == (columns - column))
			{
				System.out.print(cross);
			}
			else
			{
				if (column % 4 == 0)
					System.out.print(draw);
				else
					System.out.print(space);
			}
			column++;
		}
		System.out.println(border);
		column = 1;
		row++;
	}	

	// bottom border
	column = 0;
	while (column < columns)
	{
		System.out.print(border);
		column++;
	}
	System.out.println();

  }
}
