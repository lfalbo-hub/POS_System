package posPd;

import java.util.*;
import PosDM.StoreDM;

public class Store {

	private String number;
	private String name;
	private TreeMap<String, Register> registers;
	private TreeMap<String, Cashier> cashiers;
	private ArrayList<Session> sessions;
	private TreeMap<String, TaxCategory> taxCategories;
	private TreeMap<String, Item> items;
	private TreeMap<String, UPC> upcs;

	public Store() {
		number = "";
		name = "";
		taxCategories = new TreeMap<String, TaxCategory>();
		registers = new TreeMap<String, Register>();
		cashiers = new TreeMap<String, Cashier>();
		items = new TreeMap<String, Item>();
		upcs = new TreeMap<String, UPC>();
		sessions = new ArrayList<Session>();
	}

	/**
	 * 
	 * @param number
	 * @param name
	 */
	public Store(String name, String number) {
		this();
		this.name = (name != null) ? name : "";
		this.number = (number != null) ? number : "";
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the registers
	 */
	public TreeMap<String, Register> getRegisters() {
		return registers;
	}

	/**
	 * @param registers the registers to set
	 */
	public void setRegisters(TreeMap<String, Register> registers) {
		this.registers = registers;
	}

	/**
	 * @return the cashiers
	 */
	public TreeMap<String, Cashier> getCashiers() {
		return cashiers;
	}
	
	
	/**
	 * @param cashiers the cashiers to set
	 */
	public void setCashiers(TreeMap<String, Cashier> cashiers) {
		this.cashiers = cashiers;
	}

	/**
	 * @return the sessions
	 */
	public ArrayList<Session> getSessions() {
		return sessions;
	}
	
	/**
	 * @param sessions the sessions to set
	 */
	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}
	
	/**
	 * @return the taxCategories
	 */
	public TreeMap<String, TaxCategory> getTaxCategories() {
		return taxCategories;
	}

	/**
	 * @param taxCategories the taxCategories to set
	 */
	public void setTaxCategories(TreeMap<String, TaxCategory> taxCategories) {
		this.taxCategories = taxCategories;
	}

	/**
	 * @return the items
	 */
	public TreeMap<String, Item> getItems() {
		return items;
	}
	
	/**
	 * @param items the items to set
	 */
	public void setItems(TreeMap<String, Item> items) {
		this.items = items;
	}
	
	/**
	 * @return the upcs
	 */
	public TreeMap<String, UPC> getUpcs() {
		return upcs;
	}
	
	/**
	 * @param upcs the upcs to set
	 */
	public void setUpcs(TreeMap<String, UPC> upcs) {
		this.upcs = upcs;
	}
	
	/**
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		if(item != null && item.getKey() != null)
			items.put(item.getKey(), item);
	}

	/**
	 * 
	 * @param item
	 */
	public void removeItem(Item item) {
		if(item != null && item.getKey() != null) {
			items.remove(item.getKey());
		}
	}

	/**
	 * 
	 * @param upc
	 */
	public void addUPC(UPC upc) {
		if(upc != null && upc.getKey() != null)
			upcs.put(upc.getKey(), upc);
	}

	/**
	 * 
	 * @param upc
	 */
	public void removeUPC(UPC upc) {
		if(upc != null && upc.getKey() != null) {
			upcs.remove(upc.getKey(), upc);
		}
	}

	/**
	 * 
	 * @param register
	 */
	public void addRegister(Register register) {
		if(register != null && register.getKey() != null) {
			registers.put(register.getKey(), register);
		}
	}

	/**
	 * 
	 * @param register
	 */
	public void removeRegister(Register register) {
		if(register != null && register.getKey() != null) {
			registers.remove(register.getKey(), register);
		}
	}

	/**
	 * 
	 * @param cashier
	 */
	public void addCashier(Cashier cashier) {
		if(cashier != null && cashier.getKey() != null) {
			cashiers.put(cashier.getKey(), cashier);
		}
	}

	/**
	 * 
	 * @param cashier
	 */
	public void removeCashier(Cashier cashier) {
		if(cashier != null && cashier.getKey() != null) {
			cashiers.remove(cashier.getKey(), cashier);
		}
	}

	/**
	 * 
	 * @param taxCategory
	 */
	public void addTaxCategory(TaxCategory taxCategory) {
		if(taxCategory != null && taxCategory.getKey() != null) {
			taxCategories.put(taxCategory.getKey(), taxCategory);
		}
	}

	/**
	 * 
	 * @param taxCategory
	 */
	public void removeTaxCategory(TaxCategory taxCategory) {
		if(taxCategories != null && taxCategory.getKey() != null) {
			taxCategories.remove(taxCategory.getKey(), taxCategory);
		}
	}

	/**
	 * 
	 * @param session
	 */
	public void addSession(Session session) {
		if(session != null) {
			sessions.add(session);
		}
	}

	/**
	 * 
	 * @param session
	 */
	public void removeSession(Session session) {
		if(session != null) {
			sessions.remove(session);
		}
	}

	/**
	 * 
	 * @param number
	 */
	public Register findRegisterByNumber(String number) {
		if(number == null) {
			return null;
		}
		
		return registers.get(number);
	}

	/**
	 * 
	 * @param upc
	 */
	public Item findItemForUPC(UPC upc) {
		UPC storeUpc;
		if(upc == null) {
			return null;
		}
		
		if(upc.getItem() != null) {
			return upc.getItem();
		}
		
		storeUpc = upcs.get(upc.getKey());
		return (storeUpc != null) ? storeUpc.getItem() : null;
	}

	/**
	 * Overloaded convenience lookup to find an Item directly by raw UPC barcode string.
	 * 
	 * @param upcCode barcode string
	 * @return Item instance or null if not found
	 */
	public Item findItemForUPC(String upcCode) {
		if (upcCode == null) {
			return null;
		}
		UPC storeUpc = upcs.get(upcCode);
		return (storeUpc != null) ? storeUpc.getItem() : null;
	}
	
	/**
	 * 
	 * @param number
	 */
	public Item findItemForNumber(String number) {
		if (number == null){
			return null;
		}
		return items.get(number);
	}

	/**
	 * 
	 * @param number
	 */
	public Cashier findCashierForNumber(String number) {
		if(number == null) {
			return null;
		}
		return cashiers.get(number);
	}

	/**
	 * 
	 * @param category
	 */
	public TaxCategory findTaxCategoryByName(String category) {
		if(category == null) {
			return null;
		}
		return taxCategories.get(category);
	}

	public boolean isTaxCategoryUsed(TaxCategory taxCategory) {
		boolean isUsed = false;
		
		for(Item anItem : getItems().values()) {
			TaxCategory aTaxCategory = anItem.getTaxCategory();
			if(taxCategory.getCategory().compareTo(aTaxCategory.getCategory()) == 0) {
				isUsed = true;
				break;
			}
		}
		
		return isUsed;
	}
	
	public void openStore() {
		StoreDM.loadStore(this);
	}
	
	public String toString() {

		return "Store #: " + getNumber() + ", name: " + getName();
		
	}

}