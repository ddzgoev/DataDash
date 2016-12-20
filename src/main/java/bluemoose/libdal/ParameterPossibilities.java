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
	
	/**
	 * Checks if a given input from a user is a valid example of this possibility type
	 * @return true if the input is valid, false if it is not
	 */
	public boolean isValid(String input);
	
	/**
	 * 
	 * @param input
	 * @return the sanitized string
	 */
	public String sanitize(String input);
}
