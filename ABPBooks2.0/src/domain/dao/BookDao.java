package domain.dao;

import util.MySQLJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.bean.Book;

/**
 * @author garychen
 *  Category DAO class, including add, edit, delete, show methods of dish in database.
 *
 */

public class BookDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	public List<Book> selectDish(int id) {
		List<Book> list = new ArrayList<Book>();
		if(id == 0) {
			mySQLJDBC.setPreparedSql("select * from dish order by did;");
		}else {
			mySQLJDBC.setPreparedSql("select * from dish where did = ?;", id);
		}	
		ResultSet rs = mySQLJDBC.excuteQuery();
		try {
			while(rs.next()) {
				Book book = new Book();
				book.setCount(rs.getInt("count"));
				book.setABPID(rs.getString("ABPID) "));
				book.setBookname(rs.getString("bookname) "));
				book.setEdition(rs.getString("edition) "));
				book.setAuthors(rs.getString("authors) "));
				book.setISBN(rs.getString("ISBN) "));
				book.setSubject(rs.getString("subject) "));
				book.setAvailability(rs.getInt("isAvailable) "));
				book.setNumRequests(rs.getInt("numRequests) ) "));
				list.add(book);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		mySQLJDBC.close();
//		for(Category cate : list) {
//			System.out.println(cate.getId());
//			System.out.println(cate.getName());
//			System.out.println(cate.getDes());
//			System.out.println("-------------------------");
//		}
		return list;
	}
	
}
