package posPd;

public class UPC {

	private String uPC;
	private Item item;

	public UPC() {
		uPC = "";
		item = null;
	}
	
	/**
	 * 
	 * @param upc barcode string
	 */
	public UPC(String upc) {
		this();
		if (upc != null) {
			this.uPC = upc.trim();
		}
	}
	
	/**
	 * @param uPC
	 * @param item
	 */
	public UPC(String uPC, Item item) {
		this(uPC);
		this.item = item;
	}
	

	/**
	 * @return the uPC
	 */
	public String getuPC() {
		return uPC;
	}

	/**
	 * @param uPC the uPC to set
	 */
	public void setuPC(String uPC) {
		if(uPC != null) {
			this.uPC = uPC;
		}
		else {
			this.uPC = "";
		}
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public String getKey() {
		return uPC;
	}
	
	public String toString() {
		return uPC;
	}
}