package posPd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;

public class Sale {

	private LocalDateTime dateTime;
	private Boolean taxFree;
	private Session session;
	private Collection<Payment> payments;
	private Collection<SaleLineItem> saleLineItems;

	public Sale() {
		dateTime = LocalDateTime.now();
		taxFree = false;
		session = null;
		payments = new ArrayList<Payment>();
		saleLineItems = new ArrayList<SaleLineItem>();
	}

	/**
	 * 
	 * @param taxFree
	 */
	public Sale(String taxFree) {
		this();
		this.taxFree = Boolean.parseBoolean(taxFree) 
					|| "yes".equalsIgnoreCase(taxFree)
					|| "y".equalsIgnoreCase(taxFree);
	}
	
	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
			this.session = session;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * @return the taxFree
	 */
	public Boolean getTaxFree() {
		return taxFree;
	}
	
	/**
	 * @param taxFree the taxFree to set
	 */
	public void setTaxFree(Boolean taxFree) {
		this.taxFree = taxFree;
	}

	/**
	 * @return the payments
	 */
	public Collection<Payment> getPayments() {
		return payments;
	}

	/**
	 * @param payments the payments to set
	 */
	public void setPayments(Collection<Payment> payments) {
		this.payments = payments;
	}

	/**
	 * @return the saleLineItems
	 */
	public Collection<SaleLineItem> getSaleLineItems() {
		return saleLineItems;
	}

	/**
	 * @param saleLineItems the saleLineItems to set
	 */
	public void setSaleLineItems(Collection<SaleLineItem> saleLineItems) {
		this.saleLineItems = saleLineItems;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * 
	 * @param payment
	 */
	public void addPayment(Payment payment) {
		if(payment != null) {
			payments.add(payment);
		}
	}

	/**
	 * 
	 * @param payment
	 */
	public void removePayment(Payment payment) {
		if(payment != null) {
			payments.remove(payment);
		}
	}

	/**
	 * 
	 * @param sli
	 */
	public void addSaleLineItem(SaleLineItem sli) {
		if(sli != null) {
			saleLineItems.add(sli);
			sli.setSale(this);
		}
	}

	/**
	 * 
	 * @param sli
	 */
	public void removeSaleLineItem(SaleLineItem sli) {
		if(sli != null) {
			saleLineItems.remove(sli);
			sli.setSale(null);
		}
	}

	public BigDecimal calcSubTotal() {
		BigDecimal subTotal = BigDecimal.ZERO;
		
		if(saleLineItems != null) {
			for(SaleLineItem sli : saleLineItems) {
				if(sli != null && sli.calcSubTotal() != null) {
					subTotal = subTotal.add(sli.calcSubTotal());
				}
			}
		}
		
		return subTotal.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal calcTax() {
		if(Boolean.TRUE.equals(taxFree)) {
			return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
		}
		
		BigDecimal totalTax = BigDecimal.ZERO;
		if(saleLineItems != null) {
			for(SaleLineItem sli : saleLineItems) {
				if (sli != null && sli.calcTax() != null) {
					totalTax = totalTax.add(sli.calcTax());
				}
			}
		}
		
		return totalTax.setScale(2, java.math.RoundingMode.HALF_UP);
	}

	public BigDecimal calcTotal() {
		return calcSubTotal().add(calcTax()).setScale(2, java.math.RoundingMode.HALF_UP);
	}
	
	public BigDecimal calcAmtTendered() {
		BigDecimal totalTendered = BigDecimal.ZERO;
		
		if(payments != null) {
			for(Payment payment : payments) {
				if(payment != null && payment.getAmtTendered() != null) {
					totalTendered = totalTendered.add(payment.getAmtTendered());
				}
			}
		}
		return totalTendered.setScale(2, RoundingMode.HALF_UP);
	}

	public Boolean isPaymentEnough() {
	    return calcAmtTendered().compareTo(calcTotal()) >= 0;
	}

	public BigDecimal calcChange() {
		if(!isPaymentEnough()) {
			return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
		}
	    return calcAmtTendered().subtract(calcTotal()).setScale(2, RoundingMode.HALF_UP);
	}

	public String getKey() {
		return (dateTime != null) ? dateTime.toString() : "";
	}
	
	public String toString() {
		return "Sale: SubTotal = " + calcSubTotal() 
        + " Tax = " + calcTax() 
        + " Total = " + calcTotal() 
        + " Tendered = " + calcAmtTendered() 
        + " Change = " + calcChange();
	}
}