package bluemoose.libdal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import bluemoose.ModuleFactoryImpl;
import bluemoose.Period;
import bluemoose.idal.dddb;

/*
 * Out implementation of the Liberty Data Access Layer
 * Only implements access to the Liberty Mutual metadata SQL database.
 * Future implementations may implement access to the directory structure
 * environment for the purpose of running scripts such as the runname creation
 * script.
 */
public class LibDALImpl implements LibDALInterface {
	
	private Connection conn;

	public LibDALImpl(ModuleFactoryImpl moduleFactoryImpl) {
		// TODO Auto-generated constructor stub
		
		dddb libDB = dddb.StartLibDB();
		dddb.createLibDbTables(libDB);
		dddb.addLibDBrowsDB(libDB);
		
		conn = libDB.getConnection();
	}

	@Override
	public RunMacroResult runMacro(String macroType, List<String> parameters) {
		//convert macroType to enum name (assuming macroType is the human-readable version)
		String macroTypeFixed = macroType.toUpperCase().replace(' ', '_');
		
		List<String> sanitizedParameters = new ArrayList<String>();
		
		//check if parameters are valid
		
		boolean foundMacroType = false;
		MacroType macro = null;
		
		for(MacroType mt : MacroType.values()) {
			if(mt.name().equals(macroTypeFixed)) {
				foundMacroType = true;
				macro = mt;
				
				List<ParameterType> requiredParameters = mt.getParameterList();
				if(parameters.size() != requiredParameters.size()) {
					return new RunMacroResultImpl(MacroResultType.INCORRECT_NUMBER_OF_PARAMETERS, null);
				}
				
				List<ParameterType> invalidParameters = new ArrayList<ParameterType>();
				
				for(int i = 0; i < requiredParameters.size(); i++) {
					ParameterType pt = requiredParameters.get(i);
					ParameterPossibilities pp = pt.getPossibilities();
					
					sanitizedParameters.add(pp.sanitize(parameters.get(i)));
					
					if(!pp.isValid(sanitizedParameters.get(i))) {
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
		switch(macro) {
		case DRIVER_SCHEDULE_DELETE_BY_RUN_NAME:
			return deleteByRunName("C_DRIVER_SCHEDULE", macro, sanitizedParameters);
		case DRIVER_STEP_DELETE_BY_RUN_NAME:
			return deleteByRunName("C_DRIVER_STEP", macro, sanitizedParameters);
		case DRIVER_SCHEDULE_ADD_ROW:
			return insertRow("C_DRIVER_SCHEDULE", macro, sanitizedParameters);
		}

		//return the RunMacroResult based on what happened
		return null;
	}
	
	private RunMacroResult deleteByRunName(String tableName, MacroType mt, List<String> parameters) {
		Statement statement;
		try {
			statement = conn.createStatement();
			
			String updateString = String.format("DELETE FROM %s\nWHERE %s=%s", tableName, mt.getParameterList().get(0), parameters.get(0));
			
			int result = statement.executeUpdate(updateString);
			statement.close();
		} catch (SQLException e) {
			return new RunMacroResultImpl(MacroResultType.FAILURE, null);
		}
		
		return new RunMacroResultImpl(MacroResultType.SUCCESS, null);
	}

	private RunMacroResult insertRow(String tableName, MacroType mt, List<String> parameters) {
		Statement statement;
		try {
			statement = conn.createStatement();
			
			StringBuilder parameterString = new StringBuilder();
			for(int i = 0; i < parameters.size(); i++) {
				parameterString.append(parameters.get(i));
				if(i + 1 < parameters.size()) {
					parameterString.append(", ");
				}
			}
			
			String updateString = String.format("INSERT INTO %s VALUES (%s)", tableName, parameterString.toString());
			
			int result = statement.executeUpdate(updateString);
			statement.close();
		} catch (SQLException e) {
			return new RunMacroResultImpl(MacroResultType.FAILURE, null);
		}
		
		return new RunMacroResultImpl(MacroResultType.SUCCESS, null);
	}
	
	private RunMacroResult updateByRunName(String tableName, MacroType mt, List<String> parameters) {
		Statement statement;
		try {
			statement = conn.createStatement();
			
			StringBuilder updates = new StringBuilder();
			for(int i = 0; i < parameters.size(); i++) {
				parameterString.append(parameters.get(i));
				if(i + 1 < parameters.size()) {
					parameterString.append(", ");
				}
			}
			
			String updateString = String.format("UPDATE %s\nSET %s\nWHERE %s", tableName, updates.toString(), conditions.toString());
			
			int result = statement.executeUpdate(updateString);
			statement.close();
		} catch (SQLException e) {
			return new RunMacroResultImpl(MacroResultType.FAILURE, null);
		}
		
		return new RunMacroResultImpl(MacroResultType.SUCCESS, null);
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
