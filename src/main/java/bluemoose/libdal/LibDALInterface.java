package bluemoose.libdal;

import java.time.Duration;
import java.time.Period;
import java.util.List;

/*
 * A Liberty Data Access Layer is responsible for providing services to the mediator
 * related to accessing the Liberty Mutual environment.
 */
public interface LibDALInterface {
	/*
	 * Submits a macro to be executed.
	 * Returns a result including a list of invalid parameters if the macro should
	 * not be executed.
	 */
	public RunMacroResult runMacro(String macroType, List<String> paramaters);
	
	/*
	 * Returns an object representing information on what a parameter is legal to be.
	 */
	public ParameterPossibilities getAllParameterPossibilities(String parameterType);
	
	/*
	 * Returns a list of all running driver steps from the C_DRIVER_STEP_DETAIL table.
	 */
	public List<DriverStep> getRunningDriverSteps();
	
	/*
	 * Returns a list of driver steps that ran in a time period
	 * TODO do we actually need this?
	 */
	public List<DriverStep> getPastDriverSteps(Period timePeriod);
	
	/*
	 * Returns historical runtime average by step id from the (TODO ?)C_DRIVER_STEP_DETAIL_H table.
	 * TODO make this make sense
	 */
	public Duration getRuntimeAverage(Period timePeriod, String stepID);
	
	//TODO if we decide to do SLAs we need interface functions for them.
}
