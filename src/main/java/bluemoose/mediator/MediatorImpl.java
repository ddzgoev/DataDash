package bluemoose.mediator;

import bluemoose.ModuleFactoryInterface;

/*
 * Our implementation of the Mediator Interface for production usage.
 */
public class MediatorImpl implements MediatorInterface {
	public MediatorImpl(ModuleFactoryInterface factory){
		//TODO
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
		// TODO Auto-generated method stub
		return null;
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
}
