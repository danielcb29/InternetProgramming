package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Time;
import java.util.Date;
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
import	model.User;

/**
 * Servlet implementation class CrearNotiviaServlet
 */
@WebServlet("/auth/CrearNoticia")
public class CrearNoticiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearNoticiaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("GET registro noticia");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/RegistroNoticia.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		logger.info("Atendiendo POST");
		
		HttpSession session = request.getSession();
		User user= (User) session.getAttribute("user");
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		NewsDAO newDao = new JDBCNewsDAOImpl();
		newDao.setConnection(conn);
		//Datos automaticos
		News noticia = new News();
		noticia.setOwner(user.getId());
		
		Date hoy = new Date();
		noticia.setDateStamp(hoy);
		
		Time yaMismo = new Time(hoy.getTime());
		noticia.setTimeStamp(yaMismo);
		
		noticia.setTitle(request.getParameter("titulo"));
		noticia.setText(request.getParameter("descripcion"));
		noticia.setUrl(request.getParameter("url"));
		noticia.setHits(0);
		noticia.setLikes(0);
		noticia.setCategory(request.getParameter("categoria"));
		
		logger.info("Registrando noticia");
		System.out.println("in create:"+noticia.getCategory());
		long idNew = newDao.add(noticia);
		System.out.println("id new: "+idNew);
		logger.info("Nueva noticia registrada");
		
		response.sendRedirect(request.getContextPath()+"/Noticias");
	}

}
