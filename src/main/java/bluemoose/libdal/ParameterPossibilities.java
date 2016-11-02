package bluemoose.libdal;

import java.util.List;

public interface ParameterPossibilities {
	public PossibilityType getType();
	
	/*
	 * All possibilities.
	 * Only valid if getType Type is LIST
	 */
	public List<String> getOptions();
	
	/*
	 * Maximum total length of the parameter.
	 * Always valid
	 */
	public int getLength();
	
	/*
	 * Maximum number of decimal digits stored after the decimal point
	 * Only valid when getType is DECIMAL
	 */
	public int getPrecision();
}
