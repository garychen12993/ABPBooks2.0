/**
 * 
 */
package domain.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.bean.Student;
import util.MySQLJDBC;

/**
 * @author Gary Chen, Nancy Dominguez
 * Student DAO class, including methods to access student in database.
 *
 */
public class StudentDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	/**
	 * student registration method.
	 * If student email exists, student cannot be registered.
	 * 
	 * @param student student to be registered
	 * @return register status, either true for success or false for failure
	 */
	public boolean register(Student student) {
		if (studentIdExist(student)) {
			return false;
		} else {
			return insertStudent(student);
		}
	}
	
	/**
	 * verify whether customer email exists or not.
	 * 
	 * @param customer customer to be verified
	 * @return existence status, either true for success or false for failure
	 */
	public boolean studentIdExist(Student student) {
		boolean studentIdExist = false;
		mySQLJDBC.setPreparedSql("select count from students where student_id=?;", student.getStudentId());
		ResultSet resultSet = mySQLJDBC.excuteQuery();
		try {
			studentIdExist = resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentIdExist;
	}

	/**
	 * insert customer information into database.
	 * 
	 * @param customer customer to be inserted
	 * @return insert status, either true for success or false for failure
	 */
	public boolean insertStudent(Student student) {
		if (student.getStudentId() != null && student.getStudentId().length() > 0) {
			mySQLJDBC.setPreparedSql("insert into students(student_id,email,password,first_name,last_name,address,phone_number,classification,major) values(?,?,?,?,?,?,?,?,?);",
					student.getStudentId(), student.getEmail(), student.getPassword(), student.getFirstName(), student.getLastName(),
					student.getAddress(), student.getPhone(), student.getBridgeYear(), student.getMajor());
			mySQLJDBC.executeUpdate();
			return true;
		}
		return false;
	}

	/**
	 * Validate customer's email and password.
	 * If information matches in database, return a customer object.
	 * Otherwise, return null.
	 * 
	 * @param customer customer information including email and password
	 * @return either (1) customer object 
	 *         or (2) null.
	 */
	public Student validateStudent(Student student) {
		//mySQLJDBC.setPreparedSql("select count,student_id,firstname,lastname,address,phone,classification,major,flagged from student where email=? and password=?", student.getEmail(), student.getPassword());
		mySQLJDBC.setPreparedSql("select email,first_name,last_name from students where student_id=? and password=?", student.getStudentId(), student.getPassword());
		ResultSet resultSet = mySQLJDBC.excuteQuery();
		try {
			if ((resultSet != null) && (resultSet.next())) {
				//student.setCount(resultSet.getInt("count"));
				student.setEmail(resultSet.getString("email"));
				student.setFirstName(resultSet.getString("first_name"));
				student.setLastName(resultSet.getString("last_name"));
				/*student.setAddress(resultSet.getString("address"));
				student.setPhone(resultSet.getString("phone"));
				student.setBridgeYear(resultSet.getInt("classification"));
				student.setMajor(resultSet.getString("major"));
				student.setFlagged (resultSet.getInt("flagged"));*/
				return student;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Before releasing resources, execute mySQLJDBC.close() method to ensure
	 * this.preparedStatement and this.connection has been closed 
	 */
	protected void finalize() throws Throwable {
		mySQLJDBC.close();
		super.finalize();
	}

	public boolean  updateStudent(Student student) {
		if (student.getEmail() != null && student.getEmail().length() > 0) {
		mySQLJDBC.setPreparedSql("UPDATE student SET email=?, firstname=?, lastname=?, address=?, phone=?, classification, major, flagged, WHERE student_id=? and password=?", student.getEmail(), student.getFirstName(), student.getLastName(), student.getAddress(), student.getPhone(),student.getEmail(), student.getPassword(), student.getBridgeYear(), student.getMajor(), student.getFlagged());
	//	mySQLJDBC.setPreparedSql("insert into student(email,password,firstname,lastname,street,city,state,zip,phone) values(?,?,?,?,?,?,?,?,?);",
	//				"xxy@utdallas.edu", "123456", customer.getFirstName(), customer.getLastName(),
	//				student.getStreet(), student.getCity(), student.getState(), student.getZip(), student.getPhone());
		mySQLJDBC.executeUpdate();
		mySQLJDBC.close();
		return true;
		}
		return false;
	}
	
}
