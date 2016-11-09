package bluemoose;

/**
 * Class to start the production server.
 */
public class Main {

	/**
	 * The root function to start the application in production mode.
	 * @param args
	 */
	public static void main(String[] args) {
		
		ModuleFactoryInterface factory = new ModuleFactoryImpl();
		
		factory.startTranslators();
		
		Runtime.getRuntime().addShutdownHook( new Thread(){
			@Override
			public void run(){
				factory.stopTranslators();
			}
		});
	}

}
