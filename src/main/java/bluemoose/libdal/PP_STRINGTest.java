package bluemoose.libdal;

import static org.junit.Assert.*;

import org.junit.Test;

public class PP_STRINGTest {

	@Test
	public void test() {
		PP_STRING pps = new PP_STRING(30);
		
		String input = "1\' or \'1\' = \'1";
		System.out.println(input);
		String output = pps.sanitize(input);
		System.out.println(output);
		
		String input2 = "Here\'s some bad \t characters: _ % \n \' \"";
		System.out.println(input2);
		String output2 = pps.sanitize(input2);
		System.out.println(output2);
				
		fail("Not yet implemented");
	}

}
