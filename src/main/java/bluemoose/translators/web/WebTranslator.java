package bluemoose.translators.web;

import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import bluemoose.ModuleFactoryInterface;
import bluemoose.adal.AuthUser;
import bluemoose.mediator.LoginResult;
import bluemoose.translators.Translator;
import spark.Request;
import spark.Response;
import spark.Spark;

/**
 * The WebTranslator provides restful services to the web UI.
 * The WebTranslator does not provide services to other java modules.
 */
public class WebTranslator implements Translator {
	
	private final ModuleFactoryInterface factory;
	private final ObjectMapper mapper = new ObjectMapper();
	private final String returnError = "{status: INTERNAL_ERROR, reason: error in mediator return value}";
	private final String parseError = "{status: TRANSLATION_FAILURE, reason: Unable to parse request}";
	private final String illegalCharacters = "{status: BAD_REQUEST, reason: illegal characters}";
	private final String loginFailure = "{status: FAILURE, reason: invalid username or password}";
	private final String mediatorError = "{status: INTERNAL_ERROR, reason: mediator reported an error}";
	private final String internalError = "{status: INTERNAL_ERROR, reason: error in web translator}";
	
	public WebTranslator(ModuleFactoryInterface factory){
		this.factory = factory;
	}

	@Override
	public void start() {
		port(50001);
		staticFiles.location("/public");
		
		post("/login",this::loginRoute);
	}

	@Override
	public void stop() {
		Spark.stop();
	}
	
	private String loginRoute(Request req, Response res){
		try {
			System.out.println(req.body());
			LoginRequestJSON logreq = mapper.readValue(req.body(), LoginRequestJSON.class);
			LoginResult logres = factory.getMediator().login(logreq.username, logreq.password);
			switch(logres.getStatus()){
			case AUTHENTICATION_ERROR:
				return returnError;
			case AUTHENTICATION_EXPIRATION:
				return returnError;
			case BAD_REQUEST:
				return illegalCharacters;
			case FAILURE:
				return loginFailure;
			case INTERNAL_ERROR:
				return mediatorError;
			case SUCCESS:
				res.type("application/json");
				AuthUser result = logres.getResult();
				return mapper.writer().writeValueAsString(new LoginResponseJSON(result.getAuthToken(),result.getFname(),result.getLname()));
			}
		} catch (IOException e) {
			e.printStackTrace();
			res.status(400);
			return parseError;
		}
		return internalError;
		
	}

}
