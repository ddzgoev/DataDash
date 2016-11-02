package bluemoose.adal;

public enum LoginResult {
	/*
	 * Indicates user is logged in.
	 */
	SUCCESS,
	/*
	 * Indicates authentication token is valid but expired.
	 */
	EXPIRED,
	/*
	 * Indicates user is not logged in.
	 */
	FAILURE
}
