package bluemoose.mediator;

import java.util.List;

import bluemoose.idal.Macro;

public class StoredMacroListResult extends MediatorResult {
	final List<Macro> result;

	public List<Macro> getResult() {
		return result;
	}

	public StoredMacroListResult(MediatorStatus status, List<Macro> result) {
		super(status);
		this.result = result;
	}
}
