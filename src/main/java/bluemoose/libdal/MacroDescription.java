package bluemoose.libdal;

import java.util.List;
/**
 * Data structure representing a description of a type of macro. 
 */
public class MacroDescription implements MacroDescriptionInterface {
	/* (non-Javadoc)
	 * @see bluemoose.libdal.MacroDescriptionInterface#getType()
	 */
	@Override
	public MacroType getType() {
		return type;
	}
	/* (non-Javadoc)
	 * @see bluemoose.libdal.MacroDescriptionInterface#getParameters()
	 */
	@Override
	public List<ParameterType> getParameters() {
		return parameters;
	}
	/* (non-Javadoc)
	 * @see bluemoose.libdal.MacroDescriptionInterface#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see bluemoose.libdal.MacroDescriptionInterface#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}
	public MacroDescription(MacroType type, List<ParameterType> parameters, String name) {
		this.type = type;
		this.parameters = parameters;
		this.name = name;
	}
	final MacroType type;
	final List<ParameterType> parameters;
	//Human readable name
	final String name;
	//Human readable description provided on a "best effort" basis.
	final String description = "";
}
