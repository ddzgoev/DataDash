package bluemoose.libdal;

import java.util.List;

public interface RunMacroResult {
	public MacroResultType wasSuccesful();
	/*
	 * If wasSeccesful is INVALID_PARAMETERS, problems is a list of bad parameters.
	 */
	public List<ParameterType> problems();
}
