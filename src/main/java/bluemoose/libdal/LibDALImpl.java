package bluemoose.libdal;

import java.time.Duration;
import bluemoose.Period;
import java.util.List;

import bluemoose.ModuleFactoryImpl;

/*
 * Out implementation of the Liberty Data Access Layer
 * Only implements access to the Liberty Mutual metadata SQL database.
 * Future implementations may implement access to the directory structure
 * environment for the purpose of running scripts such as the runname creation
 * script.
 */
public class LibDALImpl implements LibDALInterface {

	public LibDALImpl(ModuleFactoryImpl moduleFactoryImpl) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public RunMacroResult runMacro(String macroType, List<String> paramaters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParameterPossibilities getAllParameterPossibilities(String parameterType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DriverStep> getRunningDriverSteps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DriverStep> getPastDriverSteps(Period timePeriod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Duration getRuntimeAverage(Period timePeriod, String stepID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MacroDescription> getMacros() {
		// TODO Auto-generated method stub
		return null;
	}


}
