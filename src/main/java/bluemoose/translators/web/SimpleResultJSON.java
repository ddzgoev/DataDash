package bluemoose.translators.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleResultJSON {
	@JsonProperty
	public String status = "SUCCESS";
	@JsonProperty
	public String message;
	public SimpleResultJSON(String message){
		this.message = message;
	}
}
