package br.com.capco.security.vo;

public class TokenVo {

	private String token; 
	
	public TokenVo() {
	}
	
	public TokenVo(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
