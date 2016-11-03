package bluemoose.libdal;

public enum ParameterType {
	RUN_NAME("Run Name"),
	AUDIT_ID("Audit ID"),
	SCHEDULED_START("Scheduled Start date/time"),
	STATUS("status"),
	VALUATION_END_DATE("Validation end date"),
	VALUATION_START_DATE("Validation start date"),
	SLA_DATE("SLA date"),
	SLA_TIME("SLA time"),
	DESCRIPTION("Description?")
	//TODO the rest
	;
	public String getName() {
		return name;
	}
	final String name;
	ParameterType(String name){
		this.name = name;
	}
}
