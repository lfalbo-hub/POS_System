package posPd;

import java.math.BigDecimal;

public class CashDrawer {

	private BigDecimal cashAmount;
	@SuppressWarnings("unused")
	private int position;

	public CashDrawer() {
		cashAmount = BigDecimal.ZERO;
		position = 0;
	}

	/**
	 * @return the cashAmount
	 */
	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	/**
	 * @param cashAmount the cashAmount to set
	 */
	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	/**
	 * 
	 * @param cash
	 */
	public void removeCash(BigDecimal cash) {
		if(cash != null) {
		cashAmount.subtract(cash);
		}
	}
		
	/**
	 * 
	 * @param cash
	 */
	public void addCash(BigDecimal cash) {
		if(cash != null) {
		cashAmount.add(cash);
		}
	}

	public String toString() {
		return cashAmount + "";
	}
}