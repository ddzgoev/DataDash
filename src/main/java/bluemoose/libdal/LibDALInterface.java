package bluemoose.libdal;

import java.time.Duration;
import bluemoose.Period;
import java.util.List;

/**
 * A Liberty Data Access Layer is responsible for providing services to the mediator
 * related to accessing the Liberty Mutual data.
 */
public interface LibDALInterface {
	
	/**
	 * @return a list of all macros the LibDAL implementation supports.
	 */
	List<MacroDescription> getMacros();
	
	/**
	 * Submits a macro to be executed.
	 * @return A result including a list of invalid parameters if the macro should
	 * not be executed.
	 * @param macroType The unique unchanging ID of the type of macro.
	 * @param parameters The list of parameters used to run the macro.
	 */
	public RunMacroResult runMacro(String macroType, List<String> parameters);
	
	/**
	 * @return An object representing information on what a parameter is legal to be.
	 * @param parameterType The unique unchanging ID of the type of parameter.
	 */
	public ParameterPossibilities getAllParameterPossibilities(String parameterType);
	
	/**
	 * @return A list of all running driver steps from the C_DRIVER_STEP_DETAIL table.
	 */
	public List<DriverStep> getRunningDriverSteps();
	
	/**
	 * @return A list of driver steps that ran in a time period
	 * @param timePeriod The time period to collect past driver steps from.
	 */
	public List<DriverStep> getPastDriverSteps(Period timePeriod);
	
	/**
	 * @return Historical runtime average by step id from the C_DRIVER_STEP_DETAIL_H table.
	 * TODO Is that the correct table?
	 * @param timePeriod The time period to take the average over.
	 * @param stepID The ID of the step to take the average of.
	 */
	public Duration getRuntimeAverage(Period timePeriod, String stepID);
}
