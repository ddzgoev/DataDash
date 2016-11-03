package bluemoose.idal;

import java.time.Period;
import java.util.List;

import bluemoose.ModuleFactoryImpl;

/*
 * An Internal Data Access Layer using an SQL database.
 */
public class IDALImpl implements IDALInterface {

	public IDALImpl(ModuleFactoryImpl moduleFactoryImpl) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Macro> getAllPendingMacros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MacroInterface getPendingMacro(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MacroInterface storeMacro(String creatorFname, String creatorLname, String macroType, List<String> parameters) {
		// TODO Auto-generated method stub
		return null;
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
