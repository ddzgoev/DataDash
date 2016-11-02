package bluemoose.sharedtypes;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class BasicMacro extends Macro {
	
	BasicMacro(String uniqueID, String creatorFname, String creatorLname, String reviewerFname,
			String reviewerLname, boolean wasPeerReviewed, Date runDate, Date creationDate,
			List<String> parameters, MacroType macroType) {
		super(uniqueID, creatorFname, creatorLname, reviewerFname, reviewerLname, wasPeerReviewed, runDate,
				creationDate);
		this.parameters = parameters;
		this.macroType = macroType;
	}

	List<String> parameters;
	MacroType macroType;

	@Override
	public List<String> getParameters() {
		return parameters;
	}

	@Override
	public MacroType getMacroType() {
		return macroType;
	}

	@Override
	public String getSQL() {
		//TODO generate sql based on macro type and parameters.
		return null;
	}
	
	/*
	 * Verifies the type of parameter is valid for the macrotype.
	 */
	private boolean verify(int index, Object parameter) {
		// TODO Verify the type of parameter is valid for the macrotype.
		return false;
	}

	@Override
	public void setParameter(int index, String parameter) {
		if(verify(index,parameter)){
			parameters.set(index, parameter);
		}
	}

}
