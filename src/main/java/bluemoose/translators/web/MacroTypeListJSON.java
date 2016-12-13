package bluemoose.translators.web;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MacroTypeListJSON {
	public MacroTypeListJSON(ArrayList<MacroTypeJSON> macros) {
		this.macros = macros;
	}

	@JsonProperty
	public List<MacroTypeJSON> macros;
}
