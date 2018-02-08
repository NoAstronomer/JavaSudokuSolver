package sudokusolver;

import java.util.ArrayList;

class PuzzleCellSet extends ArrayList<PuzzleCell>
{
	PuzzleCell[] cells = new PuzzleCell[9];
	
	public boolean IsValid()
	{
		boolean[] s = new boolean[9];
        for( PuzzleCell c : cells )
		{
			if( c.Value() != 0) {
                if (s[c.Value() - 1])
                    return false;
                else
                    s[c.Value() - 1] = true;
            }
		}
		return true;
	}
	
	public boolean IsComplete()
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
