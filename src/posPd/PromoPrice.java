package posPd;

import java.time.LocalDate;

public class PromoPrice extends Price {

	private LocalDate endDate;

	public PromoPrice() {
		super();
	}

	/**
	 * 
	 * @param priceString
	 * @param effectiveDate
	 * @param endDate
	 */
	public PromoPrice(String priceString, String effectiveDate, String endDate) {
		super(priceString, effectiveDate);
		if(endDate != null && endDate.trim().isEmpty()) {
			try {
				this.endDate = LocalDate.parse(endDate);
			} catch(Exception e) {
				this.endDate = null;
			}
		}
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * 
	 * @param date
	 */
	public Boolean isEffective(LocalDate date) {
		if(date == null || endDate == null) {
			return false;
		}
		return super.isEffective(date) && !date.isAfter(endDate);
	}

	public String toString() {
		return super.toString();
		/*+ "\nPromo Start Date: " + ((super.getEffectiveDate() != null) ? super.getEffectiveDate() : "N/a")
				+ "\nPromo Price: $" + super.getPrice() + "\n"
				+ "Promo End Date: " + ((endDate != null) ? endDate : "N/A");*/
	}
}