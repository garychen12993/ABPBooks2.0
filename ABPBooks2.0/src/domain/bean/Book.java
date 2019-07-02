package domain.bean;
/**
 * @author Gary Chen, Nancy Dominguez
 *
 */
public class Book {
	// define private attributes
	private int count = 0;
	private String ABPID = null;
	private String title = null;
	private String edition = null;
	private String authors = null;
	private String ISBN = null;
	private String subject = null;
	private int isAvailable = 0;
	private int status = 0;
	private int numRequests = 0;
	
	/*public int getDish_amount() {
		return dish_amount;
	}

	public void setDish_amount(int dish_amount) {
		this.dish_amount = dish_amount;
	}*/

	public Book() {}
	
	//Get functions
	public int getCount() {
		return count;
	}
	public String getABPID() {
		return ABPID;
	}
	public String getTitle() {
		return title;
	}
	public String getEdition() {
		return edition;
	}
	public String getAuthors() {
		return authors;
	}
	public String getISBN() {
		return ISBN;
	}
	public String getSubject() {
		return subject;
	}
	public int getAvailability() {
		return isAvailable;
	}
	public int getStatus() {
		return status;
	}
	public int getNumRequests() {
		return numRequests;
	}
	
	//Set functions
	public void setCount(int count) {
		this.count = count;
	}
	public void setABPID(String ABPID) {
		this.ABPID = ABPID;
	}
	public void setTitle(String bookname) {
		this.title = bookname;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setAvailability(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setNumRequests(int numRequests) {
		this.numRequests = numRequests;
	}
}
