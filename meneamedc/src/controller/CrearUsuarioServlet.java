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

import dao.JDBCUserDAOImpl;
import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class CrearUsuarioServlet
 */
@WebServlet("/CrearUsuario")
public class CrearUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Registro.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		logger.info("Creando usuario");
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		User user = new User();
		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		String confpass = request.getParameter("confirmpassword");
		
		Map<String, String> messages = new HashMap<String, String>();
		logger.info("Validacion del password");
		
		if(user.validate_password(messages, confpass)){
			logger.info("Guardando usuario");
			userDao.add(user);
			response.sendRedirect("auth/Perfil?id="+user.getId());
		}
		else{
			request.setAttribute("messages",messages);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Registro.jsp");
			view.forward(request,response);
		}
		
	}

}
