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

	dddb database;

	public IDALImpl() {
		database = dddb.StartIdalDB();
		dddb.createIdalDBTables(database);
	}
	
	public IDALImpl(ModuleFactoryInterface factory){
		this();
	}
	
	private int validateID(String ID){
		try{
			return Integer.parseInt(ID);
		} catch(NumberFormatException e){
			return -1;
		}
	}

	private String validate(String name) {
		if( name.chars().allMatch(c -> c < 128)){
			return "'" + name.replace("\"", "").replace("'","''") + "'";
		} else return null;
	}
	
	private String validate(Object object){
		return validate(object.toString());
	}

	private Macro readMacro(ResultSet macros) throws SQLException {
		return new Macro("" + macros.getInt(1), macros.getString(2), macros.getString(3), macros.getString(4),
				macros.getString(5), macros.getBoolean(6), new Date(macros.getLong(8)), new Date(macros.getLong(9)),
				macros.getString(10), new ArrayList<>(), new ArrayList<>());
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
	
	private void insertParameters(int ID, List<String> parameters) throws SQLException{
		for (int i = 0; i < parameters.size(); i++) {
			database.queryrs("INSERT into paramters(uniqueId, index, parameters) VALUES (" + ID + ", " + i
					+ "," + validate(parameters.get(i)) + ");");
		}
	}
	
	private long getNow(){
		return  new Date().getTime();
	}

	@Override
	public MacroInterface storeMacro(String creatorFname, String creatorLname, String macroType,
			List<String> parameters) {
		long now = getNow();
		try {
			database.queryrs("INSERT INTO Macros( creatorFname, creatorLname, macroType, creationDate) VALUES ("
					+ validate(creatorFname) + "," + validate(creatorLname) + "," + validate(macroType) + "," + now + ");");
			ResultSet r = database.queryrs("SELECT * FROM Macros WHERE creationDate = " + now + ";");
			int macroID = r.getInt(1);
			insertParameters(macroID,parameters);

			return readMacro(r);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public MacroInterface reviewMacro(String ID, String reviewerLname, String reviewerFname, List<String> parameters) {
		try {
			int id = validateID(ID);
			database.queryrs("UPDATE Macros SET wasPeerReviewed = true, reviewerLname = " + validate(reviewerLname) +", reviewerFname = " + validate(reviewerFname) + " WHERE uniqueid =" +id);
			database.queryrs("INSERT INTO originalParameters(uniqueid,index,parameters) SELECT uniqueid,index,parameters FROM parameters WHERE uniqueID = " + id + ";");
			database.queryrs("DELETE FROM parameters WHERE uniqueid = " + id);
			insertParameters(id,parameters);
			return getPendingMacro(ID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public MacroInterface markRan(String ID) {
		try {
			database.queryrs("UPDATE Macros SET wasRun = true, runDate = "+getNow()+" WHERE uniqueid = " + validateID(ID));
			return getPendingMacro(ID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Macro> getJournal() {
		try {
			ResultSet macros = database.queryrs("SELECT * FROM Macros WHERE wasRun = true;");
			return readMacros(macros);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}
	}

	@Override
	public List<Macro> viewJournal(Period period) {
		try {
			ResultSet macros = database.queryrs("SELECT * FROM Macros WHERE wasRun = true AND runDate< "+ period.getEnd().getTime() +" AND runDate> " + period.getStart().getTime() +";");
			return readMacros(macros);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}
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
