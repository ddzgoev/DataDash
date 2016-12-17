package bluemoose.libdal;

import java.util.List;

/**
 * Describes a Parameter Type including most importantly a description of valid value.
 * @author Ethan
 *
 */
public interface ParameterPossibilities {
	public PossibilityType getType();
	
	/**
	 * @return All possibilities. Only valid if getType Type is LIST
	 * Returns null when invalid
	 */
	public List<String> getOptions();
	
	/**
	 * @return Maximum total length of parameter.
	 * Returns -1 when invalid
	 */
	public int getLength();
	
	/**
	 * @return Maximum number of decimal digits stored after the decimal point
	 * Only valid when getType is DECIMAL
	 * Returns -1 when invalid
	 */
	public int getPrecision();
}
