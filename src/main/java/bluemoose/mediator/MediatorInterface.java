package bluemoose.mediator;

/*
 * A mediator is responsible for handling requests made from a translator,
 * in a manner independently of the translator,  and routing requests to the
 * correct data access component. It deals entirely with java objects.
 */
public interface MediatorInterface {
	LoginResult login(String username, String password);
	MacroTypeListResultInterface getAllMacroTypes(AuthenticatedRequest request);
	ParameterExplanationResultInterface getParameterExplanation(ParameterListRequest request);
	SimpleResultWithFailMessage submitMacro(RunMacroRequest request);
	StoredMacroListResultInterface getPendingMacros(AuthenticatedRequest request);
	SimpleResultWithFailMessage reviewMacro(PeerReviewRequest request);
	StoredMacroListResultInterface getJournal(TimedRequest request);
	StoredMacroListResultInterface getMacroFailures(TimedRequest request);
	StepListResultInterface getRunningSteps(AuthenticatedRequest request);
	StepListResultInterface getPastSteps(TimedRequest request);
	
	//TODO the rest 
}
