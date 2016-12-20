package bluemoose.libdal;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LibDALImplTest {

	@Test
	public void testRunMacro() {
		LibDALImpl test = new LibDALImpl();
		List<String> params = new ArrayList<String>();
		params.add("Test RUN NAME");
		RunMacroResult result = test.runMacro("Driver Schedule Delete By Run Name", params);
		MacroResultType mrt = result.wasSuccessful();
		System.out.println(mrt);
		System.out.println(result.problems());
	}

}
