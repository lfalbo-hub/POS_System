package posPd;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Item {

	private String number;
	private String description;
	private TaxCategory taxCategory;
	private Collection<SaleLineItem> saleLineItems;
	private Collection<Price> prices;
	private Collection<UPC> uPCs;

	public Item() {
		number = "";
		description = "";
		taxCategory = null;
		saleLineItems = new ArrayList<SaleLineItem>();
		prices = new ArrayList<Price>();
		uPCs = new ArrayList<UPC>();
	}

	/**
	 * 
	 * @param number
	 * @param description
	 */
	public Item(String number, String description) {
		this();
		this.number = number;
		this.description = description;
	}

	public String getKey() {
		return number;
	}

	/**
	 * @return the uPCs
	 */
	public Collection<UPC> getuPCs() {
		return uPCs;
	}

	/**
	 * @return the saleLineItems
	 */
	public Collection<SaleLineItem> getSaleLineItems() {
		return saleLineItems;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @param saleLineItems the saleLineItems to set
	 */
	public void setSaleLineItems(Collection<SaleLineItem> saleLineItems) {
		this.saleLineItems = saleLineItems;
	}

	/**
	 * @param uPCs the uPCs to set
	 */
	public void setuPCs(Collection<UPC> uPCs) {
		this.uPCs = uPCs;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the taxCategory
	 */
	public TaxCategory getTaxCategory() {
		return taxCategory;
	}

	/**
	 * @param taxCategory the taxCategory to set
	 */
	public void setTaxCategory(TaxCategory taxCategory) {
		this.taxCategory = taxCategory;
	}

	/**
	 * @return the prices
	 */
	public Collection<Price> getPrices() {
		return prices;
	}

	/**
	 * @param prices the prices to set
	 */
	public void setPrices(Collection<Price> prices) {
		this.prices = prices;
	}

	public String getNumber() {
		return number;
	}
	
	/**
	 * 
	 * @param price
	 */
	public void addPrice(Price price) {
		if(price != null) {
			prices.add(price);
			price.setItem(this);
		}
	}

	/**
	 * 
	 * @param price
	 */
	public void removePrice(Price price) {
		prices.remove(price);
	}

	/**
	 * 
	 * @param upc
	 */
	public void addUPC(UPC upc) {
		if(upc != null) {
			uPCs.add(upc);
			upc.setItem(this);
		}
	}

	/**
	 * 
	 * @param upc
	 */
	public void removeUPC(UPC upc) {
		uPCs.remove(upc);
	}

	/**
	 * 
	 * @param saleLineItem
	 */
	public void addSaleLineItem(SaleLineItem saleLineItem) {
		if(saleLineItem != null) {
			saleLineItems.add(saleLineItem);
			saleLineItem.setItem(this);
		}
	}

	/**
	 * 
	 * @param saleLineItem
	 */
	public void removeSaleLineItem(SaleLineItem saleLineItem) {
		saleLineItems.remove(saleLineItem);
	}

	/**
	 * 
	 * @param date
	 */
	public Price getPriceForDate(LocalDate date) {
		Price activePrice = null;
		
		for(Price p : prices) {
			if(p != null && p.isEffective(date)) {
				if(p instanceof PromoPrice) {
					if(activePrice == null || !(activePrice instanceof PromoPrice)
							|| (p.getEffectiveDate() != null && activePrice.getEffectiveDate() != null
							&& p.getEffectiveDate().isAfter(activePrice.getEffectiveDate()))) {
						activePrice = p;
					}
				}
				else if(!(activePrice instanceof PromoPrice)) {
				    if(activePrice == null || (p.getEffectiveDate() != null && activePrice.getEffectiveDate() != null 
				    		&& p.getEffectiveDate().isAfter(activePrice.getEffectiveDate()))) {
				        activePrice = p;
				    }
				}
			}
		}
		
		return activePrice;
	}

	/**
	 * 
	 * @param date
	 */
	public BigDecimal getTaxRateForDate(LocalDate date) {
		if(taxCategory == null)
			return BigDecimal.ZERO;
		
		BigDecimal rate = taxCategory.getTaxRateForDate(date);
		return (rate != null) ? rate : BigDecimal.ZERO;
	}

	/**
	 * 
	 * @param date
	 * @param quantity
	 */
	public BigDecimal calcAmountForDateQty(LocalDate date, int quantity) {
		Price price = getPriceForDate(date);
		
		if(price != null) {
			return price.calcAmountForQty(quantity);
		}
		
		return BigDecimal.ZERO;
	}

	public BigDecimal calcTaxForDateQty(LocalDate date, int quantity) {
		BigDecimal amount = calcAmountForDateQty(date, quantity);
		BigDecimal taxRate = getTaxRateForDate(date);
		
		if (amount == null || taxRate == null) {
			return BigDecimal.ZERO;
		}
		
		return amount.multiply(taxRate);
	}
	
	public String toString() {
		String returnStr = "";
		
		returnStr += "Number: " + number + "\nDescription: " + description;
		returnStr += "\nTaxCategory: " + taxCategory;
		
		return returnStr;
	}

	

}