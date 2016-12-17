package bluemoose.mediator;

import java.util.List;

import bluemoose.libdal.ParameterPossibilities;
import bluemoose.libdal.PossibilityType;
/**
 * A response from the mediator containing a list of descriptions of parameters.
 */
public interface ParameterExplanationResultInterface extends MediatorResultInterface{

	/**
	 * 
	 * @return A list of descriptions of parameters.
	 */
	List<ParameterPossibilities> getParameters();

}