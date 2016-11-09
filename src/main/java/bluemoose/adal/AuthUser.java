package bluemoose.adal;

/**
 * The result of a login or authentication check.
 */
public interface AuthUser {
	/**
	 * @return The first name of the user
	 */
	public String getFname();
	/**
	 * @return The last name of the user
	 */
	public String getLname();
	/**
	 * @return The persistent authentication token.
	 */
	public String getAuthToken();
	
	/**
	 * @return Indicates whether user is logged in or not and why.
	 * Other getters only valid if success() is SUCCESS
	 */
	public LoginResult success();
}
