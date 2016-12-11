package bluemoose.translators.web;

import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bluemoose.ModuleFactoryInterface;
import bluemoose.adal.AuthUser;
import bluemoose.mediator.LoginResult;
import bluemoose.mediator.MediatorStatus;
import bluemoose.mediator.PeerReviewRequest;
import bluemoose.mediator.SimpleResultWithFailMessage;
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
	private final SimpleFailJSON parseError = SimpleFailJSON.translationFailure;
	private final SimpleFailJSON illegalCharacters = new SimpleFailJSON(MediatorStatus.BAD_REQUEST, "illegal characters");
	private final SimpleFailJSON loginFailure = new SimpleFailJSON(MediatorStatus.FAILURE, "invalid username or password");
	private final SimpleFailJSON mediatorError = new SimpleFailJSON(MediatorStatus.INTERNAL_ERROR, "mediator reported an error");
	private final SimpleFailJSON internalError = new SimpleFailJSON(MediatorStatus.INTERNAL_ERROR, "error in web translator");
	private final SimpleFailJSON authenticationError = new SimpleFailJSON(MediatorStatus.AUTHENTICATION_ERROR, "Please login first.");
	private final SimpleFailJSON authenticationExpiration = new SimpleFailJSON(MediatorStatus.AUTHENTICATION_EXPIRATION, "Session expired. Please login again.");
	private final SimpleFailJSON returnError = new SimpleFailJSON(MediatorStatus.INTERNAL_ERROR, "error in mediator return value");
	public WebTranslator(ModuleFactoryInterface factory){
		this.factory = factory;
	}

	@Override
	public void start() {
		port(50001);
		staticFiles.location("/public");
		
		post("/login",this::loginRoute);
		post("/peerreview/review", this::reviewMacroRoute);
	}

	@Override
	public void stop() {
		Spark.stop();
	}
	
	private String reviewMacroRoute(Request req, Response res){
		try {
			res.type("application/json");
			String body = getBody(req);
			
			ReviewMacroRequestJSON revreq = mapper.readValue(body, ReviewMacroRequestJSON.class);
			SimpleResultWithFailMessage revres = factory.getMediator().reviewMacro(new PeerReviewRequest(revreq.authentication, revreq.macroID, revreq.parameters));
			switch(revres.getStatus()){
			case AUTHENTICATION_ERROR:
				return write(authenticationError);
			case AUTHENTICATION_EXPIRATION:
				return write(authenticationExpiration);
			case BAD_REQUEST://fallthrough
			case FAILURE: //fallthrough
			case INTERNAL_ERROR:
				return write(new SimpleFailJSON(revres.getStatus(),revres.getMessage()));
			case SUCCESS:
				return write(new SimpleResultJSON(revres.getMessage()));
			}
		} catch (IOException e) {
			e.printStackTrace();
			res.status(400);
			return write(parseError);
		}
		return write(internalError);
	}
	
	private String loginRoute(Request req, Response res){
		try {
			String body = getBody(req);
			
			LoginRequestJSON logreq = mapper.readValue(body, LoginRequestJSON.class);
			LoginResult logres = factory.getMediator().login(logreq.username, logreq.password);
			switch(logres.getStatus()){
			case AUTHENTICATION_ERROR:
				return write(returnError);
			case AUTHENTICATION_EXPIRATION:
				return write(returnError);
			case BAD_REQUEST:
				return write(illegalCharacters);
			case FAILURE:
				return write(loginFailure);
			case INTERNAL_ERROR:
				return write(mediatorError);
			case SUCCESS:
				res.type("application/json");
				AuthUser result = logres.getResult();
				return write(new LoginResponseJSON(result.getAuthToken(),result.getFname(),result.getLname()));
			}
		} catch (IOException e) {
			e.printStackTrace();
			res.status(400);
			return write(parseError);
		}
		return write(internalError);
		
	}
	
	private static String getBody(Request req){
		if(req.contentType() == "application/x-www-form-urlencoded"){
			return paramJson(req.body());
		}
		else{
			return req.body();
		}
	}
	
	//http://stackoverflow.com/questions/29381446/convert-parse-url-parameteres-to-json-in-java
	private static String paramJson(String paramIn) {
	    paramIn = paramIn.replaceAll("=", "\":\"");
	    paramIn = paramIn.replaceAll("&", "\",\"");
	    return "{\"" + paramIn + "\"}";
	}
	
	private String write(Object object){
		try {
			return mapper.writer().writeValueAsString(object);
		} catch (JsonProcessingException e) {
			//Should never happen. If it does something has gone horribly wrong.
			throw new RuntimeException(e);
		}
	}

}
