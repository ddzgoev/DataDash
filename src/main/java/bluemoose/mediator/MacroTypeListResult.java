package bluemoose.mediator;

import java.util.List;

public class MacroTypeListResult extends MediatorResult {
	String macroID;
	String macroName;
	String macroDescription;
	List<String> parameterIDs;
	List<String> parameterNames;
	public MacroTypeListResult(MediatorStatus status, String macroID, String macroName, String macroDescription,
			List<String> parameterIDs, List<String> parameterNames) {
		super(status);
		this.macroID = macroID;
		this.macroName = macroName;
		this.macroDescription = macroDescription;
		this.parameterIDs = parameterIDs;
		this.parameterNames = parameterNames;
	}
}
