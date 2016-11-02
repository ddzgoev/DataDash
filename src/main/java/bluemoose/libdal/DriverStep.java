package bluemoose.libdal;

public class DriverStep {
	public DriverStep(String driverStepDetailID, String auditID, String driverStepID, String appName, String runName,
			String groupNumber, String runOrderNumber, String runStatusCode, String errorProccessNumber,
			String sessionStartDateTime, String sessionEndDateTime, String runStartDateTime, String runEndDateTime,
			String createDateTime, String lastModifiedDateTime) {
		this.driverStepDetailID = driverStepDetailID;
		this.auditID = auditID;
		this.driverStepID = driverStepID;
		this.appName = appName;
		this.runName = runName;
		this.groupNumber = groupNumber;
		this.runOrderNumber = runOrderNumber;
		this.runStatusCode = runStatusCode;
		this.errorProccessNumber = errorProccessNumber;
		this.sessionStartDateTime = sessionStartDateTime;
		this.sessionEndDateTime = sessionEndDateTime;
		this.runStartDateTime = runStartDateTime;
		this.runEndDateTime = runEndDateTime;
		this.createDateTime = createDateTime;
		this.lastModifiedDateTime = lastModifiedDateTime;
	}
	public String getDriverStepDetailID() {
		return driverStepDetailID;
	}
	public void setDriverStepDetailID(String driverStepDetailID) {
		this.driverStepDetailID = driverStepDetailID;
	}
	public String getAuditID() {
		return auditID;
	}
	public void setAuditID(String auditID) {
		this.auditID = auditID;
	}
	public String getDriverStepID() {
		return driverStepID;
	}
	public void setDriverStepID(String driverStepID) {
		this.driverStepID = driverStepID;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getRunName() {
		return runName;
	}
	public void setRunName(String runName) {
		this.runName = runName;
	}
	public String getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}
	public String getRunOrderNumber() {
		return runOrderNumber;
	}
	public void setRunOrderNumber(String runOrderNumber) {
		this.runOrderNumber = runOrderNumber;
	}
	public String getRunStatusCode() {
		return runStatusCode;
	}
	public void setRunStatusCode(String runStatusCode) {
		this.runStatusCode = runStatusCode;
	}
	public String getErrorProccessNumber() {
		return errorProccessNumber;
	}
	public void setErrorProccessNumber(String errorProccessNumber) {
		this.errorProccessNumber = errorProccessNumber;
	}
	public String getSessionStartDateTime() {
		return sessionStartDateTime;
	}
	public void setSessionStartDateTime(String sessionStartDateTime) {
		this.sessionStartDateTime = sessionStartDateTime;
	}
	public String getSessionEndDateTime() {
		return sessionEndDateTime;
	}
	public void setSessionEndDateTime(String sessionEndDateTime) {
		this.sessionEndDateTime = sessionEndDateTime;
	}
	public String getRunStartDateTime() {
		return runStartDateTime;
	}
	public void setRunStartDateTime(String runStartDateTime) {
		this.runStartDateTime = runStartDateTime;
	}
	public String getRunEndDateTime() {
		return runEndDateTime;
	}
	public void setRunEndDateTime(String runEndDateTime) {
		this.runEndDateTime = runEndDateTime;
	}
	public String getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}
	public void setLastModifiedDateTime(String lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}
	String driverStepDetailID;
	String auditID;
	String driverStepID;
	String appName;
	String runName;
	String groupNumber;
	String runOrderNumber;
	String runStatusCode;
	String errorProccessNumber;
	String sessionStartDateTime;
	String sessionEndDateTime;
	String runStartDateTime;
	String runEndDateTime;
	String createDateTime;
	String lastModifiedDateTime;
}
