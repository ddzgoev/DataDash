package bluemoose.translators;

/*
 * A translator is a module that provides access to a particular UI
 * or set of UIs. It translates requests made from the UIs into java
 * objects that represent requests that are ambivalent to the UI so that
 * mediators can treat all UIs equally.
 */
public interface Translator {
	public void start();
	public void stop();
}
