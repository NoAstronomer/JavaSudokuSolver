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

        for( int i = 0; i<9; i ++ )
        {
            rows[i] = new PuzzleCellSet();
            cols[i] = new PuzzleCellSet();
            sqrs[i] = new PuzzleCellSet();
        }

    	int p = 0;
    	for( char c : initValues.toCharArray() )
    	{
			int v = c - '0'; //Implicit assumption that numbers are sequential in char
    		PuzzleCell pc = new PuzzleCell( v, v != 0);
    		cells.add( pc );
    		rows[p/9].cells[p%9] = pc;
    		cols[p%9].cells[p/9] = pc;
    		sqrs[(3*(p/27))+((p/3)%3)].cells[ (p%3)+((p/9)%3)*3 ] = pc;
    		p ++;
    	}

    	//for( int t=0; t<81; t++ )
        //   System.out.println( cells.get(t).Value());
    	//    System.out.printf( "%d:%d-%d\n", t,(3*(t/27))+((t/3)%3),(t%3)+((t/9)%3)*3);
    }
    
    public String Solve()
    {
    	StringBuffer sb = new StringBuffer();
    	if( TrySolution(0)) {
            for (PuzzleCell c : cells) {
                sb.append(Integer.toString(c.Value()));
            }
            return sb.toString();
        }
        else
            return "Puzzle not solvable.";
    }

    private boolean TrySolution( int cellId )
	{
		if( cellId == 81 )
            return true;

		if( cells.get( cellId ).IsFixed() )
		{
            if (TrySolution(cellId + 1))
                return true;
        }
		else
        {
            for (int testVal = 1; testVal <= 9; testVal++) {
                cells.get( cellId ).Set( testVal );
                if( IsValid() )
                    if (TrySolution(cellId + 1))
                        return true;

            }
            cells.get( cellId ).Set( 0 );
        }

		return false;
	}

	public boolean IsValid()
	{
		for( int i = 0; i<9; i++ )
			if( (! rows[i].IsValid()) || (! cols[i].IsValid()) || (! sqrs[i].IsValid()))
				return false;

		return true;
	}

	public boolean IsComplete()
	{
		for( int i = 0; i<9; i++ )
			if( ! rows[i].IsComplete() || ! cols[i].IsComplete() || ! sqrs[i].IsComplete())
				return false;

		return true;

	}
}
