package bluemoose.translators.web;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponseJSON {
	@JsonProperty
	public String status = "SUCCESS";
	@JsonProperty
	public String authentication;
	@JsonProperty
	public String fname;
	@JsonProperty
	public String lname;
	public LoginResponseJSON(String authentication, String fname, String lname) {
		this.authentication = authentication;
		this.fname = fname;
		this.lname = lname;
	}
}
