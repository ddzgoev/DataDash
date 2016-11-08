package bluemoose.mediator;

import java.util.List;

import bluemoose.libdal.PossibilityType;

public interface ParameterExplanationResultInterface extends MediatorResultInterface{

	List<PossibilityType> getParameters();

}