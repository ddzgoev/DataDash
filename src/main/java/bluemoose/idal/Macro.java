package bluemoose.idal;

import java.util.Date;
import java.util.List;

/*
 * Class for a macro, an internal representation of all it means to be a macro,
 * from the point of view of modules that don't have to execute them.
 */
public class Macro implements MacroInterface {
	public Macro(String uniqueID, String creatorFname, String creatorLname, String reviewerFname, String reviewerLname,
			boolean wasPeerReviewed, Date runDate, Date creationDate, String macroType, List<String> parameters,
			List<String> originalParameters) {
		this.uniqueID = uniqueID;
		this.creatorFname = creatorFname;
		this.creatorLname = creatorLname;
		this.reviewerFname = reviewerFname;
		this.reviewerLname = reviewerLname;
		this.wasPeerReviewed = wasPeerReviewed;
		this.runDate = runDate;
		this.creationDate = creationDate;
		this.macroType = macroType;
		this.parameters = parameters;
		this.originalParameters = originalParameters;
	}

	String uniqueID = null;
	String creatorFname = null;
	String creatorLname = null;
	String reviewerFname = null;
	String reviewerLname = null;
	boolean wasPeerReviewed = false;
	Date runDate = null;
	Date creationDate = null;
	String macroType = null;
	List<String> parameters = null;
	/*
	 * null except for peer reviewed macros.
	 */
	List<String> originalParameters = null;
	
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#getParameters()
	 */
	@Override
	public List<String> getParameters() {
		return parameters;
	}
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#setParameter(int, java.lang.String)
	 */
	@Override
	public void setParameter(int index, String parameter) {
		parameters.set(index, parameter);
	}
	
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#getOriginalParameters()
	 */
	@Override
	public List<String> getOriginalParameters() {
		return originalParameters;
	}
	
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#getMacroType()
	 */
	@Override
	public String getMacroType() {
		return macroType;
	}
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#setMacroType(java.lang.String)
	 */
	@Override
	public void setMacroType(String macroType) {
		this.macroType = macroType;
	}
	
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#getCreatorFname()
	 */
	@Override
	public String getCreatorFname() {
		return creatorFname;
	}
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#setCreatorFname(java.lang.String)
	 */
	@Override
	public void setCreatorFname(String creatorFname) {
		this.creatorFname = creatorFname;
	}
	
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#getCreatorLname()
	 */
	@Override
	public String getCreatorLname() {
		return creatorLname;
	}
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#setCreatorLname(java.lang.String)
	 */
	@Override
	public void setCreatorLname(String creatorLname) {
		this.creatorLname = creatorLname;
	}
	
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#getReviewerFname()
	 */
	@Override
	public String getReviewerFname() {
		return reviewerFname;
	}
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#setReviewerFname(java.lang.String)
	 */
	@Override
	public void setReviewerFname(String reviewerFname) {
		this.reviewerFname = reviewerFname;
	}
	
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#getReviewerLname()
	 */
	@Override
	public String getReviewerLname() {
		return reviewerLname;
	}
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#setReviewerLname(java.lang.String)
	 */
	@Override
	public void setReviewerLname(String reviewerLname) {
		this.reviewerLname = reviewerLname;
	}
	
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#getWasPeerReviewed()
	 */
	@Override
	public boolean getWasPeerReviewed() {
		return wasPeerReviewed;
	}
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#setWasPeerReviewed(boolean)
	 */
	@Override
	public void setWasPeerReviewed(boolean wasPeerReviewed) {
		this.wasPeerReviewed = wasPeerReviewed;
	}
	
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#getRunDate()
	 */
	@Override
	public Date getRunDate() {
		return runDate;
	}
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#setRunDate(java.util.Date)
	 */
	@Override
	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#setRunDateNow()
	 */
	@Override
	public void setRunDateNow() {
		this.runDate = new Date();
	}
	
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#getCreationDate()
	 */
	@Override
	public Date getCreationDate() {
		return creationDate;
	}
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#setCreationDate(java.util.Date)
	 */
	@Override
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#setCreationDateNow()
	 */
	@Override
	public void setCreationDateNow() {
		this.creationDate = new Date();
	}
	
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#getUniqueID()
	 */
	@Override
	public String getUniqueID() {
		return uniqueID;
	}
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#setUniqueID(java.lang.String)
	 */
	@Override
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#getFailed()
	 */
	@Override
	public boolean getFailed(){
		return false;
	}
	
	/* (non-Javadoc)
	 * @see bluemoose.idal.MacroInterface#getFailureReason()
	 */
	@Override
	public String getFailureReason(){
		return null;
	}
}
