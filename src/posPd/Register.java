package posPd;

public class Register {

	private String number;
	private Session session;
	private CashDrawer cashDrawer;

	public Register() {
		number = "";
		session = null;
		cashDrawer = new CashDrawer();
	}

	/**
	 * 
	 * @param number
	 */
	public Register(String number) {
		this();
		if(number != null) {
			this.number = number;	
		}
	}
	
	public String getNumber() {
		return number;
	}
	
	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @return the cashDrawer
	 */
	public CashDrawer getCashDrawer() {
		return cashDrawer;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = (number != null) ? number : "";
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	/**
	 * @param cashDrawer the cashDrawer to set
	 */
	public void setCashDrawer(CashDrawer cashDrawer) {
		this.cashDrawer = cashDrawer;
	}

	public String getKey() {
		return (number != null) ? number : "";
	}

	public String toString() {
		
	
		return number;
	}
}