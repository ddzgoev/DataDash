package bluemoose.libdal;

/**
 * enum for a type of parameter.
 * ALthough Strings are always taken as input, some interface methods
 * return ParameterType's for convenience.
 * The canonical string ID is obtained with the name() method inherited
 * from enum, not to be confuse with getName()
 * @author Ethan
 *
 */
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
	/**
	 * Not to be confused with name()
	 * @return The human readable name.
	 */
	public String getName() {
		return readableName;
	}
	final String readableName;
	ParameterType(String name){
		this.readableName = name;
	}
}
