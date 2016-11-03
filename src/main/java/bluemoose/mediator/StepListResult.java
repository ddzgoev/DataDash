package bluemoose.mediator;

import java.util.List;

import bluemoose.libdal.DriverStep;

public class StepListResult extends MediatorResult {
	final List<DriverStep> steps;

	public List<DriverStep> getSteps() {
		return steps;
	}

	public StepListResult(MediatorStatus status, List<DriverStep> steps) {
		super(status);
		this.steps = steps;
	}
}
