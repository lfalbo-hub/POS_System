package posPd;

import java.math.BigDecimal;

public class Check extends AuthorizedPayment {

	@SuppressWarnings("unused")
	private String routingNumber;
	private String accountNumber;
	@SuppressWarnings("unused")
	private String checkNumber;

	public Check() {
		routingNumber = "";
		accountNumber = "";
		checkNumber = "";
	}

	/**
	 * 
	 * @param amount
	 * @param accountNumber
	 */
	public Check(String amount, String accountNumber, String routingNumber, String checkNumber) {
		super(amount, new BigDecimal(amount));
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.checkNumber = checkNumber;
	}

	public Boolean isAuthorized() {
		if (super.isAuthorized()) {
			return true;
		}
		return accountNumber != null && !accountNumber.trim().isEmpty()
				&& routingNumber != null && !routingNumber.trim().isEmpty() 
				&& checkNumber != null && !checkNumber.trim().isEmpty();
	}

	public String toString() {
		return "Check #: " + checkNumber;
	}

}