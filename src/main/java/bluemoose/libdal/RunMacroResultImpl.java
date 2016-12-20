package bluemoose.libdal;

import java.util.List;

public class RunMacroResultImpl implements RunMacroResult{

	private MacroResultType result;
	private List<ParameterType> invalidParameters;

	@Override
	public MacroResultType wasSuccessful() {
		return result;
	}

	@Override
	public List<ParameterType> problems() {
		if(result.equals(MacroResultType.INVALID_PARAMETERS)) {
			return invalidParameters;
		} else {
			return null;
		}
	}
	
	public RunMacroResultImpl(MacroResultType result, List<ParameterType> invalidParameters) {
		this.result = result;
		this.invalidParameters = invalidParameters;
	}
}
