package bluemoose.mediator;

import java.util.List;
import java.util.stream.Collectors;

import bluemoose.ModuleFactoryInterface;
import bluemoose.adal.AuthUser;
import bluemoose.idal.Macro;
import bluemoose.idal.MacroInterface;
import bluemoose.libdal.MacroDescription;
import bluemoose.libdal.ParameterType;
import bluemoose.libdal.RunMacroResult;

/*
 * Our implementation of the Mediator Interface for production usage.
 */
public class MediatorImpl implements MediatorInterface {

	private ModuleFactoryInterface factory;

	public MediatorImpl(ModuleFactoryInterface factory) {
		this.factory = factory;
	}

	@Override
	public SimpleResultWithFailMessage submitMacro(RunMacroRequest request) {
		AuthUser user = authenticate(request.getAuthentication());
		switch (user.success()) {
		case EXPIRED:
			return new SimpleResultWithFailMessage(MediatorStatus.AUTHENTICATION_EXPIRATION, "");
		case FAILURE:
			return new SimpleResultWithFailMessage(MediatorStatus.AUTHENTICATION_ERROR, "");
		default:
			break;
		}
		MacroInterface macro = factory.getIDAL().storeMacro(user.getFname(), user.getLname(), request.getMacroType(),
				request.getParameters());

		if (request.isSkipReview()) {
			return executeMacro(macro);
		} else {
			return new SimpleResultWithFailMessage(MediatorStatus.SUCCESS, "");
		}
	}

	@Override
	public StoredMacroListResultInterface getPendingMacros(AuthenticatedRequest request) {
		AuthUser user = authenticate(request.getAuthentication());
		switch (user.success()) {
		case EXPIRED:
			return new FailedStoredMacroListResult(MediatorStatus.AUTHENTICATION_EXPIRATION);
		case FAILURE:
			return new FailedStoredMacroListResult(MediatorStatus.AUTHENTICATION_ERROR);
		default:
			break;
		}
		List<Macro> pending = factory.getIDAL().getAllPendingMacros();
		return new StoredMacroListResult(MediatorStatus.SUCCESS, pending);
	}

	@Override
	public SimpleResultWithFailMessage reviewMacro(PeerReviewRequest request) {
		AuthUser user = authenticate(request.getAuthentication());
		switch (user.success()) {
		case EXPIRED:
			return new SimpleResultWithFailMessage(MediatorStatus.AUTHENTICATION_EXPIRATION, "");
		case FAILURE:
			return new SimpleResultWithFailMessage(MediatorStatus.AUTHENTICATION_ERROR, "");
		default:
			break;
		}

		MacroInterface macro = factory.getIDAL().reviewMacro(request.getMacroID(), user.getLname(), user.getFname(),
				request.getParamaters());

		if (macro == null) {
			return new SimpleResultWithFailMessage(MediatorStatus.BAD_REQUEST, "Macro does not exist.");
		}

		return executeMacro(macro);

	}

	@Override
	public MacroTypeListResultInterface getAllMacroTypes(AuthenticatedRequest request) {
		AuthUser user = authenticate(request.getAuthentication());
		switch (user.success()) {
		case EXPIRED:
			return new FailedMacroTypeListResult(MediatorStatus.AUTHENTICATION_EXPIRATION);
		case FAILURE:
			return new FailedMacroTypeListResult(MediatorStatus.AUTHENTICATION_ERROR);
		default:
			break;
		}
		
		List<MacroDescription> descriptions = factory.getLibDAL().getMacros();
		
		MacroTypeListResult result = new MacroTypeListResult();
		
		for(MacroDescription description: descriptions){
			result.addType(new MacroType(description.getType().name(),description.getName(),description.getDescription(),description.getParameters().stream().map((type) -> type.name()).collect(Collectors.toList()),description.getParameters().stream().map((type) -> type.getName()).collect(Collectors.toList())));
		}
		
		return result;
	}

	@Override
	public LoginResult login(String username, String password) {
		try {
			AuthUser result = factory.getADAL().login(username, password);
			switch (result.success()) {
			case EXPIRED:
				return new LoginResult(MediatorStatus.INTERNAL_ERROR, null);
			case FAILURE:
				return new LoginResult(MediatorStatus.FAILURE, null);
			case SUCCESS:
				return new LoginResult(MediatorStatus.SUCCESS, result);
			default:
				return new LoginResult(MediatorStatus.INTERNAL_ERROR, null);
			}
		} catch (Exception e) {
			return new LoginResult(MediatorStatus.INTERNAL_ERROR, null);
		}
	}

	@Override
	public ParameterExplanationResultInterface getParameterExplanation(ParameterListRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoredMacroListResultInterface getJournal(TimedRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoredMacroListResultInterface getMacroFailures(TimedRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StepListResultInterface getRunningSteps(AuthenticatedRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StepListResultInterface getPastSteps(TimedRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AverageTimeResultInterface getStepAverage(TimedRequest request, String stepID) {
		// TODO Auto-generated method stub
		return null;
	}

	private AuthUser authenticate(String authentication) {
		return factory.getADAL().checkToken(authentication);
	}

	private SimpleResultWithFailMessage executeMacro(MacroInterface macro) {
		RunMacroResult result = factory.getLibDAL().runMacro(macro.getMacroType(), macro.getParameters());
		factory.getIDAL().markRan(macro.getUniqueID());
		switch (result.wasSuccesful()) {
		case FAILURE:
			// Never happens under normal circumstances.
			factory.getIDAL().markFailed(macro.getUniqueID(), "Macro failed at runtime.");
			return new SimpleResultWithFailMessage(MediatorStatus.FAILURE,
					"Macro failed at runtime, probably because database could not be accessed");
		case INCORRECT_NUMBER_OF_PARAMETERS:
			factory.getIDAL().markFailed(macro.getUniqueID(), "Incorrect number of parameters.");
			return new SimpleResultWithFailMessage(MediatorStatus.BAD_REQUEST,
					"Macro failed at runtime, probably because database could not be accessed");
		case INVALID_PARAMETERS:
			String problemString = "";
			for (ParameterType problem : result.problems()) {
				problemString += problem.name() + " ";
			}
			factory.getIDAL().markFailed(macro.getUniqueID(),
					"Some parameters were invalid, invalid parameters were: " + problemString);
			return new SimpleResultWithFailMessage(MediatorStatus.BAD_REQUEST,
					"Some parameters were invalid, invalid parameters were: " + problemString);
		case SUCCESS:
			return new SimpleResultWithFailMessage(MediatorStatus.SUCCESS, "");
		case UNSUPPORTED_MACRO_TYPE:
			factory.getIDAL().markFailed(macro.getUniqueID(), "Unsupported macro type");
			return new SimpleResultWithFailMessage(MediatorStatus.BAD_REQUEST, "Unsupported macro type");
		default:
			return new SimpleResultWithFailMessage(MediatorStatus.INTERNAL_ERROR, "Invalid return value from LibDAL");
		}
	}
}
