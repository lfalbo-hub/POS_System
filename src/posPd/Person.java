package posPd;

public class Person {

	private String name;
	@SuppressWarnings("unused")
	private String address;
	@SuppressWarnings("unused")
	private String city;
	@SuppressWarnings("unused")
	private String state;
	@SuppressWarnings("unused")
	private String zip;
	@SuppressWarnings("unused")
	private String phone;
	@SuppressWarnings("unused")
	private String sSN;
	private Cashier cashier;

	public Person() {
		name = "";
		address = "";
		city = "";
		state = "";
		zip = "";
		phone = "";
		sSN = "";
	}

	/**
	 * 
	 * @param name
	 * @param address
	 * @param phone
	 */
	public Person(String name, String address, String phone, 
			String city, String state, String zip, String sSN) {
		this();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.sSN = sSN;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the sSN
	 */
	public String getsSN() {
		return sSN;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @param sSN the sSN to set
	 */
	public void setsSN(String sSN) {
		this.sSN = sSN;
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

	public String toString() {
		return(name != null && !name.isEmpty()) ? name : "Unnamed Person";
	}

}