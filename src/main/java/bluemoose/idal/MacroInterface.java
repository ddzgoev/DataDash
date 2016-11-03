package bluemoose.idal;

import java.util.Date;
import java.util.List;

public interface MacroInterface {

	List<String> getParameters();

	void setParameter(int index, String parameter);

	List<String> getOriginalParameters();

	String getMacroType();

	void setMacroType(String macroType);

	String getCreatorFname();

	void setCreatorFname(String creatorFname);

	String getCreatorLname();

	void setCreatorLname(String creatorLname);

	String getReviewerFname();

	void setReviewerFname(String reviewerFname);

	String getReviewerLname();

	void setReviewerLname(String reviewerLname);

	boolean getWasPeerReviewed();

	void setWasPeerReviewed(boolean wasPeerReviewed);

	Date getRunDate();

	void setRunDate(Date runDate);

	void setRunDateNow();

	Date getCreationDate();

	void setCreationDate(Date creationDate);

	void setCreationDateNow();

	String getUniqueID();

	void setUniqueID(String uniqueID);

	boolean getFailed();

	String getFailureReason();

}