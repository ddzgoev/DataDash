package bluemoose.mediator;

import java.util.ArrayList;
import java.util.List;

import bluemoose.idal.FailedMacro;
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

	public StoredMacroListResult(MediatorStatus success, List<FailedMacro> failures, int placeholder) {
		super(success);
		result = new ArrayList<Macro>();
		failures.forEach((macro) -> result.add(macro));
	}
}
