package bluemoose.adal;

/*
 * The result of a login or authentication check.
 */
public interface AuthUser {
	public String getFname();
	public String getLname();
	public String getAuthToken();
	
	/*
	 * Indicates whether user is logged in or not and why.
	 * Above getters only valid if user is logged in.
	 */
	public LoginResult success();
}
