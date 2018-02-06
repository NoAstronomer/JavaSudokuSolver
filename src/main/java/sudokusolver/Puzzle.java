package sudokusolver;

import java.util.ArrayList;

class Puzzle {
	
	private ArrayList<PuzzleCell> cells = new ArrayList<PuzzleCell> ();
	private PuzzleCellSet[] rows = new PuzzleCellSet[9];
	private PuzzleCellSet[] cols = new PuzzleCellSet[9];
	private PuzzleCellSet[] sqrs = new PuzzleCellSet[9];

    Puzzle( String initValues ) throws Exception
    {
    	if ( initValues.length() != 81 )
    	{
    		throw new Exception( "Init string must be exactly 81 characters long");
    	}
    	
    	int p = 0;
    	for( char c : initValues.toCharArray() )
    	{
    		for( int i = 0; i<9; i ++ )
			{
    			rows[i] = new PuzzleCellSet();
    			cols[i] = new PuzzleCellSet();
    			sqrs[i] = new PuzzleCellSet();
			}
			int v = c - '0'; //Implicit assumption that numbers are sequential in char
    		PuzzleCell pc = new PuzzleCell( v, v == 0);
    		cells.add( pc );
    		rows[p/9].cells[p%9] = pc;
    		cols[p%9].cells[p/9] = pc;
    		sqrs[p/3+3*(p%3)].cells[p%3+3*(p/3)] = pc;
    		p ++;
    	}
    }
    
    String Solve()
    {
    	StringBuffer sb = new StringBuffer();
    	for( PuzzleCell c : cells )
    	{
    		sb.append( Integer.toString(c.Value()) );
    	}
    	return sb.toString();
    }
}
