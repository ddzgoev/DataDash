package bluemoose.translators.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import bluemoose.libdal.DriverStep;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StepJSON {
	public StepJSON(DriverStep step){
		this.driverStepDetailID = step.getDriverStepDetailID();
		this.auditID = step.getAuditID();
		this.driverStepID = step.getDriverStepID();
		this.appName = step.getAppName();
		this.runName = step.getRunName();
		this.createDateTime = step.getCreateDateTime();
		this.errorProccessNumber = step.getErrorProccessNumber();
		this.groupNumber = step.getGroupNumber();
		this.lastModifiedDateTime = step.getLastModifiedDateTime();
		this.runEndDateTime = step.getRunEndDateTime();
		this.runOrderNumber = step.getRunOrderNumber();
		this.runStartDateTime = step.getRunStartDateTime();
		this.runStatusCode = step.getRunStatusCode();
		this.sessionEndDateTime = step.getSessionEndDateTime();
		this.sessionStartDateTime = step.getSessionStartDateTime();
	}
	
	@JsonProperty
	public final String status = "SUCCESS";
	
	@JsonProperty
	public String driverStepDetailID;
	
	@JsonProperty
	public String auditID;
	
	@JsonProperty
	public String driverStepID;
	
	@JsonProperty
	public String appName;
	
	@JsonProperty
	public String runName;
	
	@JsonProperty
	public String groupNumber;
	
	@JsonProperty
	public String runOrderNumber;
	
	@JsonProperty
	public String runStatusCode;
	
	@JsonProperty
	public String errorProccessNumber;
	
	@JsonProperty
	public String sessionStartDateTime;
	
	@JsonProperty
	public String sessionEndDateTime;
	
	@JsonProperty
	public String runStartDateTime;
	
	@JsonProperty
	public String runEndDateTime;
	
	@JsonProperty
	public String createDateTime;
	
	@JsonProperty
	public String lastModifiedDateTime;

}
