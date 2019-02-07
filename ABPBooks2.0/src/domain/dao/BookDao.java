package domain.dao;

import util.MySQLJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.bean.Book;
import org.apache.commons.lang3.StringUtils;

/**
 * @author garychen
 *  Category DAO class, including add, edit, delete, show methods of dish in database.
 *
 */

public class BookDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	public List<Book> selectBook(String title, String edition, String author, String isbn, String subject) {
		List<Book> list = new ArrayList<Book>();
		/*if(title == null && edition == null && author == null && isbn == null && subject == null){
			mySQLJDBC.setPreparedSql("select * from books order by count;");
		}else if(title != null || edition != null || author != null || isbn != null || subject != null){
			String selectQuery = "select * from books where 1=1 ";
			if(StringUtils.isNotBlank(title))
			{
				selectQuery += "and title = " + title;
			}
			if(StringUtils.isNotBlank(edition))
			{
				selectQuery += "and edition_or_volume = " + edition;
			}
			if(StringUtils.isNotBlank(author))
			{
				selectQuery += "and authors = " + author;
			}
			if(StringUtils.isNotBlank(isbn))
			{
				selectQuery += "and ISBN = " + isbn;
			}
			if(StringUtils.isNotBlank(subject))
			{
				selectQuery += "and subject = " + subject;
			}
			
			mySQLJDBC.setPreparedSql(selectQuery);
		}*/
		
		if(title == null && edition == null && author == null && isbn == null && subject == null) {
			mySQLJDBC.setPreparedSql("select * from books order by title;");
		}else{
			//mySQLJDBC.setPreparedSql("select * from books order by ABPID;");
			String selectClause = "select * from books where 1=1 ";
			if(title != null){
				selectClause += "and title like '" + title + "%' ";
			}
			if(edition != null){
				selectClause += "and edition_or_volume like '" + edition + "%' ";
			}
			if(author != null){
				selectClause += "and authors like '" + author + "%' ";
			}
			if(isbn != null){
				selectClause += "and ISBN like '" + isbn + "%' ";
			}
			if(subject != null){
				selectClause += "and subject like '" + subject + "%' ";
			}
			
			mySQLJDBC.setPreparedSql(selectClause);
		}
		ResultSet rs = mySQLJDBC.excuteQuery();
		try {
			while(rs.next()) {
				Book book = new Book();
				book.setCount(rs.getInt("count"));
				book.setABPID(rs.getString("ABPID"));
				book.setTitle(rs.getString("title"));
				book.setEdition(rs.getString("edition_or_volume"));
				book.setAuthors(rs.getString("authors"));
				book.setISBN(rs.getString("ISBN"));
				book.setSubject(rs.getString("subject"));
				book.setAvailability(rs.getInt("isAvailable"));
				book.setNumRequests(rs.getInt("numRequests"));
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
