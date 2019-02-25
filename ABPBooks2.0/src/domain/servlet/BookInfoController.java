package domain.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.bean.Category;
import domain.bean.Book;
import domain.dao.CategoryDao;
import domain.dao.BookDao;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/BookInfoController")
public class BookInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*CategoryDao categoryDao = new CategoryDao();
		List<Category> categories = categoryDao.selectCategory();
		//categories = categoryDao.selectCategory();
		request.setAttribute("categoryList", categories);*/
		
		BookDao bookDao = new BookDao();
		
		String title = request.getParameter("title");
		String edition = request.getParameter("edition");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		String subject = request.getParameter("subject");
		
		/*if(title.equals(""))
			title = null;
		if(edition.equals(""))
			edition = null;
		if(author.equals(""))
			author = null;
		if(isbn.equals(""))
			isbn = null;
		if(subject.equals("null"))
			subject = null;*/
		
		List<Book> books = bookDao.selectBookInfo(title, edition, author, isbn, subject);
		request.setAttribute("bookList", books);
		request.getRequestDispatcher("/bookInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}
