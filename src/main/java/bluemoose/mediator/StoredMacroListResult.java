package bluemoose.mediator;

import java.util.List;

import bluemoose.idal.Macro;

public class StoredMacroListResult extends MediatorResult implements StoredMacroListResultInterface {
	final List<Macro> result;

	/* (non-Javadoc)
	 * @see bluemoose.mediator.StoredMacroListResultInterface#getResult()
	 */
	@Override
	public List<Macro> getResult() {
		return result;
	}

	public StoredMacroListResult(MediatorStatus status, List<Macro> result) {
		super(status);
		this.result = result;
	}
}
