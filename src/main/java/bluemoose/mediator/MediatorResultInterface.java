package bluemoose.mediator;

/**
 * Base interface for all results returned by the mediator.
 * @author Ethan
 *
 */
public interface MediatorResultInterface {
	/**
	 * 
	 * @return The {@link MediatorStatus} of the response
	 */
	MediatorStatus getStatus();

}