package bluemoose.mediator;

import java.time.Duration;
import java.util.List;

public class TimeListResult extends MediatorResult implements TimeListResultInterface {
	final List<Duration> times;

	public TimeListResult(MediatorStatus status, List<Duration> times) {
		super(status);
		this.times = times;
	}

	/* (non-Javadoc)
	 * @see bluemoose.mediator.TimeListResultInterface#getTimes()
	 */
	@Override
	public List<Duration> getTimes() {
		return times;
	}
}
