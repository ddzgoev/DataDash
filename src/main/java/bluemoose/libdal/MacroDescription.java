package bluemoose.libdal;

import java.util.List;

public class MacroDescription {
	MacroType type;
	List<ParameterType> parameters;
	//Human readable name
	String name;
	//Human readable description provided on a "best effort" basis.
	String description = "";
}
