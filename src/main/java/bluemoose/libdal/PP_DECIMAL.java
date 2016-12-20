package bluemoose.libdal;

import java.util.List;

public class PP_DECIMAL implements ParameterPossibilities {
	
	private int length, precision;
	
	public PP_DECIMAL(int length, int precision) {
		this.length = length;
		this.precision = precision;
	}

	@Override
	public PossibilityType getType() {
		return PossibilityType.DECIMAL;
	}

	@Override
	public List<String> getOptions() {
		return null;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public int getPrecision() {
		return precision;
	}

	@Override
	public boolean isValid(String input) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String sanitize(String input) {
		// TODO Auto-generated method stub
		return null;
	}
}
