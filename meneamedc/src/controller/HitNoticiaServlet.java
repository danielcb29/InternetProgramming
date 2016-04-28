package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JDBCNewsDAOImpl;
import dao.NewsDAO;
import model.News;

/**
 * Servlet implementation class HitNoticiaServlet
 */
@WebServlet("/HitNoticia")
public class HitNoticiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HitNoticiaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		NewsDAO newDao = new JDBCNewsDAOImpl();
		newDao.setConnection(conn);
		
		long id = Long.parseLong(request.getParameter("id"));
		News noticia = newDao.get(id);
		int new_hit = noticia.getHits() + 1;
		noticia.setHits(new_hit);
		newDao.save(noticia);
		logger.info("Noticia hit");
		response.sendRedirect(noticia.getUrl());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
