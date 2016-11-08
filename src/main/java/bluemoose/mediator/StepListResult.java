package bluemoose.mediator;

import java.util.List;

import bluemoose.libdal.DriverStep;

public class StepListResult extends MediatorResult implements StepListResultInterface {
	final List<DriverStep> steps;

	/* (non-Javadoc)
	 * @see bluemoose.mediator.StepListResultInterface#getSteps()
	 */
	@Override
	public List<DriverStep> getSteps() {
		return steps;
	}

	public StepListResult(MediatorStatus status, List<DriverStep> steps) {
		super(status);
		this.steps = steps;
	}
}
