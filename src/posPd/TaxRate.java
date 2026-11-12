package posPd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Domain class representing a tax rate and its effective starting date.
 * Implements Comparable to allow chronological sorting of rates.
 */
public class TaxRate implements Comparable<TaxRate> {

	private BigDecimal taxRate;
	private LocalDate effectiveDate;

	public TaxRate() {
		effectiveDate = LocalDate.now();
		taxRate = BigDecimal.ZERO;
	}

	/**
	 * 
	 * @param effectiveDate
	 * @param rate
	 */
	public TaxRate(LocalDate effectiveDate, BigDecimal rate) {
		if(effectiveDate != null) {
			this.effectiveDate = effectiveDate;
		}
		if(rate != null) {
			this.taxRate = rate;	
		}
	}
	
	public TaxRate(String effectiveDate, String taxRate) {
		this();

		if (effectiveDate != null && !effectiveDate.trim().isEmpty()) {
			try {
				this.effectiveDate = LocalDate.parse(effectiveDate.trim());
			} catch (Exception e) {
				this.effectiveDate = LocalDate.now();
			}
		}

		if (taxRate != null && !taxRate.trim().isEmpty()) {
			try {
				this.taxRate = new BigDecimal(taxRate.trim()).setScale(2, RoundingMode.HALF_UP);
			} catch (NumberFormatException e) {
				this.taxRate = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
			}
		}
	}

	/**
	 * @return the effectiveDate
	 */
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("M/d/yyyy"));
		
		//this.effectiveDate = LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("yyyy/M/d"));
	}
	/**
	 * @param taxRate the taxRate to set
	 */
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}
	
	/**
	 * 
	 * @param date
	 */
	public boolean isEffective(LocalDate date) {
		if(effectiveDate == null || date == null) {
			return false;
		}
		
		return !date.isBefore(effectiveDate);
	}

	/**
	 * 
	 * @param taxRate
	 */
	public int compareTo(TaxRate taxRate) {
		if(taxRate == null || taxRate.getTaxRate() == null) {
			return 1;			
		}
		if(this.effectiveDate == null) {
			return -1;
		}
		
		return this.effectiveDate.compareTo(taxRate.effectiveDate);
	}

	public String getKey() {
		return (effectiveDate != null) ? effectiveDate.toString() : "";
	}
	
	public String toString() {
		//return "Tax Rate: " + taxRate +	" | Effective Date: " + effectiveDate;
		String output = taxRate.toString();
		return output;
	}
}