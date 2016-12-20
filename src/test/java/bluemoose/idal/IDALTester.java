package bluemoose.idal;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import bluemoose.Period;

public class IDALTester {

	@Test
	public void test(){
		IDALInterface idal = new IDALImpl();
		MacroInterface macro = idal.storeMacro("admin", "lastname", "Type2", Arrays.asList("A","B","C"));
		assertEquals(macro.getCreatorFname(),"admin");
		assertEquals(macro.getCreatorLname(),"lastname");
		System.out.println(macro.getParameters().get(0));
		assertEquals(macro.getParameters(),Arrays.asList("A","B","C"));
		assertEquals(macro.getMacroType(), "Type2");
		
		macro = idal.reviewMacro(macro.getUniqueID(), "othername", "otherguy", Arrays.asList("A","B","D"));
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
		assertEquals(macro.getCreatorFname(),"admin");
		assertEquals(macro.getCreatorLname(),"lastname");
		assertEquals(macro.getOriginalParameters(),Arrays.asList("A","B","C"));
		assertEquals(macro.getMacroType(), "Type2");
		assertEquals(macro.getReviewerFname(),"otherguy");
		assertEquals(macro.getReviewerLname(),"othername");
		assertEquals(macro.getParameters(),Arrays.asList("A","B","D"));
		assertEquals(macro.getMacroType(), "Type2");
		assertEquals(macro.getWasPeerReviewed(),true);
		
		List<Macro> list = idal.getJournal();
		macro = list.get(0);
		assertEquals(macro.getCreatorFname(),"admin");
		assertEquals(macro.getCreatorLname(),"lastname");
		assertEquals(macro.getOriginalParameters(),Arrays.asList("A","B","C"));
		assertEquals(macro.getMacroType(), "Type2");
		assertEquals(macro.getReviewerFname(),"otherguy");
		assertEquals(macro.getReviewerLname(),"othername");
		assertEquals(macro.getParameters(),Arrays.asList("A","B","D"));
		assertEquals(macro.getMacroType(), "Type2");
		assertEquals(macro.getWasPeerReviewed(),true);
		
		long now = new Date().getTime();
		list = idal.viewJournal(new Period(new Date(now-10000),new Date(now)));
		
		macro = list.get(0);
		assertEquals(macro.getCreatorFname(),"admin");
		assertEquals(macro.getCreatorLname(),"lastname");
		assertEquals(macro.getOriginalParameters(),Arrays.asList("A","B","C"));
		assertEquals(macro.getMacroType(), "Type2");
		assertEquals(macro.getReviewerFname(),"otherguy");
		assertEquals(macro.getReviewerLname(),"othername");
		assertEquals(macro.getParameters(),Arrays.asList("A","B","D"));
		assertEquals(macro.getMacroType(), "Type2");
		assertEquals(macro.getWasPeerReviewed(),true);
		
		idal.markFailed(macro.getUniqueID(), "hello");
	}
}
