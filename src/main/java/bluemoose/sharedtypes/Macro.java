package bluemoose.sharedtypes;

import java.util.Date;
import java.util.List;

/*
 * Base class for a macro, an internal representation of all it means to be a macro.
 * Written to be easily extendible with new or even dynamic macros.
 */
public abstract class Macro {
	String uniqueID = null;
	String creatorFname = null;
	String creatorLname = null;
	String reviewerFname = null;
	String reviewerLname = null;
	boolean wasPeerReviewed = false;
	Date runDate = null;
	Date creationDate = null;
	
	public abstract List<String> getParameters();
	public abstract MacroType getMacroType();
	public abstract String getSQL();
	public abstract void setParameter(int index, String parameter);
	
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
