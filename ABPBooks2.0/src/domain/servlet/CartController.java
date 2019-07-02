package domain.servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import domain.bean.*;
import domain.dao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String student_id = (String) session.getAttribute("id");
		
		if(action.equals("display"))
		{
			//int cid = (int) session.getAttribute("cid");
			CartItemDao cartItemDao = new CartItemDao();
			List<CartItem> cartList = new LinkedList<>();
			//String student_id = (String) session.getAttribute("id");
			cartList = cartItemDao.getCartBooks(student_id);
			//request.setAttribute("name", session.getAttribute("firstname"));
			request.setAttribute("msg", action);
			request.setAttribute("cartList", cartList);
			request.getRequestDispatcher("/cart.jsp").forward(request, response);
		}
		else if (action.equals("insert") && request.getParameter("addToCart") != null)
		{
			CartItemDao cartItemDao = new CartItemDao();
			//String student_id = request.getParameter("student_id");
			//String student_id = (String) session.getAttribute("id");
			String ABPID = (String) request.getParameter("ABPID");
			
			String bookInfoPath = request.getParameter("bookInfoPath"); //???? idk why i added this
			//int quantity = Integer.valueOf(q);
			CartItem item = cartItemDao.checkExist(student_id, ABPID);
			
			BookDao bookDao = new BookDao();
			
			String title = request.getParameter("title");
			String edition = request.getParameter("edition");
			String author = request.getParameter("author");
			String isbn = request.getParameter("isbn");
			String subject = request.getParameter("subject");
			
			List<Book> books = bookDao.selectBookInfo(title, edition, author, isbn, subject);
			
			if(item != null)
			{
				request.setAttribute("errmessage", "item has already been added to cart");
				request.setAttribute("bookList", books);
			}
			/*if (item != null) {
				if (item.getQuantity() + quantity == 0) {
					cartItemDao.deleteItem(cid, did);
				} else {
					cartItemDao.updateItem(cid, did, item.getQuantity() + quantity);
				}
			} else {*/
			else
			{
				cartItemDao.insertCart(student_id, ABPID);
				request.setAttribute("message", "Successfully added item ABPID" + ABPID);
				request.setAttribute("bookList", books);
			}
			//}
				//request.setAttribute("results", results);
				//request.getRequestDispatcher("bookInfo.jsp").forward(request, response);
			//RequestDispatcher rd = request.getRequestDispatcher(bookInfoPath);
			//rd.forward(request, response);
			request.getRequestDispatcher("/bookInfo.jsp").forward(request, response);
		}
		else if(action.equals("remove") && request.getParameter("remove") != null)
		{
			CartItemDao cartItemDao = new CartItemDao();
			//String student_id = (String) session.getAttribute("id");
			String ABPID = (String) request.getParameter("ABPID");
			cartItemDao.removeItem(student_id, ABPID);
			
			List<CartItem> cartList = new LinkedList<>();
			cartList = cartItemDao.getCartBooks(student_id);
			request.setAttribute("cartList", cartList);
			
			request.setAttribute("message", request.getParameter("ABPID"));
			request.getRequestDispatcher("/cart.jsp").forward(request, response);
		}
		else if(action.equals("insert") && request.getParameter("placeHold") != null)
		{
			request.getRequestDispatcher("/HoldController").forward(request, response);
		}
		else if(action.equals("remove") && request.getParameter("placeHoldMultiple") != null)
		{	
			request.getRequestDispatcher("/HoldController").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
