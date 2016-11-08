package bluemoose.mediator;

import java.time.Duration;
import java.util.List;

public interface TimeListResultInterface extends MediatorResultInterface {

	List<Duration> getTimes();

}