package bluemoose.mediator;

import java.util.List;

public class ParameterListRequest extends AuthenticatedRequest {
	final List<String> parameterIDs;

	public List<String> getParameterIDs() {
		return parameterIDs;
	}

	public ParameterListRequest(String authentication, List<String> parameterIDs) {
		super(authentication);
		this.parameterIDs = parameterIDs;
	}
}
