package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;
import dao.JDBCCommentDAOImpl;
import dao.JDBCUserDAOImpl;
import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class PerfilServlet
 */
@WebServlet("/auth/Perfil")
public class PerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar el usuario
		long id = Long.parseLong(request.getParameter("id"));
		logger.info("Consultado usuario de id:"+id);
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		CommentDAO commentDao = new JDBCCommentDAOImpl();
		commentDao.setConnection(conn);
		
		User u = userDao.get(id);
		Integer totalComments = commentDao.getAllByOwner(u.getId()).size();
		Map<String, Integer> profMap = new HashMap<String, Integer>();
		profMap.put("comentarios", totalComments);
		request.setAttribute("user", u);
		request.setAttribute("profMap", profMap);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Perfil.jsp");
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
