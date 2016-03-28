package es.unex.giiis.pi.controller;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import es.unex.giiis.pi.helper.DateTimeHelper;
import es.unex.giiis.pi.model.Order;
import es.unex.giiis.pi.model.User;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet(
		urlPatterns = { "/orders/OrderServlet" }
		)

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = 
			Logger.getLogger(HttpServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		logger.info("Atendiendo GET");
		HttpSession session = request.getSession();
		
		logger.info("Session id: "+session.getId());
		logger.info("Session new? "+session.isNew());
		logger.info("Session creation time: "+DateTimeHelper.time2Date(session.getCreationTime()));
		logger.info("Session last accessed time: "+DateTimeHelper.time2Date(session.getLastAccessedTime()));
		logger.info("Session max inactive time: "+DateTimeHelper.time2Date(session.getMaxInactiveInterval()));
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Order.jsp");
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
		
		
		
		Order order = new Order();
		order.setName(user.getName());
		order.setEmail(user.getEmail());
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

		logger.info("Nombre cliente: "+order.getName());
		
		Map<String, String> messages = new HashMap<String, String>();
		if (order.validate(messages)) {
			session.setAttribute("order",order);
			response.sendRedirect("CheckOrderServlet");
		} 
		else {
			request.setAttribute("messages",messages);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Order.jsp");
			view.forward(request,response);
		}	
		
	}
	
		
		
		
		
	}

