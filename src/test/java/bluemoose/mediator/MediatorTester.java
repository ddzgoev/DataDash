package bluemoose.mediator;

import java.util.ArrayList;

import org.junit.Test;

import bluemoose.ModuleFactoryImpl;

public class MediatorTester {
	@Test
	public void test(){
		ModuleFactoryImpl factory = new ModuleFactoryImpl();
		MediatorInterface mediator = factory.getMediator();
		String auth = mediator.login("admin", "admin").getResult().getAuthToken();
		mediator.submitMacro(new RunMacroRequest(auth,"type___-__",new ArrayList<>(),true));
	}
}
