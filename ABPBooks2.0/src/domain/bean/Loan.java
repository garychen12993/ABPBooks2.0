package domain.bean;

import java.util.*;
import java.util.LinkedList;

public class Loan {
	private String ABPID = null;
	private long studentID = 0;
	private LinkedList<Book> book = new LinkedList<>();
	private String dueDate = null;
	private int daysOverdue = 0;
	private String semester = null;

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
		
		public void setCustomerID(long studentID) {
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
		return dueDate;
	}
	
	public void setEndDate(String endDate) {
		this.dueDate = endDate;
	}
	
	//getter and setter for time
	public int getDaysOverdue() {
		return daysOverdue;
	}
	
	public void setEndDate(int daysOverdue) {
		this.daysOverdue = daysOverdue;
	}
	
	//getter and setter for time
	public String getSemester() {
		return semester;
	}
	
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
}
