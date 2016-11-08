package bluemoose.mediator;

//Doesn't need an interface, always the same.
public class SimpleResultWithFailMessage extends MediatorResult {
	public SimpleResultWithFailMessage(MediatorStatus status, String message) {
		super(status);
		this.message = message;
	}

	final String message;

	public String getMessage() {
		return message;
	}
}
