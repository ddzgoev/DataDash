package bluemoose.mediator;

/*
 * Base class for all results from the mediator.
 */
public class MediatorResult {
	public MediatorResult(MediatorStatus status) {
		this.status = status;
	}

	public MediatorStatus getStatus() {
		return status;
	}

	final MediatorStatus status;
	
}
