/**
  * This program draws ascii art using string variables and concatenation.
  *
  * @author Jason Dudley
  * @version CS121-002, Spring 2020
  *
**/

public class ModernArt
{
	public static void main (String[] args)
	{
		String name = "Jason";

		final String A = " X   X  XXXX X     X      XXX      X   X  XXX  XXXX  X     XXXX ";
		final String B = " X   X X     X     X     X   X     X   X X   X X   X X     X   X";
		final String C = " XXXXX XXXX  X     X     X   X     X X X X   X XXXX  X     X   X";
		final String D = " X   X X     X     X     X   X     XX XX X   X X X   X     X   X";
		final String E = " X   X  XXXX  XXXX  XXXX  XXX      X   X  XXX  X   X  XXXX XXXX ";
		
		System.out.print("Good morning, " + name + ".\n\n");

		System.out.println(A);
		System.out.println(B);
		System.out.println(C);
		System.out.println(D);
		System.out.println(E);
	}
}
