package bluemoose.mediator;

import java.time.Period;

public class TimedRequest extends AuthenticatedRequest {
	Period period;

	public TimedRequest(String authentication, Period period) {
		super(authentication);
		this.period = period;
	}
}
