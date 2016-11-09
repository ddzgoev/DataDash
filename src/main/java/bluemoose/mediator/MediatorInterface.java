package bluemoose.mediator;

/**
 * A mediator is responsible for handling requests made from a translator,
 * in a manner independently of the translator,  and routing requests to the
 * correct data access component. It deals entirely with java objects.
 */
public interface MediatorInterface {
	/**
	 * Request a login to the system.
	 * @param username The username of the user.
	 * @param password The password of the user.
	 * @return
	 */
	LoginResult login(String username, String password);
	/**
	 * Request a list of all types of macros the system supports.
	 * @param request
	 * @return
	 */
	MacroTypeListResultInterface getAllMacroTypes(AuthenticatedRequest request);
	/**
	 * Request constraint definitions for a list of parameter types.
	 * @param request
	 * @return
	 */
	ParameterExplanationResultInterface getParameterExplanation(ParameterListRequest request);
	/**
	 * Request a macro be submitted.
	 * If peer review is off, this is a request for the macro to be run.
	 * If peer review is on, this is a request to make the macro pending for review.
	 * @param request
	 * @return
	 */
	SimpleResultWithFailMessage submitMacro(RunMacroRequest request);
	/**
	 * Request a list of all macros pending for peer review.
	 * @param request
	 * @return
	 */
	StoredMacroListResultInterface getPendingMacros(AuthenticatedRequest request);
	/**
	 * Request a macro be peer reviewed and executed.
	 * @param request
	 * @return
	 */
	SimpleResultWithFailMessage reviewMacro(PeerReviewRequest request);
	/**
	 * Request a journal of all macros that were executed during a particular time period.
	 * @param request
	 * @return
	 */
	StoredMacroListResultInterface getJournal(TimedRequest request);
	/**
	 * Request a list of all macros that could not be executed during a particular time period.
	 * @param request
	 * @return
	 */
	StoredMacroListResultInterface getMacroFailures(TimedRequest request);
	/**
	 * Request a list of all currently running Steps.
	 * @param request
	 * @return
	 */
	StepListResultInterface getRunningSteps(AuthenticatedRequest request);
	/**
	 * Request a list of all Steps that began running during the time period.
	 * @param request
	 * @return
	 */
	StepListResultInterface getPastSteps(TimedRequest request);
	
	/**
	 * Request the runtime average of a step over a time period
	 * @param request
	 * @param stepID
	 * @return
	 */
	AverageTimeResultInterface getStepAverage(TimedRequest request, String stepID);
}
