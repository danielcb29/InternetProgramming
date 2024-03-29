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
import javax.servlet.http.HttpSession;

import dao.JDBCUserDAOImpl;
import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class EditarPerfilServlet
 */
@WebServlet("/auth/EditarPerfilServlet")
public class EditarPerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPerfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar el usuario
		//long id = Long.parseLong(request.getParameter("id"));
		logger.info("Consultado usuario");
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		//User u = userDao.get(id);
		request.setAttribute("user", u);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/EditarPerfil.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("postsini");
		request.setCharacterEncoding("UTF-8");
		logger.info("Editando usuario");
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		User user = new User();
		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		
		long userId = ((User) request.getSession().getAttribute("user")).getId();
		user.setId(userId);
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		String confpass = request.getParameter("confirmpassword");
		
		Map<String, String> messages = new HashMap<String, String>();
		logger.info("Validacion del password");
		
		if(user.validate_password(messages, confpass)){
			logger.info("Edidanto usuario");
			userDao.save(user);
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			response.sendRedirect("Perfil?id="+user.getId());
		}
		else{
			request.setAttribute("messages",messages);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/EditarPerfil.jsp");
			view.forward(request,response);
		}
	}

}
