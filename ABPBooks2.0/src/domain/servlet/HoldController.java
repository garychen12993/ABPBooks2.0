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
@WebServlet("/HoldController")
public class HoldController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoldController() {
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
		
		if(action.equals("display"))
		{
			//int cid = (int) session.getAttribute("cid");
			HoldItemDao holdItemDao = new HoldItemDao();
			List<HoldItem> holdList = new LinkedList<>();
			String student_id = (String) session.getAttribute("id");
			holdList = holdItemDao.getHoldBooks(student_id);
			//request.setAttribute("name", session.getAttribute("firstname"));
			request.setAttribute("msg", action);
			request.setAttribute("holdList", holdList);
			request.getRequestDispatcher("/hold.jsp").forward(request, response);
		}
		else if(action.equals("insert") && request.getParameter("placeHold") != null)
		{
			HoldItemDao holdItemDao = new HoldItemDao();
			//String student_id = request.getParameter("student_id");
			String student_id = (String) session.getAttribute("id");
			String ABPID = (String) request.getParameter("ABPID");
			
			String bookInfoPath = request.getParameter("bookInfoPath"); //???? idk why i added this
			//int quantity = Integer.valueOf(q);
			HoldItem item = holdItemDao.checkExist(student_id, ABPID);
			
			BookDao bookDao = new BookDao();
			
			String title = request.getParameter("title");
			String edition = request.getParameter("edition");
			String author = request.getParameter("author");
			String isbn = request.getParameter("isbn");
			String subject = request.getParameter("subject");
			
			List<Book> books = bookDao.selectBookInfo(title, edition, author, isbn, subject);
			
			if(item != null)
			{
				request.setAttribute("errmessage", "you have already placed hold on the item");
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
				int numRequest = holdItemDao.countHolds(ABPID);
				
				holdItemDao.addHold(student_id, ABPID, numRequest + 1);
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
		else if(action.equals("remove") && request.getParameter("placeHoldMultiple") != null)
		{
			String student_id = (String) session.getAttribute("id");
			String[] ABPIDs = request.getParameterValues("checked");
			//List<CartItem> cartList = (List<CartItem>) session.getAttribute("list");
			/*for(CartItem cartItem : cartList){
				HoldItemDao holdItemDao = new HoldItemDao();
				
				int numRequest = holdItemDao.countHolds(cartItem.getABPID());
				
				holdItemDao.addHold(student_id, cartItem.getABPID(), numRequest + 1);
				
				//remove from cart
				CartItemDao cartItemDao = new CartItemDao();
				cartItemDao.removeItem(student_id, cartItem.getABPID());
			}*/
			
			if(ABPIDs == null)
			{
				request.setAttribute("message", "No items were selected.");
			}
			else
			{
				for(String s: ABPIDs)
				{
					HoldItemDao holdItemDao = new HoldItemDao();
				
					int numRequest = holdItemDao.countHolds(s);
				
					holdItemDao.addHold(student_id, s, numRequest + 1);
				
					//remove from cart
					CartItemDao cartItemDao = new CartItemDao();
					cartItemDao.removeItem(student_id, s);
				}
			}
			CartItemDao cartItemDao = new CartItemDao();
			List<CartItem> cartList2 = new LinkedList<>();
			cartList2 = cartItemDao.getCartBooks(student_id);
			request.setAttribute("cartList", cartList2);
			
			request.getRequestDispatcher("/cart.jsp").forward(request, response);
			/*for(ABPIDs)
			{
				HoldItemDao holdItemDao = new HoldItemDao();
				int numRequest = holdItemDao.countHolds(ABPIDs[i]);
				
				holdItemDao.addHold(student_id, ABPIDs[i], numRequest + 1);
				/*request.setAttribute("message", "Successfully added item ABPID" + ABPIDs[i]);
				request.setAttribute("bookList", books);
			}*/
		}
		else if(action.equals("remove"))
		{
			HoldItemDao holdItemDao = new HoldItemDao();
			String student_id = (String) session.getAttribute("id");
			String ABPID = (String) request.getParameter("ABPID");
			String queue = (String) request.getParameter("queue");
			
			int numRequest = holdItemDao.countHolds(ABPID);
			holdItemDao.removeHold(student_id, ABPID, queue, numRequest);
			
			List<HoldItem> holdList = new LinkedList<>();
			holdList = holdItemDao.getHoldBooks(student_id);
			request.setAttribute("holdList", holdList);
			
			//request.setAttribute("message", queue);
			request.getRequestDispatcher("/hold.jsp").forward(request, response);
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
