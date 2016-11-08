package bluemoose.mediator;

import java.util.List;

import bluemoose.idal.Macro;

public interface StoredMacroListResultInterface extends MediatorResultInterface{

	List<Macro> getResult();

}