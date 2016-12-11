package bluemoose.translators.web;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewMacroRequestJSON {
	@JsonProperty
	public String authentication;
	@JsonProperty
	public String macroID;
	@JsonProperty
	public List<String> parameters;
}
