package bluemoose.mediator;

import java.util.List;

/**
 * A request to the mediator for a list of descriptions for a list of parameters.
 * @author Ethan
 *
 */
public class ParameterListRequest extends AuthenticatedRequest {
	final List<String> parameterIDs;

	/**
	 * 
	 * @return A list of unique, unchanging, parameter IDs.
	 */
	public List<String> getParameterIDs() {
		return parameterIDs;
	}

	public ParameterListRequest(String authentication, List<String> parameterIDs) {
		super(authentication);
		this.parameterIDs = parameterIDs;
	}
}
