package bluemoose.adal;

/*
 * Indicates that a user is not logged in.
 */
public class AuthUserFailure implements AuthUser {
	
	private final LoginResult message;
	
	AuthUserFailure(LoginResult message){
		this.message = message;
	}

	@Override
	public String getFname() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getLname() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getAuthToken() {
		throw new UnsupportedOperationException();
	}

	@Override
	public LoginResult success() {
		return message;
	}

}
