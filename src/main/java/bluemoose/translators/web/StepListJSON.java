package bluemoose.translators.web;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import bluemoose.libdal.DriverStep;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StepListJSON {
	
	public StepListJSON(List<DriverStep> steps) {
		this.steps = steps.stream().map((step) -> new StepJSON(step)).collect(Collectors.toList());
	}

	@JsonProperty
	public String status = "SUCCESS";

	@JsonProperty
	public List<StepJSON> steps;
}
