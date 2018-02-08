package sudokusolver;

class PuzzleCell {
	
	int _value = 0;
	boolean _isFixed = false;
	
	PuzzleCell( int value, boolean isFixed )
	{
		_value = value;
		_isFixed = isFixed;
	}
	
	public int Value()
	{
		return _value;
	}

	public void Set( int aValue ){
		_value = aValue;
	}

	public boolean IsFixed(){
		return _isFixed;
	}

}
