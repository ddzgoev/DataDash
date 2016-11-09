package bluemoose.mediator;

import bluemoose.adal.AuthUser;

/**
 * 
 * @author Ethan
 *
 */
public class LoginResult extends MediatorResult {
	final AuthUser result;
	/**
	 * 
	 * @return the result of logging in, only valid if getStatus() is SUCCESS
	 */
	public AuthUser getResult() {
		return result;
	}

	public LoginResult(MediatorStatus status, AuthUser result) {
		super(status);
		this.result = result;
	}
}
