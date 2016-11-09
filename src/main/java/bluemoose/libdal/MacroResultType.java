package bluemoose.libdal;

/**
 * Enum to describe the result of an attempt to do something with a type of macro.
 * @author Ethan
 *
 */
public enum MacroResultType {
	/**
	 * The operation was succesful.
	 */
	SUCCESS,
	/**
	 * The unique macro ID did not match a supported type.
	 */
	UNSUPPORTED_MACRO_TYPE,
	/**
	 * Some of the parameters provided were not valid.
	 */
	INVALID_PARAMETERS,
	/**
	 * The wrong number of parameters was provided for the macro type.
	 */
	INCORRECT_NUMBER_OF_PARAMETERS,
	
	/**
	 * The macro failed during execution.
	 * Unless the LibDAL was configured to make users wait, this will never
	 * be returned.
	 */
	FAILURE
}
