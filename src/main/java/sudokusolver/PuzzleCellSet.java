package sudokusolver;

import java.util.ArrayList;

class PuzzleCellSet extends ArrayList<PuzzleCell>
{
	PuzzleCell[] cells = new PuzzleCell[9];
	
	boolean IsValid()
	{
		return true;
	}
	
	boolean IsComplete()
	{
		for( PuzzleCell c : cells )
			if( c.Value() == 0 )
				return false;
		return true;
	}

	/**
	 * Generated UID
	 */
	private static final long serialVersionUID = -1469935036055306197L;

}
