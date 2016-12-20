package bluemoose.translators.web;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RunMacroRequestJSON {
	public RunMacroRequestJSON(String authentication, String macroType, List<String> parameters, boolean skipReview) {
		this.authentication = authentication;
		this.macroType = macroType;
		this.parameters = parameters;
		this.skipReview = skipReview;
	}
	
	public RunMacroRequestJSON(){}

	@JsonProperty
	public String authentication;
	@JsonProperty
	public String macroType;
	@JsonProperty
	public List<String> parameters;
	@JsonProperty
	public boolean skipReview;
}
