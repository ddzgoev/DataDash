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
	public StoredMacroListResult getPendingMacros(AuthenticatedRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleResultWithFailMessage reviewMacro(PeerReviewRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MacroTypeListResult getAllMacroTypes(AuthenticatedRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
