package domain.bean;

public class CartItem {
	private String student_id = null;
	private String ABPID = null;
	private String title = null;
	private String edition = null;
	private String authors = null;
	private String ISBN = null;
	private String subject = null;
			
	public CartItem(String student_id, String ABPID, String title , String edition, String authors, String ISBN, String subject) {
		this.student_id = student_id;
		this.ABPID = ABPID;
		this.title = title;
		this.edition = edition;
		this.authors = authors;
		this.ISBN = ISBN;
		this.subject = subject;
	}
	
	public String getStudentID() {
		return student_id;
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
}


