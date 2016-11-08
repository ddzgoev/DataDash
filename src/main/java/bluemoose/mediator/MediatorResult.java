package bluemoose.mediator;

/*
 * Base class for all results from the mediator.
 */
public class MediatorResult implements MediatorResultInterface {
	public MediatorResult(MediatorStatus status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see bluemoose.mediator.MediatorResultInterface#getStatus()
	 */
	@Override
	public MediatorStatus getStatus() {
		return status;
	}

	final MediatorStatus status;
	
}
