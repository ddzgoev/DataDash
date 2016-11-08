package bluemoose.mediator;

/**
 * A response form the mediator indicating success or failure, and why.
 * @author Ethan
 *
 */
public class SimpleResultWithFailMessage extends MediatorResult {
	public SimpleResultWithFailMessage(MediatorStatus status, String message) {
		super(status);
		this.message = message;
	}

	final String message;

	/**
	 * 
	 * @return The success or failure message. Probably only interesting in the case of failure. Can be "" if success.
	 */
	public String getMessage() {
		return message;
	}
}
