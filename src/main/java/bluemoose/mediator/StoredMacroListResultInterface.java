package bluemoose.mediator;

import java.util.List;

import bluemoose.idal.Macro;

/**
 * A response from the mediator containing a list of stored requests to run macros, or logged runs of macros.
 * @author Ethan
 *
 */
public interface StoredMacroListResultInterface extends MediatorResultInterface{

	/**
	 * 
	 * @return A list of macros
	 */
	List<Macro> getResult();

}