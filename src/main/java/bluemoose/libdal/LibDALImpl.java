package bluemoose.libdal;

import java.time.Duration;
import bluemoose.Period;

import java.util.ArrayList;
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
	public RunMacroResult runMacro(String macroType, List<String> parameters) {
		//convert macroType to enum name (assuming macroType is the human-readable version)
		String macroTypeFixed = macroType.toUpperCase().replace(' ', '_');
		
		//check if parameters are valid
		
		boolean foundMacroType = false;
		
		for(MacroType mt : MacroType.values()) {
			if(mt.name().equals(macroTypeFixed)) {
				foundMacroType = true;
				
				List<ParameterType> requiredParameters = mt.getParameterList();
				if(parameters.size() != requiredParameters.size()) {
					return new RunMacroResultImpl(MacroResultType.INCORRECT_NUMBER_OF_PARAMETERS, null);
				}
				
				List<ParameterType> invalidParameters = new ArrayList<ParameterType>();
				
				for(int i = 0; i < requiredParameters.size(); i++) {
					ParameterType pt = requiredParameters.get(i);
					ParameterPossibilities pp = pt.getPossibilities();
					
					if(!pp.isValid(parameters.get(i))) {
						//this parameter is invalid
						invalidParameters.add(pt);
					}
				}
				
				if(!invalidParameters.isEmpty()) {
					//some parameters were invalid
					return new RunMacroResultImpl(MacroResultType.INVALID_PARAMETERS, invalidParameters);
				}
				
				break; //stop looping through macro types
			}
		}
		
		if(!foundMacroType) {
			//macroType is not a valid MacroType
			return new RunMacroResultImpl(MacroResultType.UNSUPPORTED_MACRO_TYPE, null);
		}
		
		//parameters are probably now valid
		//insert sql command to run the macro, based on which one it is

		//return the RunMacroResult based on what happened
		return null;
	}

	
	@Override
	public ParameterPossibilities getAllParameterPossibilities(String parameterType) {
		for(ParameterType pt : ParameterType.values()) {
			if(pt.readableName.equals(parameterType)) {
				return pt.getPossibilities();
			}
		}
		return new PP_UNSUPPORTED_PARAMETER();
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
		List<MacroDescription> macroList = new ArrayList<MacroDescription>();
		
		for(MacroType macro : MacroType.values()) {
			MacroDescription desc = new MacroDescription(macro, macro.getParameterList(), readableMacroName(macro));
		}
		
		return macroList;
	}

	private String readableMacroName(MacroType macro) {
		String s = macro.toString();
		String[] words = s.split("_");
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < words.length; i++) {
			//special cases of acronyms that should stay uppercase
			if(words[i].equals("SLA")) {
				sb.append(words[i]);
			}
			sb.append(words[i].charAt(0));
			sb.append(words[i].substring(1).toLowerCase());
			if(i + 1 < words.length) {
				sb.append(" ");
			}
		}
		
		return sb.toString();
	}
}
