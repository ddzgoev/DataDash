package bluemoose.translators.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleRequestJSON {
	@JsonProperty
	public String authentication;
}
