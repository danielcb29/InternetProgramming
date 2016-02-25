package pizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet(
		name = "OrderServlet",
		urlPatterns = {"/OrderServlet"},
		initParams = {
				@WebInitParam(name="shop",value="caceres")
		})
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String shop = getInitParameter("shop");
		System.out.println("shop: "+shop);
		System.out.println("User-agent: "+request.getHeader("User-agent"));
		System.out.println("Accept: "+request.getHeader("Accept"));
		System.out.println("Method: "+request.getMethod());
		System.out.println("Context-Path: "+request.getContextPath());
		System.out.println("email: "+request.getParameter("email"));
		response.getWriter().println("<!DOCTYPE html><html><body>Hello "+shop+"!</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		response.getWriter().println("<p>Thank you "+name+"!</p>");
	}

}
