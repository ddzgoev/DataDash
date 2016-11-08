package bluemoose.mediator;

import java.util.List;

import bluemoose.libdal.DriverStep;

public interface StepListResultInterface extends MediatorResultInterface{

	List<DriverStep> getSteps();

}