package bluemoose.translators.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import bluemoose.mediator.MediatorStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleFailJSON {
	@JsonProperty
	public String status;
	@JsonProperty
	public String reason;
	public SimpleFailJSON(MediatorStatus mediatorStatus, String reason){
		this.status = mediatorStatus.name();
		this.reason = reason;
	}
	
	private SimpleFailJSON(String status, String reason){
		this.status = status;
		this.reason = reason;
	}
	
	@JsonIgnore
	public static SimpleFailJSON translationFailure = new SimpleFailJSON("TRANLATION_FAILURE", "Unable to parse request");
}