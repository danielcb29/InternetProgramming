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

import dao.JDBCNewsDAOImpl;
import dao.NewsDAO;
import model.News;
import model.User;

/**
 * Servlet implementation class EditarNoticiaServlet
 */
@WebServlet("/auth/EditarNoticia")
public class EditarNoticiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarNoticiaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("GET editar noticia");
		long id = Long.parseLong(request.getParameter("id"));
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		NewsDAO newDao = new JDBCNewsDAOImpl();
		newDao.setConnection(conn);
		
		News noticia = newDao.get(id);
		if(noticia.getOwner() == u.getId()){
			request.setAttribute("noticia", noticia);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/RegistroNoticia.jsp");
			view.forward(request,response);
		}else{
			Map<String, String> messages = new HashMap<String, String>();
			messages.put("error", "Esta noticia no es tuya, no puedes editarla");
			request.setAttribute("messages", messages);
			response.sendRedirect(request.getContextPath()+"/Noticias");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("POST editar noticia");
		long id = Long.parseLong(request.getParameter("id"));
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		NewsDAO newDao = new JDBCNewsDAOImpl();
		newDao.setConnection(conn);
		
		News noticia = newDao.get(id);
		if(noticia.getOwner() == u.getId()){
			//Si no nos han cambiado el id para cambiar la info de mi noticia con la info de la noticia de otro, editamos la noticia			
			logger.info("Editar Correcto: Peticion es del dueño");
			News new_noticia = new News();
			new_noticia.setOwner(noticia.getOwner());
			new_noticia.setDateStamp(noticia.getDateStamp());
			new_noticia.setTimeStamp(noticia.getTimeStamp());			
			new_noticia.setTitle(request.getParameter("titulo"));
			new_noticia.setText(request.getParameter("descripcion"));
			new_noticia.setUrl(request.getParameter("url"));
			new_noticia.setHits(noticia.getHits());
			new_noticia.setLikes(noticia.getLikes());
			new_noticia.setCategory(request.getParameter("categoria"));
			new_noticia.setId(noticia.getId());
			newDao.save(new_noticia);
			logger.info("Edicion terminada");
			response.sendRedirect(request.getContextPath()+"/Noticias");
		}else{
			System.out.println("Editar Incorrecto: Peticion no es del dueño");
			Map<String, String> messages = new HashMap<String, String>();
			messages.put("error", "Esta noticia no es tuya, no puedes editarla");
			request.setAttribute("messages", messages);
			response.sendRedirect(request.getContextPath()+"/Noticias");
		}
	}

}
