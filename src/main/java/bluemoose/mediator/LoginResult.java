package bluemoose.mediator;

import bluemoose.adal.AuthUser;

//result is null when login failed.
public class LoginResult extends MediatorResult {
	final AuthUser result;

	public AuthUser getResult() {
		return result;
	}

	public LoginResult(MediatorStatus status, AuthUser result) {
		super(status);
		this.result = result;
	}
}
