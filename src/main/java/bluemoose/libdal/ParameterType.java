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
	Audit_ID("Audit ID", new PP_STRING(30)),
	App_Name("App Name", new PP_STRING(30)),
	Run_Name("Run Name", new PP_STRING(30)),
	Run_Number("Run Number", new PP_STRING(30)),
	Re_Run_Number("Re Run Number", new PP_STRING(30)),
	Scheduled_Start_Date_Time("Scheduled Start Date Time", new PP_STRING(30)),
	Status_Code("Status Code", new PP_STRING(30)),
	Valuation_Start_Date_Time("Valuation Start Date Time", new PP_STRING(30)),
	Valuation_End_Date_Time("Valuation End Date Time", new PP_STRING(30)),
	Run_Start_Date_Time("Run Start Date Time", new PP_STRING(30)),
	Run_End_Date_Time("Run End Date Time", new PP_STRING(30)),
	Create_Date_Time("Create Date Time", new PP_STRING(30)),
	Last_Modified_Date_Time("Last Modified Date Time", new PP_STRING(30)),
	APP_Run_ID("APP Run ID", new PP_STRING(30)),
	SLA_DATE("SLA DATE", new PP_STRING(30)),
	SLA_TIME("SLA TIME", new PP_STRING(30)),
	Driver_Step_ID("Driver Step ID", new PP_STRING(60)),
	APP_Name("APP Name", new PP_STRING(30)),
	Group_Number("Group Number", new PP_STRING(30)),
	Group_Name("Group Name", new PP_STRING(30)),
	Run_Order_Number("Run Order Number", new PP_STRING(30)),
	Path_Text("Path Text", new PP_STRING(30)),
	Command_Text("Command Text", new PP_STRING(30)),
	Parameter_Text("Parameter_Text", new PP_STRING(60)),
	Group_Concurrency_Indicator("Group_Concurrency_Indicator", new PP_STRING(30)),
	Step_Concurrency_Indicator("Step_Concurrency_Indicator", new PP_STRING(30)),
	Notify_Text("Notify_Text", new PP_STRING(30)),
	Step_Type_Code("Step_Type_Code", new PP_STRING(30)),
	Step_Name("Step_Name", new PP_STRING(30)),
	Error_Process_Number("Error_Process_Number", new PP_STRING(30)),
	Active_Step_Indicator("Active_Step_Indicator", new PP_STRING(30))
	//AUDIT_ID("Audit ID", new PP_STRING(30)),
	//SCHEDULED_START("Scheduled Start date/time", new PP_TIME(30)),
	//STATUS("status", new PP_STRING(30)),
	//VALUATION_END_DATE("Validation end date", new PP_DATE(30)),
	//VALUATION_START_DATE("Validation start date", new PP_DATE(30)),
	//SLA_DATE("SLA date", new PP_DATE(30)),
	//SLA_TIME("SLA time", new PP_TIME(30)),
	//DESCRIPTION("Description?", new PP_STRING(30))
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
