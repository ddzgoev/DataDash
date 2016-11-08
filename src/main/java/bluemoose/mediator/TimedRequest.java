package bluemoose.mediator;

import java.time.Period;

/**
 * A request to the mediator that relates to a period of time.
 * @author Ethan
 *
 */
public class TimedRequest extends AuthenticatedRequest {
	/**
	 * The time period the request deals with.
	 * @return
	 */
	public Period getPeriod() {
		return period;
	}

	final Period period;

	public TimedRequest(String authentication, Period period) {
		super(authentication);
		this.period = period;
	}
}
