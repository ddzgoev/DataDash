package bluemoose.translators.web;

import bluemoose.ModuleFactoryInterface;

import bluemoose.translators.Translator;
import spark.Spark;

import static spark.Spark.*;

/*
 * The WebTranslator provides restful services to the web UI.
 * The WebTranslator does not provide services to other java modules.
 */
public class WebTranslator implements Translator {
	
	public WebTranslator(ModuleFactoryInterface factory){
		// TODO Auto-generated method stub
	}

	@Override
	public void start() {
		// TODO This is where the spark-java application should start.
	}

	@Override
	public void stop() {
		Spark.stop();
	}

}
