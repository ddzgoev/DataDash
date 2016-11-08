package bluemoose.mediator;

import java.sql.Time;

/**
 * A mediator result containing the average time of something
 * @author Ethan
 *
 */
public interface AverageTimeResultInterface extends MediatorResultInterface {
	/**
	 * 
	 * @return the averaqge time
	 */
	Time getTime();
}
