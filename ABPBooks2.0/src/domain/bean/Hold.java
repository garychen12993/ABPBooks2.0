package domain.bean;

import java.util.*;
import java.util.LinkedList;

public class Hold {
	private String ABPID = null;
	private long studentID = 0;
	private LinkedList<Book> book = new LinkedList<>();
	private String endDate = null;

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
	
	
	//getter and setter for customerID
		public long getStudentID() {
			return studentID;
		}
		
		public void setStudentID(long studentID) {
			this.studentID = studentID;
		}
	
	
	//getter and setter for dish
	public LinkedList<Book> getBook() {
		return book;
	}
	
	public void setBook(Book d) {
		book.add(d);
	}
	
	
	
    //getter and setter for time
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
