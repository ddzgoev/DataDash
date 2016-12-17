package bluemoose.mediator;

import java.util.List;

import bluemoose.libdal.ParameterPossibilities;

public class ParameterExplanationResult extends MediatorResult implements ParameterExplanationResultInterface {
	final List<ParameterPossibilities> parameters;

	/* (non-Javadoc)
	 * @see bluemoose.mediator.ParameterExplanationResultInterface#getParameters()
	 */
	@Override
	public List<ParameterPossibilities> getParameters() {
		return parameters;
	}

	public ParameterExplanationResult(MediatorStatus status, List<ParameterPossibilities> parameters) {
		super(status);
		this.parameters = parameters;
	}
}
