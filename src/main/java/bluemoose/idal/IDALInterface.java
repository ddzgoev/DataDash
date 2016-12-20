package bluemoose.idal;

import bluemoose.Period;

import java.sql.SQLException;
import java.util.List;

/*
 * An Internal Data Access Layer is responsible for providing access to 
 * any persistent data the mediator needs:
 * Primarily peer reviews and the journal.
 * The IDAL is not responsible for verifying that any macros it stores for peer review,
 * or returns from peer review, are valid or  have valid parameters.
 */
public interface IDALInterface {
	
	/**
	 * Returns all macros pending for peer review.
	 *
	 * @return List of macros pending to peer reviewed
	 */
	public List<Macro> getAllPendingMacros();
	
	/**
	 * Returns a macro pending for peer review.
	 *
	 * @param ID macro identification number
	 * @return the specified macro
	 */
	public MacroInterface getPendingMacro(String ID);
	
	/**
	 * Persist macro, return formatted data, including generated macro unique id.
	 *
	 * @param creatorFname first name of macro creator
	 * @param creatorLname last name of macro creator
	 * @param macroType type of the macro
	 * @param parameters list of parameters passed to macro
	 * @return the built macro
	 */
	public MacroInterface storeMacro(String creatorFname, String creatorLname, String macroType, List<String> parameters);
	
	/**
	 * Persist a peer review of a macro, return formatted data.
	 *
	 * @param ID macro identification number
	 * @param reviewerLname last name of macro reviewer
	 * @param reviewerFname first name of macro reviewer
	 * @param parameters list of parameters passed to macro
	 * @return the updated macro
	 */
	public MacroInterface reviewMacro(String ID, String reviewerLname, String reviewerFname, List<String> parameters);
	
	/**
	 * Moves a pending macro or peer reviewed macro to past macros.
	 *
	 * @param ID macro identification number
	 * @return the updated macro
	 */
	public MacroInterface markRan(String ID);
	
	/**
	 * returns all past macros.
	 *
	 * @return list of previously run Macros
	 */
	public List<Macro> getJournal();
	
	/**
	 * Returns past macro by time period
	 *
	 * @param period range of time period
	 * @return list of previously run macros within period
	 */
	public List<Macro> viewJournal(Period period);
	
	/**
	 * Marks a past macro as failed, with the given reason.
	 * TODO: requires group discussion of system architecture
	 *
	 * @param ID macro identification number
	 * @param cause specified reason for macro failing
	 */
	public void markFailed(String ID, String cause);
	
	/**
	 * returns the latest failed macro
	 * TODO requires group discussion of system architecture
	 *
	 * @return a failed macro
	 */
	public FailedMacro getLatestFailure();
	
	/**
	 * Returns a list of failed macros.
	 * TODO: requires group discussion of system architecture
	 *
	 * @return list of failed macros
	 */
	public List<Macro> getFailures();
}
