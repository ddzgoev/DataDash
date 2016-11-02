package bluemoose;

import java.util.Collection;

import bluemoose.adal.ADALInterface;
import bluemoose.idal.IDALInterface;
import bluemoose.libdal.LibDALInterface;
import bluemoose.mediator.MediatorInterface;
import bluemoose.translators.Translator;

/*
 * Root level interface to give each module modular access to its dependencies.
 */
public interface ModuleFactoryInterface {
	/*
	 * Returns a singleton implementation of the Internal Data Access Layer.
	 * Only "Mediator"s should use this function.
	 */
	public IDALInterface getIDAL();
	
	/*
	 * Returns a singleton implementation of the Liberty Data Access Layer.
	 * Only "Mediator"s should use this function.
	 */
	public LibDALInterface getLibDAL();
	
	/*
	 * Returns a singleton implementation of the Authentication Data Access Layer.
	 * Only "Mediator"s should use this function.
	 */
	public ADALInterface getADAL();
	
	/*
	 * Returns a singleton implementation of the core Mediator component.
	 * Only "Translator"s should use this function.
	 */
	public MediatorInterface getMediator();
	
	/*
	 * Starts all Translators, allowing all types of UIs to connect.
	 */
	public default void startTranslators(){
		getTranslators().forEach((translator) -> {
			translator.start();
		});
	}
	
	/*
	 * Stops and cleans up resources for all translators, to shutdown system.
	 */
	public default void stopTranslators(){
		getTranslators().forEach((translator) -> {
			translator.stop();
		});
	}
	
	/*
	 * returns a collection of singletons of all translators used.
	 */
	Collection<Translator> getTranslators();
}
