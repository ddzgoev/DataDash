package bluemoose.translators;

/**
 * A translator is a module that provides access to a particular UI
 * or set of UIs. It translates requests made from the UIs into java
 * objects that represent requests that are ambivalent to the UI so that
 * mediators can treat all UIs equally.
 */
public interface Translator {
	/**
	 * Performs any needed initialization of the translator module.
	 * Should return quickly but can start threads/servers/etc.
	 */
	public void start();
	/**
	 * Performs any needed cleanup of the translator module for shutdown.
	 * Performs any needed stopping of threads/servers/etc then returns.
	 */
	public void stop();
}
