package bluemoose.mediator;

import java.time.Duration;

public class AverageTimeResult extends MediatorResult implements AverageTimeResultInterface {
	
	public AverageTimeResult(MediatorStatus status, Duration time) {
		super(status);
		this.time = time;
	}

	private Duration time;

	@Override
	public Duration getTime() {
		return time;
	}

}
