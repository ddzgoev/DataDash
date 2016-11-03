package bluemoose.mediator;

import java.util.List;

public class PeerReviewRequest extends AuthenticatedRequest {
	public String getMacroID() {
		return macroID;
	}
	public List<String> getParamaters() {
		return paramaters;
	}
	final String macroID;
	final List<String> paramaters;
	/*
	 * If no parameters were altered the list can be null
	 * Otherwise it must contain all parameters, including ones that were
	 * NOT altered.
	 */
	public PeerReviewRequest(String authentication, String macroID, List<String> paramaters) {
		super(authentication);
		this.macroID = macroID;
		this.paramaters = paramaters;
	}
}
