package bluemoose.translators.web;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MacroTypeJSON {
	public MacroTypeJSON(String macroID, String macroName, String macroDescription, List<String> parameterIDs,
			List<String> parameterNames) {
		this.macroID = macroID;
		this.macroName = macroName;
		this.macroDescription = macroDescription;
		this.parameterIDs = parameterIDs;
		this.parameterNames = parameterNames;
	}

	@JsonProperty
	public String macroID;
	@JsonProperty
	public String macroName;
	@JsonProperty
	public String macroDescription;
	@JsonProperty
	public List<String> parameterIDs;
	@JsonProperty
	public List<String> parameterNames;
}
