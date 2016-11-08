package bluemoose.libdal;

/**
 * enum representing the variety of parameter description.
 * @author Ethan
 *
 */
public enum PossibilityType {
	/**
	 * The parameter ID did not match any supported parameter type.
	 */
	UNSUPPORTED_PARAMETER,
	/**
	 * For whatever reason, this parameter has no legal values.
	 */
	NONE,
	/**
	 * The parameter is a string with some maximum length.
	 * Not this does not mean ALL strings fitting that property are valid,
	 * but it does mean this is all the info that LibDAL saw fit to give.
	 */
	STRING,
	/**
	 * The parameter must be one of a list of Strings. All other values
	 * are invalid.
	 */
	LIST,
	/**
	 * The parameter is a decimal with some length and precision.
	 */
	DECIMAL,
	/**
	 * The parameter is a string representing an SQL Date literal.
	 */
	DATE,
	/**
	 * The parameter is a string representing an SQL Time literal.
	 */
	TIME
}
