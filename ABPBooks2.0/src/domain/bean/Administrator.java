/**
 * 
 */
package domain.bean;

/**
 * @author Gary Chen, Nancy Dominguez
 *
 */
public class Administrator {
	private int id = 0;
	private String firstName = null;
	private String lastName = null;
	private String username = null;
	private String password = null;
	/**
	 * @param username
	 * @param password
	 */
	public Administrator(String username, String password) {
		//this.firstName = firstname;
		//this.lastName = lastname;
		this.username = username;
		this.password = password;
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
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstName;
	}
	/**
	 * @param username the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastName;
	}
	/**
	 * @param username the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastName = lastname;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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

}
