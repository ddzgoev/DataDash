package bluemoose.mediator;

import java.util.ArrayList;
import java.util.List;

public class MacroTypeListResult implements MacroTypeListResultInterface {

	List<MacroType> data = new ArrayList<>();
	
	public void addType(MacroType type){
		data.add(type);
	}
	
	@Override
	public MediatorStatus getStatus() {
		return MediatorStatus.SUCCESS;
	}

	@Override
	public List<MacroType> getMacroTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
