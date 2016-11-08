package bluemoose.libdal;

import java.util.List;

/**
 * Description of a type of macro.
 * @author Ethan
 *
 */
public interface MacroDescriptionInterface {

	/**
	 * @return The unique unchanging ID of the type of macro.
	 */
	MacroType getType();

	/**
	 * 
	 * @return List of types of parameters. Note ParameterType includes unique ID and name but not description.
	 */
	List<ParameterType> getParameters();

	/**
	 * 
	 * @return The human readable name of the type of macro.
	 */
	String getName();

	/**
	 * 
	 * @return The human readable description of the type of macro.
	 */
	String getDescription();

}