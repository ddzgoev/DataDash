package bluemoose.sharedtypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/*
 * Static factory to handle macros.
 * In order to handle dynamic macro creation needs major changes.
 */
public class MacroFactory {
	
	/*
	 * Reencodes a macro that was stored in the internal database.
	 * Performs no type checking of any kind.
	 * Should ONLY be used on macros that were stored in the internal database.
	 * Never to create new macros.
	 */
	public static Macro reEncodeMacro(String uniqueID, String creatorFname, String creatorLname, String reviewerFname,
			String reviewerLname, boolean wasPeerReviewed, Date runDate, Date creationDate,
			List<String> parameters, MacroType macroType) {
		return new BasicMacro(uniqueID, creatorFname, creatorLname, reviewerFname,
				reviewerLname, wasPeerReviewed, runDate,creationDate,
				parameters, macroType);
	}
	
	/*
	 * Creates a brand new DRIVER_SCHEDULE_DELETE macro
	 */
	public static Macro driverSceduleDelete(String creatorFname, String creatorLname, String runName){
		String uniqueID = null; //TODO generate unique ID somehow.
		return new BasicMacro(uniqueID, creatorFname, creatorLname, null,
				null, false, null,new Date(),
				Collections.singletonList(runName), MacroType.DRIVER_SCHEDULE_DELETE);
	}
	
	/*
	 * Creates a brand new DRIVER_SCHEDULE_UPDATE macro
	 */
	public static Macro driverSceduleUpdate(String creatorFname, String creatorLname, String runName, String auditID, String timestamp){
		String uniqueID = null; //TODO generate unique ID somehow.
		return new BasicMacro(uniqueID, creatorFname, creatorLname, null,
				null, false, null,new Date(),
				Arrays.asList(runName,auditID,timestamp), MacroType.DRIVER_SCHEDULE_UPDATE);
	}
	
	//TODO all the other macro types.
	
}
