package domain.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.bean.CartItem;
import domain.dao.CartItemDao;

/**
 * Servlet implementation class insertCartController
 */
@WebServlet("/insertCartController")
public class insertCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		//int id = (int) session.getAttribute("id");
		CartItemDao cartItemDao = new CartItemDao();
		//String student_id = request.getParameter("student_id");
		String student_id = (String) session.getAttribute("id");
		String ABPID = (String) request.getParameter("ABPID");
		//int quantity = Integer.valueOf(q);
		//CartItem item = cartItemDao.checkExist(student_id, ABPID);
		/*if (item != null) {
			if (item.getQuantity() + quantity == 0) {
				cartItemDao.deleteItem(cid, did);
			} else {
				cartItemDao.updateItem(cid, did, item.getQuantity() + quantity);
			}
		} else {*/
			cartItemDao.insertCart(student_id, ABPID);
		//}
			//request.setAttribute("results", results);
			//request.getRequestDispatcher("bookInfo.jsp").forward(request, response);
		request.setAttribute("message", request.getParameter("ABPID"));
		request.getRequestDispatcher("/studentHome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
