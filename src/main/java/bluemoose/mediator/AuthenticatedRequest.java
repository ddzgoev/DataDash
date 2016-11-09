package bluemoose.mediator;

/**
 * Base class for all requests to the mediator that require the user to be logged in.
 */
class AuthenticatedRequest {
	/**
	 * 
	 * @return the authentication string
	 */
	public String getAuthentication() {
		return authentication;
	}
	
	public AuthenticatedRequest(String authentication) {
		this.authentication = authentication;
	}

	private final String authentication;
}
