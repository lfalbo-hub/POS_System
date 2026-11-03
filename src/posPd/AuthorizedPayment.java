package posPd;

import java.math.BigDecimal;

public class AuthorizedPayment extends Payment {

	private String authorizationCode;

	public AuthorizedPayment() {
		super();
		authorizationCode = "";
	}
	
	public AuthorizedPayment(String amount, BigDecimal amtTendered) {
		super(new BigDecimal(amount), amtTendered);
		authorizationCode = "";
	}
	
	/**
	 * @return the authorizationCode
	 */
	public String getAuthorizationCode() {
		return authorizationCode;
	}

	/**
	 * @param authorizationCode the authorizationCode to set
	 */
	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public Boolean isAuthorized() {
		Boolean isAuthorized = false;
		
		if(authorizationCode != null && !authorizationCode.trim().isEmpty()) {
			isAuthorized = true;
		}
		
		return isAuthorized;
	}

	public Boolean countsAsCash() {
		return false;
	}
	
	public String toString() {
		return "Authorized Payment | Auth Code: " + authorizationCode;
	}
}