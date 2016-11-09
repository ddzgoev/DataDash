package bluemoose.mediator;

import java.util.List;

/**
 * A request to peer review and run a macro.
 * @author Ethan
 *
 */
public class PeerReviewRequest extends AuthenticatedRequest {
	/**
	 * 
	 * @return The unique unchanging ID of the macro in the system, not the macro type.
	 */
	public String getMacroID() {
		return macroID;
	}
	/**
	 * 
	 * @return The ordered list of parameters used to execute the macro. null if no parameters are changed.
	 */
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
