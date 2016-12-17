package bluemoose.libdal;

import java.util.List;

public class PP_LIST implements ParameterPossibilities {

	private List<String> options;
	private int length;

	public PP_LIST(List<String> options, int length) {
		this.options = options;
		this.length = length;
	}
	
	@Override
	public PossibilityType getType() {
		return PossibilityType.LIST;
	}

	@Override
	public List<String> getOptions() {
		return null;
	}

	@Override
	public int getLength() {
		return 0;
	}

	@Override
	public int getPrecision() {
		return -1;
	}
}