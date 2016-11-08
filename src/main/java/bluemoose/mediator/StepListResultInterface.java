package bluemoose.mediator;

import java.util.List;

import bluemoose.libdal.DriverStep;

/**
 * Response from the mediator containing a list of driver steps.
 * @author Ethan
 *
 */
public interface StepListResultInterface extends MediatorResultInterface{
	/**
	 * 
	 * @return List of driver steps.
	 */
	List<DriverStep> getSteps();

}