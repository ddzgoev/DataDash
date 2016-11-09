package bluemoose.idal;

import java.util.Date;
import java.util.List;

public interface MacroInterface {

	/**
	 * Returns all the parameters of the macro.
	 *
	 * @return list of parameters for the macro
	 */
	List<String> getParameters();

	/**
	 * Sets the parameters of the macro.
	 *
	 * @param index		index of the parameter within list of parameters
	 * @param parameter	macro parameter
	 */
	void setParameter(int index, String parameter);

	/**
	 * Returns the list of parameters that the macro was originally built with
	 *
	 * @return list of parameters
     */
	List<String> getOriginalParameters();

	/**
	 * Returns the type of the macro
	 *
	 * @return type of the macro
     */
	String getMacroType();

	/**
	 * Sets the type of the macro
	 *
	 * @param macroType type of the macro
     */
	void setMacroType(String macroType);

	/**
	 * Return the first name of the macro creator
	 *
	 * @return first name of macro creator
     */
	String getCreatorFname();

	/**
	 * Set the first name of the macro creator
	 *
	 * @param creatorFname first name of macro creator
     */
	void setCreatorFname(String creatorFname);

	/**
	 * Return the last name of the macro creator
	 *
	 * @return last name of macro creator
     */
	String getCreatorLname();

	/**
	 * Set the last name of the macro creator
	 *
	 * @param creatorLname last name of macro creator
     */
	void setCreatorLname(String creatorLname);

	/**
	 * Return first name of macro reviewer
	 *
	 * @return first name of macro reviewer
     */
	String getReviewerFname();

	/**
	 * Set the first name of macro reviewer
	 *
	 * @param reviewerFname first name of macro reviewer
     */
	void setReviewerFname(String reviewerFname);

	/**
	 * Return the last name of macro reviewer
	 *
	 * @return last name of macro reviewer
     */
	String getReviewerLname();

	/**
	 * Set the last name of macro reviewer
	 *
	 * @param reviewerLname last name of macro reviewer
     */
	void setReviewerLname(String reviewerLname);

	/**
	 * Returns boolean value as to whether or not the macro was peer reviewed
	 *
	 * @return whether or not macro was peer reviewed
     */
	boolean getWasPeerReviewed();

	/**
	 * Set the macro to whether or not it was peer reviewed
	 *
	 * @param wasPeerReviewed whether or not macro was peer reviewed
     */
	void setWasPeerReviewed(boolean wasPeerReviewed);

	/**
	 * Return the data that the macro was run
	 *
	 * @return macro run date
     */
	Date getRunDate();

	/**
	 * Set the date that the macro was run
	 *
	 * @param runDate macro run date
     */
	void setRunDate(Date runDate);

	/**
	 * Set the macro run date to the current date
	 *
	 */
	void setRunDateNow();

	/**
	 * Return the date that the macro was created
	 *
	 * @return macro creation date
     */
	Date getCreationDate();

	/**
	 * Set the date that the macro was created
	 *
	 * @param creationDate macro creation date
     */
	void setCreationDate(Date creationDate);

	/**
	 * Set the macro creation date to the current date
	 *
	 */
	void setCreationDateNow();

	/**
	 * Return the macro ID number
	 *
	 * @return macro ID number
     */
	String getUniqueID();

	/**
	 * Set the macro ID number
	 * @param uniqueID macro ID number
     */
	void setUniqueID(String uniqueID);

	/**
	 * Return whether or not the macro failed
	 *
	 */
	boolean getFailed();

	/**
	 * Return the reason for macro failure
	 *
	 * @return macro failure message
     */
	String getFailureReason();

}