package posPd;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class TaxCategory {

	private String category;
	private Collection<Item> items;
	private Collection<TaxRate> taxRates;

	public TaxCategory() {
		category = "Default";
		items = new ArrayList<Item>();
		taxRates = new ArrayList<TaxRate>();
	}

	/**
	 * 
	 * @param category
	 */
	public TaxCategory(String category) {
		this();
		this.category = category;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return the items
	 */
	public Collection<Item> getItems() {
		return items;
	}

	/**
	 * @return the taxRates
	 */
	public Collection<TaxRate> getTaxRates() {
		return taxRates;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Collection<Item> items) {
		this.items = items;
	}

	/**
	 * @param taxRates the taxRates to set
	 */
	public void setTaxRates(Collection<TaxRate> taxRates) {
		this.taxRates = taxRates;
	}
	
	/**
	 * 
	 * @param date
	 */
	public BigDecimal getTaxRateForDate(LocalDate date) {
		TaxRate activeRate = null;

		if(date == null || taxRates == null) {
			return BigDecimal.ZERO;
		}
		
		for (TaxRate tr : taxRates) {
			if (tr != null && tr.isEffective(date)) {
				if (activeRate == null || tr.compareTo(activeRate) > 0) {
					activeRate = tr;
				}
			}
		}

		if (activeRate != null && activeRate.getTaxRate() != null) {
			return activeRate.getTaxRate();
		}

		return BigDecimal.ZERO;
	}

	/**
	 * 
	 * @param taxRate
	 */
	public void addTaxRate(TaxRate taxRate) {
		if(taxRate != null) {
			taxRates.add(taxRate);	
		}
	}

	/**
	 * 
	 * @param taxRate
	 */
	public void removeTaxRate(TaxRate taxRate) {
		if(taxRate != null) {
			taxRates.remove(taxRate);
		}
	}

	public void addItem(Item item) {
		if(item != null) {
			items.add(item);
		}
	}
	
	public void removeItem(Item item) {
		if(item != null) {
			items.remove(item);
		}
	}
	
 	public String getKey() {
		return category;
	}
	
	public String toString() {
		return category;
	}
}