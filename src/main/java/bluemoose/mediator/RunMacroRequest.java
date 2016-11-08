package bluemoose.mediator;

import java.util.List;

/**
 * A request to the mediator to submit a macro to the system.
 */
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

	/**
	 * The unique unchanging ID of the type of macro.
	 * @return
	 */
	public String getMacroType() {
		return macroType;
	}

	/**
	 * 
	 * @return The ordered list of parameters used to execute the macro.
	 */
	public List<String> getParameters() {
		return parameters;
	}

	/**
	 * 
	 * @return True if the request is to execute the macro without awaiting peer review.
	 */
	public boolean isSkipReview() {
		return skipReview;
	}
	

}
