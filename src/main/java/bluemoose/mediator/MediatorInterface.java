package bluemoose.mediator;

/*
 * A mediator is responsible for handling requests made from a translator,
 * in a manner independently of the translator,  and routing requests to the
 * correct data access component. It deals entirely with java objects.
 */
public interface MediatorInterface {
	SimpleResultWithFailMessage submitMacro(RunMacroRequest request);
	MacroListResult getPendingMacros(AuthenticatedRequest request);
	SimpleResultWithFailMessage reviewMacro(PeerReviewRequest request);
	//TODO the rest 
}
