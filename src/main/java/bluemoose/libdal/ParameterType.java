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
	RUN_NAME("Run Name", new PP_STRING(30)),
	AUDIT_ID("Audit ID", new PP_STRING(30)),
	SCHEDULED_START("Scheduled Start date/time", new PP_TIME(30)),
	STATUS("status", new PP_STRING(30)),
	VALUATION_END_DATE("Validation end date", new PP_DATE(30)),
	VALUATION_START_DATE("Validation start date", new PP_DATE(30)),
	SLA_DATE("SLA date", new PP_DATE(30)),
	SLA_TIME("SLA time", new PP_TIME(30)),
	DESCRIPTION("Description?", new PP_STRING(30))
	//TODO the rest, and correct lengths once we know the actual values
	;
	/**
	 * Not to be confused with name()
	 * @return The human readable name.
	 */
	public String getName() {
		return readableName;
	}
	
	/**
	 * @return The Parameter Possibilities for this ParameterType
	 */
	public ParameterPossibilities getPossibilities() {
		return possibilities;
	}
	
	final String readableName;
	final ParameterPossibilities possibilities;
	
	ParameterType(String name, ParameterPossibilities possibilities){
		this.readableName = name;
		this.possibilities = possibilities;
	}
}
