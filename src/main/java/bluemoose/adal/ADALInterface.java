package bluemoose.adal;

/*
 * An Authentication Data Access layer is responsible for providing the mediator
 * with functions that allow a user to login to the system, produce authentication
 * tokens, and validate authentication tokens.
 */
public interface ADALInterface {
	public AuthUser login(String username, String password);
	/*
	 * Checks that a token is valid,
	 * ensures token has not expired, if expiration is a thing,
	 * and returns info about the logged in user
	 */
	public AuthUser checkToken(String authToken);
}
