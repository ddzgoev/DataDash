package bluemoose.translators.web;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MacroTypeListJSON {
	public MacroTypeListJSON(List<MacroType> macros) {
		this.macros = macros;
	}

	@JsonProperty
	public List<MacroType> macros;
}
