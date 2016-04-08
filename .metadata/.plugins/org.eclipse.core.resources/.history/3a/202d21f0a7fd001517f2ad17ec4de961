package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Time;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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
import model.Comment;
import model.News;
import model.User;

/**
 * Servlet implementation class ComentarioNoticiaServlet
 */
@WebServlet("/auth/ComentarioNoticia")
public class ComentarioNoticiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComentarioNoticiaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("GET comentario noticia");
		long id = Long.parseLong(request.getParameter("id"));
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		NewsDAO newDao = new JDBCNewsDAOImpl();
		newDao.setConnection(conn);
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);
		CommentDAO cDao = new JDBCCommentDAOImpl();
		cDao.setConnection(conn);
		
		News noticia = newDao.get(id);
		User user = userDAO.get(noticia.getOwner());
		List<Comment> comentarios = cDao.getAllByNews(noticia.getId());
		Integer karma = cDao.getAllByOwner(user.getId()).size();
		Map<String, Object> newsMap = new LinkedHashMap<String, Object>();
		newsMap.put("noticia", noticia);
		newsMap.put("owner", user);
		newsMap.put("cantidadComent", comentarios.size());
		newsMap.put("karma", karma);
		
		Map<Comment, User> comMap = new LinkedHashMap<Comment, User>();
		
		Iterator<Comment> it = comentarios.iterator();
		
		while(it.hasNext()) {
			Comment comm = (Comment) it.next();
			User userComm = userDAO.get(comm.getOwner());
			comMap.put(comm, userComm);
			
		}
		newsMap.put("comentarios", comMap);
		//newsMap.put("comentarios", comentarios);
		
		request.setAttribute("info",newsMap);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/ComentariosNoticia.jsp");
		view.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		logger.info("Atendiendo POST");
		long id = Long.parseLong(request.getParameter("id"));
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		CommentDAO cDao = new JDBCCommentDAOImpl();
		cDao.setConnection(conn);
		NewsDAO newDao = new JDBCNewsDAOImpl();
		newDao.setConnection(conn);
		
		News noticia = newDao.get(id);
		
		Comment c = new Comment();
		c.setOwner(u.getId());
		c.setNews(noticia.getId());
		Date hoy = new Date();
		c.setDateStamp(hoy);
		c.setTimeStamp(new Time(hoy.getTime()));
		c.setText(request.getParameter("text"));
		c.setLikes(0);
		
		cDao.add(c);
		
		logger.info("Nuevo comentario registrado");
		response.sendRedirect("ComentarioNoticia?id="+noticia.getId());
	}

}
