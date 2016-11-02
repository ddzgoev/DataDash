package bluemoose.idal;

import java.util.Date;
import java.util.List;

/*
 * Class for a macro, an internal representation of all it means to be a macro,
 * from the point of view of modules that don't have to execute them.
 */
public class Macro {
	public Macro(String uniqueID, String creatorFname, String creatorLname, String reviewerFname, String reviewerLname,
			boolean wasPeerReviewed, Date runDate, Date creationDate, String macroType, List<String> parameters) {
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
	
	public List<String> getParameters() {
		return parameters;
	}
	public void setParameter(int index, String parameter) {
		parameters.set(index, parameter);
	}
	
	public String getMacroType() {
		return macroType;
	}
	public void setMacroType(String macroType) {
		this.macroType = macroType;
	}
	
	public String getCreatorFname() {
		return creatorFname;
	}
	public void setCreatorFname(String creatorFname) {
		this.creatorFname = creatorFname;
	}
	
	public String getCreatorLname() {
		return creatorLname;
	}
	public void setCreatorLname(String creatorLname) {
		this.creatorLname = creatorLname;
	}
	
	public String getReviewerFname() {
		return reviewerFname;
	}
	public void setReviewerFname(String reviewerFname) {
		this.reviewerFname = reviewerFname;
	}
	
	public String getReviewerLname() {
		return reviewerLname;
	}
	public void setReviewerLname(String reviewerLname) {
		this.reviewerLname = reviewerLname;
	}
	
	public boolean getWasPeerReviewed() {
		return wasPeerReviewed;
	}
	public void setWasPeerReviewed(boolean wasPeerReviewed) {
		this.wasPeerReviewed = wasPeerReviewed;
	}
	
	public Date getRunDate() {
		return runDate;
	}
	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}
	public void setRunDateNow() {
		this.runDate = new Date();
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public void setCreationDateNow() {
		this.creationDate = new Date();
	}
	
	public String getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	public Macro(String uniqueID, String creatorFname, String creatorLname, String reviewerFname, String reviewerLname,
			boolean wasPeerReviewed, Date runDate, Date creationDate) {
		this.uniqueID = uniqueID;
		this.creatorFname = creatorFname;
		this.creatorLname = creatorLname;
		this.reviewerFname = reviewerFname;
		this.reviewerLname = reviewerLname;
		this.wasPeerReviewed = wasPeerReviewed;
		this.runDate = runDate;
		this.creationDate = creationDate;
	}
	
	public Macro() {
	}
}
