package bluemoose.libdal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * enum for a type of parameter. Although Strings are always taken as input,
 * sometimes MacroTypes are given as output for convenience.
 * All MacroType's can be converted to a string with {@link name}
 */
public enum MacroType {
	DRIVER_SCHEDULE_DELETE_BY_RUN_NAME(ParameterType.Run_Name),
	DRIVER_STEP_DELETE_BY_RUN_NAME(ParameterType.Run_Name),
	DRIVER_SCHEDULE_ADD_ROW(ParameterType.Audit_ID, ParameterType.App_Name, ParameterType.Run_Name, ParameterType.Run_Number, ParameterType.Re_Run_Number, ParameterType.Scheduled_Start_Date_Time, ParameterType.Status_Code, ParameterType.Valuation_Start_Date_Time, ParameterType.Valuation_End_Date_Time, ParameterType.Run_Start_Date_Time, ParameterType.Run_End_Date_Time, ParameterType.Create_Date_Time, ParameterType.Last_Modified_Date_Time, ParameterType.APP_Run_ID, ParameterType.SLA_DATE, ParameterType.SLA_TIME),
	DRIVER_STEP_ADD_ROW(ParameterType.Driver_Step_ID, ParameterType.APP_Name, ParameterType.Run_Name, ParameterType.Group_Number, ParameterType.Group_Name, ParameterType.Run_Order_Number, ParameterType.Path_Text, ParameterType.Command_Text, ParameterType.Parameter_Text, ParameterType.Group_Concurrency_Indicator, ParameterType.Step_Concurrency_Indicator, ParameterType.Notify_Text, ParameterType.Step_Type_Code, ParameterType.Step_Name, ParameterType.Error_Process_Number, ParameterType.Create_Date_Time, ParameterType.Last_Modified_Date_Time, ParameterType.APP_Run_ID, ParameterType.Active_Step_Indicator),
	DRIVER_SCHEDULE_UPDATE_STATUS_BY_RUN_NAME_AND_AUDIT_ID(ParameterType.Run_Name,ParameterType.Audit_ID,ParameterType.Status_Code),
	//DRIVER_SCHEDULE_UPDATE_SCHEDULED_START_BY_RUN_NAME_AND_AUDIT_ID(ParameterType.RUN_NAME,ParameterType.AUDIT_ID,ParameterType.SCHEDULED_START),
	//DRIVER_SCHEDULE_UPDATE_VALUATION_END_DATE_BY_RUN_NAME_AND_AUDIT_ID(ParameterType.RUN_NAME,ParameterType.AUDIT_ID,ParameterType.VALUATION_END_DATE),
	//DRIVER_SCHEDULE_UPDATE_VALUATION_START_DATE_BY_RUN_NAME_AND_AUDIT_ID(ParameterType.RUN_NAME,ParameterType.AUDIT_ID,ParameterType.VALUATION_START_DATE),
	//DRIVER_SCHEDULE_UPDATE_SLA_DATE_AND_TIME_BY_AUDIT_ID(ParameterType.SLA_DATE,ParameterType.SLA_TIME,ParameterType.AUDIT_ID,ParameterType.DESCRIPTION),
	//DRIVER_SCHEDULE_UPDATE_SLA_TIME_BY_RUN_NAME(ParameterType.SLA_TIME,ParameterType.RUN_NAME),
	//DRIVER_SCHEDULE_H_UPDATE_SLA_TIME_BY_RUN_NAME(ParameterType.SLA_TIME,ParameterType.RUN_NAME),
	//TODO, the rest.
	//DRIVER_STEP_DELETE,
	//DRIVER_STEP_DETAIL_DELETE,
	//DRIVER_STEP_DETAIL_UPDATE,
	//DRIVER_STEP_UPDATE
	;
	
	private ArrayList<ParameterType> parameterTypes;
	
	/**
	 * @return List of parameter types used for this macro type.
	 */
	public List<ParameterType> getParameterList(){
		return Collections.unmodifiableList(parameterTypes);
	}
	
	MacroType(ParameterType...parameters){
		parameterTypes = new ArrayList<ParameterType>(Arrays.asList(parameters));
	}
}
