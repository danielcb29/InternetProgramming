package es.unex.giiis.pi.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
import es.unex.giiis.pi.model.User;

/**
 * Servlet implementation class DetailOrderServlet
 */
@WebServlet(
		urlPatterns = { "/orders/EditOrderServlet" }
		)
public class EditOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrderServlet() {
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
		if (order != null)
		  request.setAttribute("order",order);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/EditOrder.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		OrderDAO orderDao = new JDBCOrderDAOImpl();
		orderDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		User user= (User) session.getAttribute("user");
		
		
		
		Order order = new Order();
		if (user.getRole().equals("Administrador")) {
			order.setName(request.getParameter("name"));
			order.setEmail(request.getParameter("email"));
		}
		else {
		order.setName(user.getName());
		order.setEmail(user.getEmail());
		}
		order.setId( Long.parseLong(request.getParameter("id")));
		order.setTel(request.getParameter("tel"));
		order.setSize(request.getParameter("size"));
		if (request.getParameterValues("topping")!=null)
		{
			String toppings=new String();
			ArrayList<String> arrayToppings=new ArrayList<String>(Arrays.asList(request.getParameterValues("topping")));
			Iterator<String> it = arrayToppings.iterator();
			toppings= it.next();
			while(it.hasNext()) toppings= toppings+" "+it.next();
			order.setToppings(toppings);
			
		}
		else order.setToppings(" ");
		order.setDelivery(request.getParameter("delivery"));
		order.setComments(request.getParameter("comments"));
		
		Map<String, String> messages = new HashMap<String, String>();
		if (order.validate(messages)) {
			orderDao.save(order);
			response.sendRedirect("ListOrderServlet");
		} 
		else {
			request.setAttribute("messages",messages);
			request.setAttribute("order",order);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/EditOrder.jsp");
			view.forward(request,response);
		}	
	}

}