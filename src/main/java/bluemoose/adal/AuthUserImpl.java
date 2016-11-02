package bluemoose.adal;

/*
 * Indicates that a user is logged in.
 * Contains the information about the user who logged in.
 */
public class AuthUserImpl implements AuthUser{
	public final String fname;
	public final String lname;
	public final String authToken;
	
	AuthUserImpl(String fname, String lname, String authToken) {
		this.fname = fname;
		this.lname = lname;
		this.authToken = authToken;
	}
	
	@Override
	public String getFname() {
		return fname;
	}
	
	@Override
	public String getLname() {
		return lname;
	}
	
	@Override
	public String getAuthToken() {
		return authToken;
	}
	
	@Override
	public LoginResult success() {
		return LoginResult.SUCCESS;
	}
}
