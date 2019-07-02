package domain.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Calendar;

import domain.bean.CartItem;
//import domain.bean.Customer;
import domain.bean.HoldItem;
import util.MySQLJDBC;

public class HoldItemDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	public int saveOrder(int student_id, String ABPID){
		Date date = new Date();		//current date
		
		//Set hold date for 2 days (hold duration)
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 2);	//adds 2 days
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
	
	public List<HoldItem> getHoldBooks(String student_id) {
		mySQLJDBC.setPreparedSql("select * from hold join books on hold.ABPID = books.ABPID where student_id = ?;", student_id);
		ResultSet res = mySQLJDBC.excuteQuery();
		List<HoldItem> items = new LinkedList<>();
		try {
			while ((res != null) && (res.next())) {
				HoldItem cur = new HoldItem(res.getString("student_id"), res.getString("ABPID"), res.getString("title"), res.getString("edition_or_volume"), res.getString("authors"), res.getString("ISBN"), res.getString("subject"), res.getInt("queue"));
				//cur.setCategoryId(res.getInt("catid"));
				//cur.setCategoryName(res.getString("category.name"));
				//cur.setName(res.getString("dish.name"));
				//cur.setPrice(res.getInt("price"));
				items.add(cur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}
	
	public boolean addHold(String student_id, String ABPID, int numRequest) {
		mySQLJDBC.setPreparedSql("insert into hold (student_id, ABPID, queue)\r\n values (?, ?, ?);", student_id, ABPID, numRequest);
		int res = mySQLJDBC.executeUpdate();
		
		mySQLJDBC.setPreparedSql("update books set isAvailable = ?, status = ?, numRequests = numRequests + 1 where ABPID = ?;", 0, 2, ABPID);
		res = mySQLJDBC.executeUpdate();
		/*mySQLJDBC.setPreparedSql("update hold set queue = ? where student_id = ?;", numRequest, student_id);
		int res2 = mySQLJDBC.executeUpdate();*/
		if (res != -1) {
			return true;
		}
		return false;
	}
	
	public HoldItem checkExist(String student_id, String ABPID) {
		mySQLJDBC.setPreparedSql("select * from hold join books on hold.ABPID = books.ABPID where student_id = ? and hold.ABPID = ?;", student_id, ABPID);
		ResultSet res = mySQLJDBC.excuteQuery();
		try {
			if ((res != null) && (res.next())) {
				HoldItem cur = new HoldItem(res.getString("student_id"),res.getString("ABPID"),res.getString("title"),res.getString("edition_or_volume"),res.getString("authors"),res.getString("ISBN"),res.getString("subject"),res.getInt("queue"));
				return cur;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int countHolds(String ABPID) {
		mySQLJDBC.setPreparedSql("SELECT ABPID,COUNT(*) as count from hold where ABPID = ? GROUP BY ABPID ORDER BY count;", ABPID);
		ResultSet res = mySQLJDBC.excuteQuery();
		try {
			if ((res != null) && (res.next())) {
				return res.getInt("count");
			}
			else return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean removeHold(String student_id, String ABPID, String queue, int numRequest){
		/*mySQLJDBC.setPreparedSql("select queue from hold where student_id = ?", ABPID);
		ResultSet res = mySQLJDBC.excuteQuery();*/
		
		mySQLJDBC.setPreparedSql("update hold set queue = queue - 1 where queue > ? and ABPID = ?;", queue, ABPID);
		int r = mySQLJDBC.executeUpdate();
		
		mySQLJDBC.setPreparedSql("delete from hold where student_id = ? and ABPID =?;", student_id, ABPID);
		r= mySQLJDBC.executeUpdate();
		
		mySQLJDBC.setPreparedSql("update books set numRequests = numRequests - 1 where ABPID = ?;", ABPID);
		r = mySQLJDBC.executeUpdate();
		
		mySQLJDBC.setPreparedSql("select * from books where ABPID = ?;", ABPID);
		ResultSet res = mySQLJDBC.excuteQuery();
		
		try {
			if ((res != null) && (res.next())) {
				if(res.getInt("numRequests") == 0)
					{
						mySQLJDBC.setPreparedSql("update books set isAvailable = 1, status = 1 where ABPID = ?;", ABPID);
						r = mySQLJDBC.executeUpdate();
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (r != -1) {
			return true;
		}
		return false;
	}
	/*public ArrayList<HoldItem> displayHold(int studentID){
		ArrayList<HoldItem> list = new ArrayList<>();
		mySQLJDBC.setPreparedSql("select * from hold where student_id=?;", studentID);
		ResultSet resultSet = mySQLJDBC.excuteQuery();
//		response.getWriter().println("hello");
		try {
			while(resultSet.next()) {
				HoldItem hold = new HoldItem();
				hold.setStudentID(resultSet.getInt("student_id"));
				hold.setABPID(resultSet.getString("ABPID"));
				hold.setEndDate(resultSet.getString("queue"));

				list.add(hold);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mySQLJDBC.close();
		
		return list;
	}*/
	

}
