package bluemoose.idal;

import java.time.Period;
import java.util.List;

/*
 * An Internal Data Access Layer is responsible for providing access to 
 * any persistent data the mediator needs:
 * Primarily peer reviews and the journal.
 * The IDAL is not responsible for verifying that any macros it stores for peer review,
 * or returns from peer review, are valid or  have valid parameters.
 */
public interface IDALInterface {
	
	/*
	 * Returns all macros pending for peer review.
	 */
	public List<Macro> getAllPendingMacros();
	
	/*
	 * Returns a macro pending for peer review.
	 */
	public MacroInterface getPendingMacro(String ID);
	
	/*
	 * Persist macro, return formatted data, including generated macro unique id.
	 */
	public MacroInterface storeMacro(String creatorFname, String creatorLname, String macroType, List<String> parameters);
	
	/*
	 * Persist a peer review of a macro, return formatted data.
	 */
	public MacroInterface reviewMacro(String ID, String reviewerLname, String reviewerFname, List<String> parameters);
	
	/*
	 * Moves a pending macro or peer reviewed macro to past macros.
	 */
	public MacroInterface markRan(String ID);
	
	/*
	 * returns all past macros.
	 */
	public List<Macro> getJournal();
	
	/*
	 * Returns past macro by time period
	 */
	public List<Macro> viewJournal(Period period);
	
	/*
	 * Marks a past macro as failed, with the given reason.
	 * TODO: requires group discussion of system architecture
	 */
	public void markFailed(String ID, String cause);
	
	/*
	 * returns the latest failed macro
	 * TODO requires group discussion of system architecture
	 */
	public FailedMacro getLatestFailure();
	
	/*
	 * Returns a list of failed macros.
	 * TODO: requires group discussion of system architecture
	 */
	public List<Macro> getFailures();
}
