package bluemoose.idal;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class IDALTester {

	@Test
	public void test(){
		IDALInterface idal = new IDALImpl();
		MacroInterface macro = idal.storeMacro("admin", "lastname", "Type2", Arrays.asList("A","B","C"));
		assertEquals(macro.getCreatorFname(),"admin");
		assertEquals(macro.getCreatorLname(),"lastname");
		assertEquals(macro.getParameters(),Arrays.asList("A","B","C"));
		assertEquals(macro.getMacroType(), "Type2");
		
		macro = idal.reviewMacro(macro.getUniqueID(), "otherguy", "othername", Arrays.asList("A","B","D"));
		assertEquals(macro.getCreatorFname(),"admin");
		assertEquals(macro.getCreatorLname(),"lastname");
		assertEquals(macro.getOriginalParameters(),Arrays.asList("A","B","C"));
		assertEquals(macro.getMacroType(), "Type2");
		assertEquals(macro.getReviewerFname(),"otherguy");
		assertEquals(macro.getReviewerLname(),"othername");
		assertEquals(macro.getParameters(),Arrays.asList("A","B","D"));
		assertEquals(macro.getMacroType(), "Type2");
		assertEquals(macro.getWasPeerReviewed(),true);
		
		macro = idal.markRan(macro.getUniqueID());
	}
}
