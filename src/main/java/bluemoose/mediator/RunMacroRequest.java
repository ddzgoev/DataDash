package bluemoose.mediator;

import java.util.List;

public class RunMacroRequest extends AuthenticatedRequest {
	public RunMacroRequest(String authentication, String macroType, List<String> parameters, boolean skipReview) {
		super(authentication);
		this.macroType = macroType;
		this.parameters = parameters;
		this.skipReview = skipReview;
	}

	final String macroType;
	final List<String> parameters;
	final boolean skipReview;

	public String getMacroType() {
		return macroType;
	}

	public List<String> getParameters() {
		return parameters;
	}

	public boolean isSkipReview() {
		return skipReview;
	}
	

}
