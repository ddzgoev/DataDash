package bluemoose.mediator;

import java.time.Duration;
import java.util.List;

public class TimeListResult extends MediatorResult {
	final List<Duration> times;

	public TimeListResult(MediatorStatus status, List<Duration> times) {
		super(status);
		this.times = times;
	}

	public List<Duration> getTimes() {
		return times;
	}
}
