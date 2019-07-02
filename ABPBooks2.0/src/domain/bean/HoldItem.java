package domain.bean;

import java.util.*;
import java.util.LinkedList;

public class HoldItem {
	private String student_id = null;
	private String ABPID = null;
	private String title = null;
	private String edition = null;
	private String authors = null;
	private String ISBN = null;
	private String subject = null;
	
	private LinkedList<Book> book = new LinkedList<>(); //??
	private int queue = 0;
	private String endDate = null;

	public HoldItem(String student_id, String ABPID, String title , String edition, String authors, String ISBN, String subject, int queue) {
		this.student_id = student_id;
		this.ABPID = ABPID;
		this.title = title;
		this.edition = edition;
		this.authors = authors;
		this.ISBN = ISBN;
		this.subject = subject;
		this.queue = queue;
	}
//	public Order() {
//		orderID = null;
//		String customerID = null;
//		LinkedList<String> dish = new LinkedList<>();
//		String time = null;
//		int status = 0;
//	}
	
	//getter and setter for orderID
	public String getABPID() {
		return ABPID;
	}
	
	public void setABPID(String ABPID) {
		this.ABPID = ABPID;
	}
	
	
	//getter and setter for studentID
	public String getStudentID() {
		return student_id;
	}
		
	public void setStudentID(long studentID) {
		this.student_id = student_id;
	}
	
	//getter and setter for hold queue position
	public long getQueue() {
		return queue;
	}
			
	public void setQueue(int queue) {
		this.queue = queue;
	}
	
	//getter and setter for dish
	public LinkedList<Book> getBook() {
		return book;
	}
	
	public void setBook(Book d) {
		book.add(d);
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
	
    //getter and setter for time
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
