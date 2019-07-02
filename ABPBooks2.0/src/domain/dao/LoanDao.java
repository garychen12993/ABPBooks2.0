package domain.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

//import domain.bean.Customer;
import domain.bean.HoldItem;
import util.MySQLJDBC;

public class LoanDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	public int saveOrder(int student_id, String ABPID){
		Date date = new Date();		//current date
		
		//Set hold date for 180 days = 6 months (1 semester)
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 180);	//adds 180 days
		String endDate = Long.toString(date.getTime());
		mySQLJDBC.setPreparedSql("insert into hold (student_id, ABPID, endDate) \n" + 
				"values (?, ?, ?);", student_id,ABPID,endDate);
		int res = mySQLJDBC.executeUpdate();
		if (res != -1) {
			return student_id; //originally returned oid (date)
		}
		return -1;
	}
	
	/*public boolean saveOrderDetails(int oid, int did, int amount){
		mySQLJDBC.setPreparedSql("insert into orderdetails (oid, did, amount) \n" + 
				"values (?, ?, ?);", oid, did, amount);
		int res = mySQLJDBC.executeUpdate();
		if (res != -1) {
			return true;
		}
		return false;
	}*/
	
	public ArrayList<HoldItem> displayHold(int studentID){
		ArrayList<HoldItem> list = new ArrayList<>();
		mySQLJDBC.setPreparedSql("select * from hold where student_id=?;", studentID);
		ResultSet resultSet = mySQLJDBC.excuteQuery();
//		response.getWriter().println("hello");
		try {
			while(resultSet.next()) {
				HoldItem hold = new HoldItem();
				hold.setStudentID(resultSet.getInt("student_id"));
				hold.setABPID(resultSet.getString("ABPID"));
				hold.setEndDate(resultSet.getString("endDate"));

				list.add(hold);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mySQLJDBC.close();
		
		return list;
	}
	

}
