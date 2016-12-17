package bluemoose.libdal;

import java.util.List;

public class PP_DATE implements ParameterPossibilities {

	private int length;

	public PP_DATE(int length) {
		this.length = length;
	}

	@Override
	public PossibilityType getType() {
		return PossibilityType.DATE;
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
		return -1;
	}

}
