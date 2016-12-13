package bluemoose.translators.web;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MacroJSON {
	public MacroJSON(String uniqueID, String creatorFname, String creatorLname, String reviewerFname,
			String reviewerLname, boolean wasPeerReviewed, String runDate, String creationDate, String macroType,
			List<String> parameters, List<String> originalParameters) {
		this.uniqueID = uniqueID;
		this.creatorFname = creatorFname;
		this.creatorLname = creatorLname;
		this.reviewerFname = reviewerFname;
		this.reviewerLname = reviewerLname;
		this.wasPeerReviewed = wasPeerReviewed;
		this.runDate = runDate;
		this.creationDate = creationDate;
		this.macroType = macroType;
		Parameters = parameters;
		this.originalParameters = originalParameters;
	}
	@JsonProperty
	public String uniqueID;
	@JsonProperty
	public String creatorFname;
	@JsonProperty
	public String creatorLname;
	@JsonProperty
	public String reviewerFname;
	@JsonProperty
	public String reviewerLname;
	@JsonProperty
	public boolean wasPeerReviewed;
	@JsonProperty
	public String runDate;
	@JsonProperty
	public String creationDate;
	@JsonProperty
	public String macroType;
	@JsonProperty
	public List<String> Parameters;
	@JsonProperty
	public List<String> originalParameters;
}
