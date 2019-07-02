package domain.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import util.MySQLJDBC;
import domain.bean.*;


public class CartItemDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	
	
	public List<CartItem> getCartBooks(String student_id) {
		mySQLJDBC.setPreparedSql("select * from cart join books on cart.ABPID = books.ABPID where student_id = ?;", student_id);
		ResultSet res = mySQLJDBC.excuteQuery();
		List<CartItem> items = new LinkedList<>();
		try {
			while ((res != null) && (res.next())) {
				CartItem cur = new CartItem(res.getString("student_id"), res.getString("ABPID"), res.getString("title"), res.getString("edition_or_volume"), res.getString("authors"), res.getString("ISBN"), res.getString("subject"));
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
	
	public boolean insertCart(String student_id, String ABPID) {
		mySQLJDBC.setPreparedSql("insert into cart (student_id, ABPID)\r\n" + 
				"values (?, ?);", student_id, ABPID);
		int res = mySQLJDBC.executeUpdate();
		if (res != -1) {
			return true;
		}
		return false;
	}
	
	public CartItem checkExist(String student_id, String ABPID) {
		mySQLJDBC.setPreparedSql("select * from cart join books on cart.ABPID = books.ABPID where student_id = ? and cart.ABPID = ?;", student_id, ABPID);
		ResultSet res = mySQLJDBC.excuteQuery();
		try {
			if ((res != null) && (res.next())) {
				CartItem cur = new CartItem(res.getString("student_id"), res.getString("ABPID"), res.getString("title"), res.getString("edition_or_volume"), res.getString("authors"), res.getString("ISBN"), res.getString("subject"));
				return cur;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateItem(int cid, String did, int quantity){
		mySQLJDBC.setPreparedSql("update cart set quantity = ?\r\n" + 
				"where cid = ? and did =?;", quantity, cid, did);
		int res = mySQLJDBC.executeUpdate();
		if (res != -1) {
			return true;
		}
		return false;
	}
	
	public boolean removeItem(String student_id, String ABPID){
		mySQLJDBC.setPreparedSql("delete from cart where student_id = ? and ABPID =?;", student_id, ABPID);
		int res = mySQLJDBC.executeUpdate();
		if (res != -1) {
			return true;
		}
		return false;
	}
	
	public boolean deleteAll(int cid){
		mySQLJDBC.setPreparedSql("delete from cart\r\n" + 
				"where cid = ?;", cid);
		int res = mySQLJDBC.executeUpdate();
		if (res != -1) {
			return true;
		}
		return false;
	}

	/**
	 * Before releasing resources, execute mySQLJDBC.close() method to ensure
	 * this.preparedStatement and this.connection has been closed 
	 */
	protected void finalize() throws Throwable {
		mySQLJDBC.close();
		super.finalize();
	}


}
