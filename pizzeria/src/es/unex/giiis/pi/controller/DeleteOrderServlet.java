package es.unex.giiis.pi.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.unex.giiis.pi.dao.JDBCOrderDAOImpl;
import es.unex.giiis.pi.dao.OrderDAO;
import es.unex.giiis.pi.model.Order;

/**
 * Servlet implementation class DeleteOrderServlet
 */
@WebServlet(
		urlPatterns = { "/orders/DeleteOrderServlet" }
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
	long oid = 0;
	if (id != null) 
		oid = Long.parseLong(id); 
	
	logger.info("get parameter id ("+id+") and casting "+oid);
	
	Order order = orderDao.get(oid);
	if (order != null){
		HttpSession session = request.getSession();
	  session.setAttribute("order",order);
	
	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/DeleteOrder.jsp");
	view.forward(request,response);
	}
	else response.sendRedirect("ListOrderServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("Atendiendo POST");
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		OrderDAO orderDao = new JDBCOrderDAOImpl();
		orderDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		logger.info("Pedido confirmado con id de sesi�n: "+session.getId());
		Order order = (Order) session.getAttribute("order");
		
		
		if (order!=null) {
			orderDao.delete(order.getId());
			session.removeAttribute("order");
		}
			
		response.sendRedirect("ListOrderServlet");
	}

}
