package bluemoose.mediator;

/*
 * A mediator is responsible for handling requests made from a translator,
 * in a manner independently of the translator,  and routing requests to the
 * correct data access component. It deals entirely with java objects.
 */
public interface MediatorInterface {
	LoginResult login(String username, String password);
	MacroTypeListResult getAllMacroTypes(AuthenticatedRequest request);
	ParameterExplanationResult getParameterExplanation(ParameterListRequest request);
	SimpleResultWithFailMessage submitMacro(RunMacroRequest request);
	StoredMacroListResult getPendingMacros(AuthenticatedRequest request);
	SimpleResultWithFailMessage reviewMacro(PeerReviewRequest request);
	StoredMacroListResult getJournal(TimedRequest request);
	StoredMacroListResult getMacroFailures(TimedRequest request);
	StepListResult getRunningSteps(AuthenticatedRequest request);
	StepListResult getPastSteps(TimedRequest request);
	
	//TODO the rest 
}
