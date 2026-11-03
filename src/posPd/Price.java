package posPd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Price implements Comparable<Price>{
   
	private BigDecimal price;
	private LocalDate effectiveDate;
	@SuppressWarnings("unused")
	private Item item;

	public Price() {
		price = BigDecimal.ZERO;
		effectiveDate = LocalDate.now();
		item = null;
	}

	/**
	 * 
	 * @param price
	 * @param effectiveDate
	 */
	public Price(String price, String effectiveDate) {
		this();
		if(price != null && !price.trim().isEmpty()) {
			try {
				this.price = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);	
			} catch(NumberFormatException e) {
				this.price = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
			}
		}
		if(effectiveDate != null && !effectiveDate.trim().isEmpty()) {
			try {
				this.effectiveDate = LocalDate.parse(effectiveDate);	
			}
			catch(Exception e) {
				this.effectiveDate = LocalDate.now();
			}
		}
			
	}
	
	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setItem(Item item) {
		if(item != null) {
			this.item = item;	
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
		if(effectiveDate != null) {
			this.effectiveDate = effectiveDate;
		}
	}

	/**
	 * 
	 * @param date
	 */
	public Boolean isEffective(LocalDate date) {
		if(effectiveDate == null || date == null) {
			return false;
		}
		
		return !effectiveDate.isAfter(date);
	}

	/**
	 * 
	 * @param quantity
	 */
	public BigDecimal calcAmountForQty(int quantity) {
		if(price == null) {
			return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
		}
		return price.multiply(BigDecimal.valueOf(quantity)).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * 
	 * @param price
	 */
	public int compareTo(Price price) {
		if(price == null || price.getEffectiveDate() == null) {
			return 1;
		}
		
		if(this.effectiveDate == null) {
			return -1;
		}
		
		return this.effectiveDate.compareTo(price.getEffectiveDate());
	}

	public String toString() {
		
		return price + "";
	}

	public BigDecimal getPrice() {
		return price;
	}
}