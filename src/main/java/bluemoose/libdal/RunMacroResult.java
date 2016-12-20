package bluemoose.libdal;

import java.util.List;

/**
 * interface describing the result of running a macro.
 * 
 * @author Ethan
 *
 */
public interface RunMacroResult {
	/**
	 * @return Was the macro successful and why not.
	 */
	public MacroResultType wasSuccessful();
	/**
	 * @return If wasSuccessful is INVALID_PARAMETERS, problems is a list of bad parameters.
	 */
	public List<ParameterType> problems();
}
