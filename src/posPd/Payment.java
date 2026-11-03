package posPd;

import java.math.BigDecimal;

public class Payment {

	private BigDecimal amount;
	private BigDecimal amtTendered;

	public Payment() {
		amount = BigDecimal.ZERO;
		amtTendered = BigDecimal.ZERO;
	}
	
	public Payment(BigDecimal amount, BigDecimal amtTendered) {
		this.amount = amount;
		this.amtTendered = amtTendered;
	}
	
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @return the amtTendered
	 */
	public BigDecimal getAmtTendered() {
		return amtTendered;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public void setAmtTendered(BigDecimal amtTendered) {
		this.amtTendered = amtTendered;
	}
	
	public Boolean countsAsCash() {
		return false;
	}

	public String toString() {
		return "Payment Amount: $" + amount + " | Tendered: $" + amtTendered;
	}
}