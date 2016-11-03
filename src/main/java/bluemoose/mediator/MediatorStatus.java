package bluemoose.mediator;

public enum MediatorStatus {
	SUCCESS,
	/*
	 * Something went wrong do to a problem with the software.
	 */
	INTERNAL_ERROR,
	/*
	 * The authentication token could not be decoded on an authenticated request.
	 */
	AUTHENTICATION_ERROR,
	/*
	 * The authentication token was expired.
	 */
	AUTHENTICATION_EXPIRATION,
	/*
	 * Something was structurally wrong with the request,
	 * like a macro with the wrong number of parameters or invalid parameters,
	 * or a nonexistant macro type.
	 */
	BAD_REQUEST,
	/*
	 * The request could not be carried out do to an expected and correct error.
	 */
	FAILURE
}
