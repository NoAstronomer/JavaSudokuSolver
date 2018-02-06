package sudokusolver;

public class SudokuSolver {

	public static void main(String[] args)
	{
		// 030000600100702080000005307004080070000650400000200000908100006002070003050006000 - NYT 2/2/2018 Hard

		try
		{
			System.out.println( (new Puzzle( "030000600100702080000005307004080070000650400000200000908100006002070003050006000")).Solve() );
		}
		catch( Exception ex )
		{
			System.out.println( "Error running solver:");
			System.out.println( ex.toString() );
			System.out.println( ex.getMessage() );
		}

	}

}
