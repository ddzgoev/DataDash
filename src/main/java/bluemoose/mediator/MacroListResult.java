package bluemoose.mediator;

import java.util.List;

import bluemoose.idal.Macro;

public class MacroListResult extends MediatorResult {
	final List<Macro> result;

	public List<Macro> getResult() {
		return result;
	}

	public MacroListResult(MediatorStatus status, List<Macro> result) {
		super(status);
		this.result = result;
	}
}
