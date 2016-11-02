package bluemoose.idal;

import java.util.Date;
import java.util.List;

public class FailedMacro extends Macro {

	public FailedMacro(String uniqueID, String creatorFname, String creatorLname, String reviewerFname,
			String reviewerLname, boolean wasPeerReviewed, Date runDate, Date creationDate, String macroType,
			List<String> parameters, List<String> originalParameters) {
		super(uniqueID, creatorFname, creatorLname, reviewerFname, reviewerLname, wasPeerReviewed, runDate, creationDate,
				macroType, parameters, originalParameters);
		// TODO Auto-generated constructor stub
	}
	
	public String reason;

	@Override
	public boolean getFailed(){
		return true;
	}
	
	@Override
	public String getFailureReason(){
		return reason;
	}
}
