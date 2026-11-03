package posPd;

import java.math.BigDecimal;

public class Cash extends Payment {

	public Cash() {
		super();
	}

	/**
	 * 
	 * @param amount
	 * @param amtTendered
	 */
	public Cash(String amount, String amtTendered) {
		super(new BigDecimal(amount), new BigDecimal(amtTendered));
	}

	/**
	 * 
	 * @param amount
	 * @param amtTendered
	 */
	public Cash(BigDecimal amount, BigDecimal amtTendered) {
		super(amount, amtTendered);
	}

	public Boolean countsAsCash() {
		return true;
	}

	public String toString() {
		
		return "Cash Payment";
	}
}