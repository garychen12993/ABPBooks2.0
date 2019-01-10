/**
 * 
 */
package domain.bean;

/**
 * @author Gary Chen, Nancy Dominguez
 *
 */
public class Student {
	private int id = 0;
	private String email = null;
	private String password = null;
	private String firstName = null;
	private String lastName = null;
	private String address = null;
	private String phone = null;
	private int bridgeYear = 0;
	private String major = null;
	private int flagged = 0;

	/**
	 * @param email
	 * @param password
	 */
	public Student(String email, String password, String firstName, String lastName, String address, String phone, int bridgeYear, String major, int flagged) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.bridgeYear = bridgeYear;
		this.major = major;
		this.flagged = flagged;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param lastName the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * @return the bridgeYear
	 */
	public int getBridgeYear() {
		return bridgeYear;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setBridgeYear(int bridgeYear) {
		this.bridgeYear = bridgeYear;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	
	/**
	 * @return the flagged
	 */
	public int getFlagged() {
		return flagged;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setFlagged(int flagged) {
		this.flagged = flagged;
	}
}
