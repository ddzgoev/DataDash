package bluemoose.libdal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * represents a type of macro
 */
public enum MacroType {
	DRIVER_SCHEDULE_DELETE_BY_RUN_NAME(ParameterType.RUN_NAME),
	DRIVER_SCHEDULE_UPDATE_SCHEDULED_START_BY_RUN_NAME_AND_AUDIT_ID(ParameterType.RUN_NAME,ParameterType.AUDIT_ID,ParameterType.SCHEDULED_START),
	DRIVER_SCHEDULE_UPDATE_STATUS_BY_RUN_NAME_AND_AUDIT_ID(ParameterType.RUN_NAME,ParameterType.AUDIT_ID,ParameterType.STATUS),
	DRIVER_SCHEDULE_UPDATE_VALUATION_END_DATE_BY_RUN_NAME_AND_AUDIT_ID(ParameterType.RUN_NAME,ParameterType.AUDIT_ID,ParameterType.VALUATION_END_DATE),
	DRIVER_SCHEDULE_UPDATE_VALUATION_START_DATE_BY_RUN_NAME_AND_AUDIT_ID(ParameterType.RUN_NAME,ParameterType.AUDIT_ID,ParameterType.VALUATION_START_DATE),
	DRIVER_SCHEDULE_UPDATE_SLA_DATE_AND_TIME_BY_AUIDIT_ID(ParameterType.SLA_DATE,ParameterType.SLA_TIME,ParameterType.AUDIT_ID,ParameterType.DESCRIPTION),
	DRIVER_SCHEDULE_UPDATE_SLA_TIME_BY_RUN_NAME(ParameterType.SLA_TIME,ParameterType.RUN_NAME),
	DRIVER_SCHEDULE_H_UPDATE_SLA_TIME_BY_RUN_NAME(ParameterType.SLA_TIME,ParameterType.RUN_NAME),
	//TODO, the rest.
	//DRIVER_STEP_DELETE,
	//DRIVER_STEP_DETAIL_DELETE,
	//DRIVER_STEP_DETAIL_UPDATE,
	//DRIVER_STEP_UPDATE
	;
	
	private ArrayList<ParameterType> parameterTypes;
	
	public List<ParameterType> getParameterList(){
		return Collections.unmodifiableList(parameterTypes);
	}
	
	MacroType(ParameterType...parameters){
		parameterTypes = new ArrayList<ParameterType>(Arrays.asList(parameters));
	}
}
