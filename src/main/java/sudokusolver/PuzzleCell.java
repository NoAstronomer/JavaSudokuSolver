package sudokusolver;

class PuzzleCell {
	
	int _value = 0;
	boolean _isFixed = false;
	
	PuzzleCell(int value)
	{
		_value = value;
	}
	
	PuzzleCell( int value, boolean isFixed )
	{
		_value = value;
		_isFixed = isFixed;
	}
	
	void Reset()
	{
		_value = 0;
	}
	
	int Value()
	{
		return _value;
	}

}
