package bluemoose.libdal;

import bluemoose.sharedtypes.Macro;

/*
 * A Liberty Data Access Layer is responsible for providing services to the mediator
 * related to accessing the Liberty Mutual environment.
 */
public interface LibDALInterface {
	public void runMacro(Macro macro);
	
}
