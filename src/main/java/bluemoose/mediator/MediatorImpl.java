package bluemoose.mediator;

import bluemoose.ModuleFactoryInterface;
import bluemoose.adal.AuthUser;

/*
 * Our implementation of the Mediator Interface for production usage.
 */
public class MediatorImpl implements MediatorInterface {
	
	private ModuleFactoryInterface factory;
	
	public MediatorImpl(ModuleFactoryInterface factory){
		this.factory=factory;
	}

	@Override
	public SimpleResultWithFailMessage submitMacro(RunMacroRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoredMacroListResultInterface getPendingMacros(AuthenticatedRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleResultWithFailMessage reviewMacro(PeerReviewRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MacroTypeListResultInterface getAllMacroTypes(AuthenticatedRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginResult login(String username, String password) {
		try{
			AuthUser result = factory.getADAL().login(username, password);
			switch(result.success()){
			case EXPIRED:
				return new LoginResult(MediatorStatus.INTERNAL_ERROR,null);
			case FAILURE:
				return new LoginResult(MediatorStatus.FAILURE,null);
			case SUCCESS:
				return new LoginResult(MediatorStatus.SUCCESS,result);
			default:
				return new LoginResult(MediatorStatus.INTERNAL_ERROR,null);
			}
		}
		catch(Exception e){
			return new LoginResult(MediatorStatus.INTERNAL_ERROR,null);
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
}
