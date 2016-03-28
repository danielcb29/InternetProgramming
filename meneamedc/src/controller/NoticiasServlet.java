package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JDBCNewsDAOImpl;
import dao.JDBCUserDAOImpl;
import dao.NewsDAO;
import dao.UserDAO;
import model.News;
import model.User;

/**
 * Servlet implementation class Noticias
 */
@WebServlet("/Noticias")
public class NoticiasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticiasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Atendiendo GET");
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		NewsDAO newsDao = new JDBCNewsDAOImpl();
		newsDao.setConnection(conn);
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);
		
		List<News> noticias = newsDao.getAll();
		
		Map<News, User> newsMap = new HashMap<News, User>();
		
		Iterator<News> it = noticias.iterator();
		
		while(it.hasNext()) {
			News news = (News) it.next();
			User user = userDAO.get(news.getOwner());
			newsMap.put(news, user);
			
		}
		
		//request.setAttribute("newsMap",newsMap);
		
		request.setAttribute("noticias",newsMap);
		request.setAttribute("categoria", "Mas recientes");
		
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Noticias.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
