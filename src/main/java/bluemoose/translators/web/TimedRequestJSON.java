package bluemoose.translators.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimedRequestJSON {
	@JsonProperty
	public String startDate;
	@JsonProperty
	public String endDate;
	@JsonProperty
	public String authentication;
}
