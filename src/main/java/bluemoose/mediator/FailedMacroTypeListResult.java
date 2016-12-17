package bluemoose.mediator;

import java.util.List;

public class FailedMacroTypeListResult implements MacroTypeListResultInterface {

	public FailedMacroTypeListResult(MediatorStatus status) {
		this.status = status;
	}

	private MediatorStatus status;
	
	@Override
	public MediatorStatus getStatus() {
		return status;
	}

	@Override
	public List<MacroType> getMacroTypes() {
		return null;
	}

}
