package bluemoose.libdal;

import java.util.List;

public class PP_UNSUPPORTED_PARAMETER implements ParameterPossibilities {

	@Override
	public PossibilityType getType() {
		return PossibilityType.UNSUPPORTED_PARAMETER;
	}

	@Override
	public List<String> getOptions() {
		return null;
	}

	@Override
	public int getLength() {
		return -1;
	}

	@Override
	public int getPrecision() {
		return -1;
	}

	@Override
	public boolean isValid(String input) {
		return false;
	}

	@Override
	public String sanitize(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
