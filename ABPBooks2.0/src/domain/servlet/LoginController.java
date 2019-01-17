package domain.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.bean.Student;
import domain.dao.StudentDao;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao studentDao = new StudentDao();

		String id = request.getParameter("id");
		String password = request.getParameter("password");
//		String submitType = request.getParameter("submit");
		
		Student studentToBeValidate = new Student(id, password);
		// future work: (done)
		// divided into following cases:(or separate login and register controller)
		// 1) login :
		//     (1)email not exists: data not found; validateEmail()
		//     (2)email exists, but password is wrong: back to login.jsp and showing password wrong
		//            call validateEmail() first, then validate password
		//     (3)pass the validation: welcome
		// 2) register :
		//     (1)email exists: back to login.jsp and showing please try login or forget password
		//     (2)email not exists: data not found

		if(studentDao.studentIdExist(studentToBeValidate)){
			Student student = studentDao.validateStudent(studentToBeValidate);
			if (student != null) {
//				Gary
				HttpSession session = request.getSession();
				session.setAttribute("cid", student.getStudentId());
				session.setAttribute("email", student.getEmail());
				session.setAttribute("fName", student.getFirstName());
				session.setAttribute("lName", student.getLastName());
				session.setAttribute("passwd", student.getPassword());
				request.getRequestDispatcher("/welcome.jsp").forward(request, response);
				//request.getRequestDispatcher("/MenuController").forward(request, response);
//				hb
//				HttpSession session=request.getSession();
//				session.setAttribute("email", customer.getEmail());
//				session.setAttribute("fName", customer.getFirstName());
//				session.setAttribute("lName", customer.getLastName());
//				session.setAttribute("passwd", customer.getPassword());
//				request.getRequestDispatcher("ProfileController").forward(request, response);

//				yzc
//				request.setAttribute("message", "Hello " + customer.getFirstName() + " " + customer.getLastName());
//				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Password Wrong! Please try again!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "Data Not Found! Please register!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
