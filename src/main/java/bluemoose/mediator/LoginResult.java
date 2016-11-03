package bluemoose.mediator;

import bluemoose.adal.AuthUser;

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
