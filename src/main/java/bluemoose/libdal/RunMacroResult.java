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
	 * @return Was the macro succesful and why not.
	 */
	public MacroResultType wasSuccesful();
	/**
	 * If wasSeccesful is INVALID_PARAMETERS, problems is a list of bad parameters.
	 */
	public List<ParameterType> problems();
}
