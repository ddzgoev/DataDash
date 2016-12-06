/**
 * 
 */
package bluemoose.adal;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;

/**
 * @author Ethan
 *
 */
public class MockAdal implements ADALInterface {
	
	private Key key = MacProvider.generateKey();
	
	/* (non-Javadoc)
	 * @see bluemoose.adal.ADALInterface#login(java.lang.String, java.lang.String)
	 */
	@Override
	public AuthUser login(String username, String password) {
		switch(username){
		case "admin":
		case "user":
			if(username.equals(password)){
				String compactJWS = Jwts.builder()
					.claim("username", username)
					.claim("fname", username)
					.claim("lname", "Lastname")
					.setExpiration(new Date(System.currentTimeMillis()+60*60*1000))
					.signWith(SignatureAlgorithm.HS512, key)
					.compact();
				return new AuthUserImpl(username,"Lastname",compactJWS);
			} else{
				return new AuthUserFailure(LoginResult.FAILURE);
			}
		case "expired":
			String compactJWS1 = Jwts.builder()
			.claim("username", username)
			.claim("fname", username)
			.claim("lname", "Explast")
			.setExpiration(new Date())
			.signWith(SignatureAlgorithm.HS512, key)
			.compact();
		return new AuthUserImpl(username,"Lastname",compactJWS1);
		default: return new AuthUserFailure(LoginResult.FAILURE);
		}
	}

	/* (non-Javadoc)
	 * @see bluemoose.adal.ADALInterface#checkToken(java.lang.String)
	 */
	@Override
	public AuthUser checkToken(String authToken) {
		try{
			Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(authToken).getBody();
			return new AuthUserImpl(claims.get("fname", String.class),claims.get("lname", String.class),authToken);
		}
		catch(ExpiredJwtException e){
			return new AuthUserFailure(LoginResult.EXPIRED);
		}
		catch(Exception e){
			return new AuthUserFailure(LoginResult.FAILURE);
		}
	}

}
