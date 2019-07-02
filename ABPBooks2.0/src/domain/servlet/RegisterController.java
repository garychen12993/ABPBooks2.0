package domain.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.bean.Student;
import domain.dao.StudentDao;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
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
		
		Student studentToBeInsert = new Student(id, password);

		if (studentDao.studentIdExist(studentToBeInsert)) {
			request.setAttribute("message", "Email exist, please choose another email or login directly with that user name!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} else {
			studentToBeInsert.setStudentId(request.getParameter("id"));
			studentToBeInsert.setPassword(request.getParameter("password"));
			studentToBeInsert.setFirstName(request.getParameter("firstname"));
			studentToBeInsert.setLastName(request.getParameter("lastname"));
			studentToBeInsert.setMajor(request.getParameter("major"));
			studentToBeInsert.setEmail(request.getParameter("email"));
			studentToBeInsert.setAddress(request.getParameter("address"));
			studentToBeInsert.setPhone(request.getParameter("phone"));
			studentToBeInsert.setBridgeYear(Integer.parseInt(request.getParameter("bridgeyear")));
			boolean inserted = studentDao.insertStudent(studentToBeInsert);
			if(inserted) {
				request.setAttribute("successMessage", "Registration done, please login!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Please insert email!");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
		}
		// TODO Auto-generated method stub
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
