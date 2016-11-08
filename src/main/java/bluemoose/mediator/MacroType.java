package bluemoose.mediator;

import java.util.List;

public class MacroType {
	public MacroType(String macroID, String macroName, String macroDescription, List<String> parameterIDs,
			List<String> parameterNames) {
		this.macroID = macroID;
		this.macroName = macroName;
		this.macroDescription = macroDescription;
		this.parameterIDs = parameterIDs;
		this.parameterNames = parameterNames;
	}
	public String getMacroID() {
		return macroID;
	}
	public String getMacroName() {
		return macroName;
	}
	public String getMacroDescription() {
		return macroDescription;
	}
	public List<String> getParameterIDs() {
		return parameterIDs;
	}
	public List<String> getParameterNames() {
		return parameterNames;
	}
	final String macroID;
	final String macroName;
	final String macroDescription;
	final List<String> parameterIDs;
	final List<String> parameterNames;
}
