package posPd;

import java.util.*;

public class Cashier {

	private String number;
	private String password;
	private Person person;
	private Collection<Session> sessions;

	public Cashier() {
		number = "";
		password = "";
		person = null;
		sessions = new ArrayList<Session>();
	}

	/**
	 * 
	 * @param number
	 * @param person
	 * @param password
	 */
	public Cashier(String number, Person person, String password) {
		this();
		if(number != null) {
			this.number = number;	
		}
		if(person != null) {
			this.person = person;	
		}
		if(password != null) {
			this.password = password;	
		}
	}

	public String getKey() {
		return (number != null) ? number : "";
	}
	
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @return the sessions
	 */
	public Collection<Session> getSessions() {
		return sessions;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = (number != null) ? number : "";
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = (password != null) ? password : "";
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @param sessions the sessions to set
	 */
	public void setSessions(Collection<Session> sessions) {
		this.sessions = sessions;
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
	 * @param password
	 */
	public Boolean isAuthorized(String password) {
		if(password == null || this.password == null) {
			return false;
		}
		return this.password.equals(password);
	}

	public String toString() {
		String personStr = (person != null) ? person.toString() : "No Person Assigned";
		return personStr;
	}
}