package bluemoose.translators.web;

import java.time.Duration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeResultJSON {
	@JsonProperty
	public String time;
	
	@JsonProperty
	public String status = "SUCCESS";
	
	public TimeResultJSON(Duration duration){
		time = Long.toString(duration.toMillis());
	}
}
