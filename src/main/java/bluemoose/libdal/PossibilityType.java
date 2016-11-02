package bluemoose.libdal;

public enum PossibilityType {
	/*
	 * 
	 */
	UNSUPPORTED_PARAMETER,
	/*
	 * For whatever reason, this parameter has no legal values.
	 */
	NONE,
	/*
	 * The parameter is a string with sum maximum length.
	 * Not this does not mean ALL strings fitting that property are valid,
	 * but it does mean this is all the info that LibDAL saw fit to give.
	 */
	STRING,
	/*
	 * The parameter must be one of a list of Strings.
	 */
	LIST,
	/*
	 * The parameter is a decimal with some length and precision.
	 */
	DECIMAL,
	/*
	 * The parameter is a string representing an SQL Date literal.
	 */
	DATE,
	/*
	 * The parameter is a string representing an SQL Time literal.
	 */
	TIME
}
