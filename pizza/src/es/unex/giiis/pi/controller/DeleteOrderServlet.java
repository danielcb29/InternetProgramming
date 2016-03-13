package es.unex.giiis.pi.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.unex.giiis.pi.dao.JDBCOrderDAOImpl;
import es.unex.giiis.pi.dao.OrderDAO;

/**
 * Servlet implementation class DeleteOrderServlet
 */
@WebServlet(
		urlPatterns = { "/DeleteOrderServlet" }
		)
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		OrderDAO orderDao = new JDBCOrderDAOImpl();
		orderDao.setConnection(conn);

		String id = request.getParameter("id");
		logger.info("get parameter id ("+id+")");

		if (id != null) 
		{
			Long oid = Long.parseLong(id); 
			logger.info("get parameter order id ("+request.getParameter("id")+") and casting "+oid);

			orderDao.delete(oid);
		}

		response.sendRedirect("ListOrderServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
