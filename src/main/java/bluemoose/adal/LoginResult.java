package bluemoose.adal;

/**
 * Indicates whether a user was succesfully logged in or authenticated
 * @author Ethan
 *
 */
public enum LoginResult {
	/**
	 * Indicates user is logged in.
	 */
	SUCCESS,
	/**
	 * Indicates authentication token is valid but expired.
	 */
	EXPIRED,
	/**
	 * Indicates user is not logged in.
	 */
	FAILURE
}
