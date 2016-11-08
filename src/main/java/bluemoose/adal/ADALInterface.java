package bluemoose.adal;

/**
 * An Authentication Data Access layer is responsible for providing the mediator
 * with functions that allow a user to login to the system, produce authentication
 * tokens, and validate authentication tokens.
 */
public interface ADALInterface {
	/**
	 * @param username The username of the user trying to login.
	 * @param password The password of the user trying to login.
	 * @return structure indicating success of login and results.
	 */
	public AuthUser login(String username, String password);
	/**
	 * Checks that a token is valid,
	 * ensures token has not expired,
	 * and returns info about the logged in user
	 * 
	 * @param authToken A string previously produced by the ADAL for persistent authentication.
	 * @return structure indicating success of login and results.
	 */
	public AuthUser checkToken(String authToken);
}
