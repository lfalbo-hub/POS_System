package posPd;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Credit extends AuthorizedPayment {

	private String cardType;
	private String acctNumber;
	private LocalDate expireDate;

	public Credit() {
		super();
		cardType = "";
		acctNumber = "";
		expireDate = LocalDate.now().plusYears(1);
	}

	/**
	 * 
	 * @param amount
	 * @param cardType
	 * @param acctNumber
	 * @param expireDate
	 */
	public Credit(String amount, String cardType, String acctNumber, String expireDate) {
		
		super(amount, new BigDecimal(amount));
		
		this.cardType = cardType;
		this.acctNumber = acctNumber;
		this.expireDate = parseExpireDate(expireDate);
		
	}
	
	private LocalDate parseExpireDate(String expDateStr) {
		if (expDateStr == null || expDateStr.trim().isEmpty()) {
			return LocalDate.now();
		}
		try {
			if (expDateStr.contains("/")) {
				String[] parts = expDateStr.split("/");
				int month = Integer.parseInt(parts[0].trim());
				int year = Integer.parseInt(parts[1].trim());
				if (year < 100) year += 2000;
				return LocalDate.of(year, month, 1).plusMonths(1).minusDays(1);
			}
			return LocalDate.parse(expDateStr);
		} catch (Exception e) {
			return LocalDate.now();
		}
	}

	public Boolean isAuthorized() {
		Boolean isAuthorized = false;
		
		if(super.isAuthorized() && expireDate != null && !expireDate.isBefore(LocalDate.now())) {
			isAuthorized = true;
		}
		
		return isAuthorized;
	}

	public String toString() {
		String output = "";
		
		output += "Credit Card: " + cardType 
				+ " | Acct: " + acctNumber 
				+ " | Exp: " + expireDate;
	
		return output;
	}

}