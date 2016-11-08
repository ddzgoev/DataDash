package bluemoose.mediator;

import java.util.List;

/**
 * Mediator result for a list of all macro types in the system.
 * @author Ethan
 *
 */
public interface MacroTypeListResultInterface extends MediatorResultInterface {
	/**
	 * 
	 * @return A list of all macro types the system supports the execution of.
	 */
	List<MacroType> getMacroTypes();
	
}
