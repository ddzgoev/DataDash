package bluemoose.translators.web;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MacroListJSON {
	public MacroListJSON(ArrayList<MacroJSON> macros) {
		this.macros = macros;
	}
	
	@JsonProperty
	public String status = "SUCCESS";

	@JsonProperty
	public List<MacroJSON> macros;
}
