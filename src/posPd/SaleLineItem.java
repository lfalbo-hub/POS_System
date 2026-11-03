package posPd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class SaleLineItem {

	private String quantity;
	private Sale sale;
	private Item item;

	public SaleLineItem() {
		quantity = "";
		sale = null;
		item = null;
	}

	/**
	 * 
	 * @param sale
	 * @param item
	 * @param quantity
	 */
	public SaleLineItem(Sale sale, Item item, String quantity) {
		this();
		this.sale = sale;
		this.item = item;
		if(quantity != null && !quantity.trim().isEmpty()) {
			this.quantity = quantity;
		}
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		if(item != null) {
			this.item = item;
		}
	}
	
	public void setSale(Sale sale) {
		if(sale != null) {
			this.sale = sale;
		}
	}
	
	public BigDecimal calcSubTotal() {
		if(sale == null || item == null || quantity == null || sale.getDateTime() == null) {
			return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
		}
		
		int totalQty = 0;
		
		try {
			totalQty =  Integer.parseInt(quantity.trim());
		} catch(Exception e) {
			return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
		}
		
		LocalDate date = sale.getDateTime().toLocalDate();
		BigDecimal subTotal = item.calcAmountForDateQty(date, totalQty);
		
		return (subTotal != null) ? subTotal.setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
		
	}

	public BigDecimal calcTax() {
		if(sale == null || item == null || quantity == null || sale.getDateTime() == null) {
			return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
		}
		
		LocalDate date = sale.getDateTime().toLocalDate();
		BigDecimal subTotal = calcSubTotal();
		BigDecimal taxRate = item.getTaxRateForDate(date);
		
		if(taxRate == null) {
			return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
		}
		
		return subTotal.multiply(taxRate).setScale(2, RoundingMode.HALF_UP);
		
	}

	public String toString() {
		
		    String itemNum = (item != null) ? item.getNumber() : "";
		    String desc = (item != null) ? item.getDescription() : "";
		    
		    Price price = item.getPriceForDate(LocalDate.now());
		    
		    String taxRateStr = "0.00";
		    if (item != null && item.getTaxCategory() != null) {
		        TaxRate tr = new TaxRate();
		        tr.setTaxRate(item.getTaxCategory().getTaxRateForDate(LocalDate.now()));
		        if (tr != null && tr.getTaxRate() != null) {
		            taxRateStr = tr.getTaxRate().toString();
		        }
		    }

		    return itemNum + " " + desc + " " + quantity + " @ $" + price + " Tax Rate: " + taxRateStr;
		
	}
}