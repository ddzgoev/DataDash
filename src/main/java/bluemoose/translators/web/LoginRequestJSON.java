package bluemoose.translators.web;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequestJSON {
	@JsonProperty
	public String username;
	@JsonProperty
	public String password;
}
