/**
  * This program prints modern art with ascii characters
  *
  * @author Jason Dudley
  * @version CS121-002, Spring 2020
**/

public class ModernArtAdvanced
{
	public static void main (String[] args)
	{
		int rows = 40;
		int row = 0;
		int columns = 80;		
		int column = 0;

		char h_border = '-';
		char v_border = '|';
		char draw = '*';
		
		while (row < rows)
		{
			System.out.print(v_border);
			column++;
			while (column < columns - 1)
			{
				if (row == 0 || row == (rows - 1))
					System.out.print(h_border);
				else
					System.out.print(draw);
				column++;
			}
			System.out.print(v_border);
			System.out.println();
			column = 0;
			row++;
		}
	}
}
