package bluemoose.idal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bluemoose.ModuleFactoryInterface;
import bluemoose.Period;

/*
 * An Internal Data Access Layer using an SQL database.
 */
public class IDALImpl implements IDALInterface {

	ModuleFactoryInterface factory;

	dddb database;

	public IDALImpl(ModuleFactoryInterface factory) {
		this.factory = factory;
		database = dddb.StartIdalDB();
		dddb.createIdalDBTables(database);
	}
	
	private long validateID(String ID){
		try{
			return Long.parseLong(ID);
		} catch(NumberFormatException e){
			return -1;
		}
	}

	private String validate(String name) {
		if( name.chars().allMatch(c -> c < 128)){
			return "'" + name.replace("\"", "''").replace("'","''") + "'";
		} else return null;
	}
	
	private String validate(Object object){
		return validate(object.toString());
	}

	private Macro readMacro(ResultSet macros) throws SQLException {
		return new Macro("" + macros.getInt(1), macros.getString(2), macros.getString(3), macros.getString(4),
				macros.getString(5), macros.getBoolean(6), new Date(macros.getInt(7)), new Date(macros.getInt(8)),
				macros.getString(9), new ArrayList<>(), new ArrayList<>());
	}

	private void addParameters(Macro macro, ResultSet parameters) throws SQLException {
		for (; parameters.next();) {
			macro.getParameters().add(parameters.getString("parameters"));
		}
	}

	private void addOriginalParameters(Macro macro, ResultSet parameters) throws SQLException {
		for (; parameters.next();) {
			macro.getOriginalParameters().add(parameters.getString("parameters"));
		}
	}

	private List<Macro> readMacros(ResultSet macros) throws SQLException {
		List<Macro> returnvalue = new ArrayList<Macro>();
		for (; macros.next();) {
			Macro newMacro = readMacro(macros);
			ResultSet parameters = database.queryrs("SELECT index,parameters FROM parameters WHERE uniqueid = "
					+ macros.getInt(1) + "; ORDER BY index");
			addParameters(newMacro, parameters);
			ResultSet originalParameters = database
					.queryrs("SELECT index,parameters FROM originalParameters WHERE uniqueid = " + macros.getInt(1)
							+ "; ORDER BY index");
			addOriginalParameters(newMacro, originalParameters);
			returnvalue.add(newMacro);
		}
		return returnvalue;
	}

	@Override
	public List<Macro> getAllPendingMacros() {
		try {
			ResultSet macros = database.queryrs("SELECT * FROM Macros WHERE m.wasRun = 0;");
			return readMacros(macros);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}
	}

	@Override
	public MacroInterface getPendingMacro(String ID) {
		long lID = validateID(ID);
		if(ID!=null){
			try {
				ResultSet macro = database.queryrs("SELECT * FROM Macros WHERE uniqueid = " + lID);
				return readMacro(macro);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
			else return null;
	}

	@Override
	public MacroInterface storeMacro(String creatorFname, String creatorLname, String macroType,
			List<String> parameters) {
		long now = (int) new Date().getTime();
		try {
			database.queryrs("INSERT INTO Macros( creatorFname, creatorLname, macroType, creationDate) VALUES ("
					+ validate(creatorFname) + "," + validate(creatorLname) + "," + validate(macroType) + "," + now + ");");
			ResultSet r = database.queryrs("SELECT * FROM Macros WHERE creationDate = " + now + ";");
			int macroID = r.getInt(1);
			for (int i = 0; i < parameters.size(); i++) {
				database.queryrs("INSERT into paramters(uniqueId, index, parameters) VALUES (" + macroID + ", " + i
						+ "," + validate(parameters.get(i)) + ");");
			}

			return readMacro(r);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public MacroInterface reviewMacro(String ID, String reviewerLname, String reviewerFname, List<String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MacroInterface markRan(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Macro> getJournal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Macro> viewJournal(Period period) {
		// TODO Auto-generated method stub
		return null;
	}

	// from here down
	@Override
	public void markFailed(String ID, String cause) {
		// TODO Auto-generated method stub

	}

	@Override
	public FailedMacro getLatestFailure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Macro> getFailures() {
		// TODO Auto-generated method stub
		return null;
	}

}
