package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDAO;
import dao.JDBCCommentDAOImpl;
import dao.JDBCNewsDAOImpl;
import dao.JDBCUserDAOImpl;
import dao.NewsDAO;
import dao.UserDAO;
import model.News;
import model.User;

/**
 * Servlet implementation class MisNoticias
 */
@WebServlet("/auth/MisNoticias")
public class MisNoticiasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MisNoticiasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		NewsDAO newDao = new JDBCNewsDAOImpl();
		newDao.setConnection(conn);
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);
		CommentDAO cDao = new JDBCCommentDAOImpl();
		cDao.setConnection(conn);
		
		List<News> misNoticias = newDao.getAllByOwner(u.getId());
		
		Map<News, Map<String,Object>> newsMap = new LinkedHashMap<News, Map<String,Object>>();
		
		Iterator<News> it = misNoticias.iterator();
		
		while(it.hasNext()) {
			Map<String,Object> addMap = new LinkedHashMap<String,Object>();
			News news = (News) it.next();
			User user = userDAO.get(news.getOwner());
			Integer cantComm = cDao.getAllByNews(news.getId()).size();
			Integer karma = cDao.getAllByOwner(user.getId()).size();
			addMap.put("karma", karma);
			addMap.put("comments", cantComm);
			addMap.put("user", user);
			newsMap.put(news, addMap);
			//newsMap.put(news, user);
			
		}
		
		//request.setAttribute("newsMap",newsMap);
		
		request.setAttribute("noticias",newsMap);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/MisNoticias.jsp");
		view.forward(request,response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
