package bluemoose.mediator;

import java.util.List;

import bluemoose.libdal.PossibilityType;

public class ParameterExplanationResult extends MediatorResult implements ParameterExplanationResultInterface {
	final List<PossibilityType> parameters;

	/* (non-Javadoc)
	 * @see bluemoose.mediator.ParameterExplanationResultInterface#getParameters()
	 */
	@Override
	public List<PossibilityType> getParameters() {
		return parameters;
	}

	public ParameterExplanationResult(MediatorStatus status, List<PossibilityType> parameters) {
		super(status);
		this.parameters = parameters;
	}
}
