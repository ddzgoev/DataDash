package bluemoose.mediator;

import java.util.List;

/**
 * structure desribing a type of macro.
 * @author Ethan
 *
 */
public class MacroType {
	public MacroType(String macroID, String macroName, String macroDescription, List<String> parameterIDs,
			List<String> parameterNames) {
		this.macroID = macroID;
		this.macroName = macroName;
		this.macroDescription = macroDescription;
		this.parameterIDs = parameterIDs;
		this.parameterNames = parameterNames;
	}
	/**
	 * 
	 * @return The unique unchanging ID of the macro type.
	 */
	public String getMacroID() {
		return macroID;
	}
	/**
	 * 
	 * @return The human readable name of the macro type.
	 */
	public String getMacroName() {
		return macroName;
	}
	/**
	 * 
	 * @return The human readable description of the macro type, on a best effort basis.
	 */
	public String getMacroDescription() {
		return macroDescription;
	}
	/**
	 * 
	 * @return List of unique unchanging, ordered, parameter types associated with the macro type.
	 */
	public List<String> getParameterIDs() {
		return parameterIDs;
	}
	/**
	 * 
	 * @return List of human readable names corresponding with {@link getParameterIDs}
	 */
	public List<String> getParameterNames() {
		return parameterNames;
	}
	final String macroID;
	final String macroName;
	final String macroDescription;
	final List<String> parameterIDs;
	final List<String> parameterNames;
}
