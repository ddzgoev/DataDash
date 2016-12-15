package bluemoose.mediator;

import java.util.List;

import bluemoose.idal.Macro;

public class FailedStoredMacroListResult implements StoredMacroListResultInterface {

	public FailedStoredMacroListResult(MediatorStatus status) {
		this.status = status;
	}

	public MediatorStatus status;
	@Override
	public MediatorStatus getStatus() {
		return status;
	}

	@Override
	public List<Macro> getResult() {
		return null;
	}

}
