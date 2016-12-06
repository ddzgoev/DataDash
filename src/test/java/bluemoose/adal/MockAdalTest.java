package bluemoose.adal;

import static org.junit.Assert.*;

import org.junit.Test;

public class MockAdalTest {
	@Test
	public void mockAdalTest(){
		ADALInterface ADAL = new MockAdal();
		
		AuthUser result = ADAL.login("wrong", "yep");
		assertEquals(result.success(),LoginResult.FAILURE);
		
		result = ADAL.login("admin", "wrong");
		assertEquals(result.success(),LoginResult.FAILURE);
		
		result = ADAL.login("admin", "admin");
		assertEquals(result.success(),LoginResult.SUCCESS);
		
		assertEquals(result.getFname(),"admin");
		
		result = ADAL.checkToken(result.getAuthToken());
		assertEquals(result.success(),LoginResult.SUCCESS);
		assertEquals(result.getFname(),"admin");
		
		result = ADAL.login("expired", "expired");
		assertEquals(result.success(),LoginResult.SUCCESS);
		assertEquals(result.getFname(),"expired");
		
		result = ADAL.checkToken(result.getAuthToken());
		assertEquals(result.success(),LoginResult.EXPIRED);
		
		result = ADAL.checkToken("oogabooga");
		assertEquals(result.success(),LoginResult.FAILURE);
	}
}
