package bluemoose.mediator;

import java.util.List;

import bluemoose.libdal.PossibilityType;

public class ParameterExplanationResult extends MediatorResult {
	final List<PossibilityType> parameters;

	public List<PossibilityType> getParameters() {
		return parameters;
	}

	public ParameterExplanationResult(MediatorStatus status, List<PossibilityType> parameters) {
		super(status);
		this.parameters = parameters;
	}
}
