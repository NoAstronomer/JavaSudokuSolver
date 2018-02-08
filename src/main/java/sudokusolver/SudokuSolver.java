package sudokusolver;

public class SudokuSolver {

	public static String p = "030000600100702080000005307004080070000650400000200000908100006002070003050006000";

	public static void main(String[] args)
	{
		// 030000600100702080000005307004080070000650400000200000908100006002070003050006000 - NYT 2/2/2018 (Hard)
		// 703200000000015073480070200014000030000980601820001004040069080100300509360800040 - 24/7 Sudoku (Easy)

		try
		{
			String s = (new Puzzle( "030000600100702080000005307004080070000650400000200000908100006002070003050006000")).Solve();
			System.out.println( s );
		}
		catch( Exception ex )
		{
			System.out.println( "Error running solver:");
			System.out.println( ex.toString() );
			System.out.println( ex.getMessage() );
			ex.printStackTrace();
		}

	}

}
