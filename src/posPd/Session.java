package posPd;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Session {

	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private Cashier cashier;
	private Register register;
	private Collection<Sale> sales;

	public Session() {
		startDateTime = LocalDateTime.now();
		endDateTime = null;
		cashier = null;
		register = null;
		sales = new ArrayList<Sale>();	
	}

	/**
	 * 
	 * @param cashier
	 * @param register
	 */
	public Session(Cashier cashier, Register register) {
		this();
		this.cashier = cashier;
		this.register = register;
		if(cashier != null) {
			cashier.addSession(this);
		}
	}

	/**
	 * @return the startDateTime
	 */
	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	/**
	 * @param startDateTime the startDateTime to set
	 */
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	/**
	 * @return the endDateTime
	 */
	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	/**
	 * @param endDateTime the endDateTime to set
	 */
	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	/**
	 * @return the cashier
	 */
	public Cashier getCashier() {
		return cashier;
	}
	
	/**
	 * @param cashier the cashier to set
	 */
	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}
	
	/**
	 * @return the register
	 */
	public Register getRegister() {
		return register;
	}

	/**
	 * @param register the register to set
	 */
	public void setRegister(Register register) {
		this.register = register;
	}
	
	/**
	 * @return the sales
	 */
	public Collection<Sale> getSales() {
		return sales;
	}

	/**
	 * @param sales the sales to set
	 */
	public void setSales(Collection<Sale> sales) {
		this.sales = sales;
	}
	
	/**
	 * 
	 * @param sale
	 */
	public void addSale(Sale sale) {
		if(sale != null) {
			sales.add(sale);
			sale.setSession(this);
		}
	}

	/**
	 * 
	 * @param sale
	 */
	public void removeSale(Sale sale) {
		if(sale != null) {
			sales.remove(sale);
			sale.setSession(null);
		}
	}

	public Object getKey() {
		String cashierKey = (cashier != null && cashier.getKey() != null) ? cashier.getKey() : "UNKNOWN";
		return cashierKey + ":" + startDateTime;
	}
	
	/**
	 * 
	 * @param cash
	 */
	public BigDecimal calcCashCountDiff(BigDecimal cash) {
		BigDecimal expectedCash = calcTotal();
		if (cash == null) {
			return BigDecimal.ZERO;
		}
		
		return cash.subtract(expectedCash);
	}

	public BigDecimal calcTotal() {
		BigDecimal total = BigDecimal.ZERO;
		
		if(sales != null) {
			for(Sale sale : sales) {
				if(sale != null && sale.calcTotal() != null) {
					total = total.add(sale.calcTotal());
				}
			}
		}
		
		return total;
	}

	public String toString() {

		String cashierName = (cashier != null && cashier.getPerson() != null) ? cashier.getPerson().getName() : "";
	    String registerNum = (register != null) ? register.getNumber() : "";

	    return "Session: Cashier: " + cashierName 
	         + ", Register: " + registerNum 
	         + ", Date: " + startDateTime 
	         + ", Total: " + calcTotal();
	}
	
}