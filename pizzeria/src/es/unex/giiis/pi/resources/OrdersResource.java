package es.unex.giiis.pi.resources;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import es.unex.giiis.pi.dao.JDBCOrderDAOImpl;
import es.unex.giiis.pi.dao.OrderDAO;
import es.unex.giiis.pi.model.Order;
import es.unex.giiis.pi.model.User;
import es.unex.giiis.pi.resources.exceptions.CustomBadRequestException;
import es.unex.giiis.pi.resources.exceptions.CustomNotFoundException;

@Path("/orders")
public class OrdersResource {

	  @Context
	  ServletContext sc;
	  @Context
	  UriInfo uriInfo;
  
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<Order> getOrdersJSON(@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		OrderDAO orderDao = new JDBCOrderDAOImpl();
		orderDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		List<Order> orders = orderDao.get(user.getName());	
		
	    return orders; 
	  }
	  
	  @GET
	  @Path("/{orderid: [0-9]+}")	  
	  @Produces(MediaType.APPLICATION_JSON)
	  public Order getOrderJSON(@PathParam("orderid") long orderid,@Context HttpServletRequest request) {
		  
		Connection conn = (Connection) sc.getAttribute("dbConn");
		OrderDAO orderDao = new JDBCOrderDAOImpl();
		orderDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		Order order = orderDao.get(orderid);
		if ((order == null) || (!order.getName().equals(user.getName()))) {
		   throw new CustomNotFoundException("Order ("+ orderid + ") is not found");
		   
		  }
		
	    return order; 
	  }
	  
	 
	  
	  @POST	  	  
	  @Consumes(MediaType.APPLICATION_JSON)
	  public Response post(Order newOrder, @Context HttpServletRequest request) throws Exception {	
		  
		 
			
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			
			  if (user!=null)
					System.out.println("usuario: "+user.getName());
			  
		  Response res;
		  Connection conn = (Connection) sc.getAttribute("dbConn");
		  OrderDAO orderDao = new JDBCOrderDAOImpl();
		  orderDao.setConnection(conn);

		  Map<String, String> messages = new HashMap<String, String>();
		  if (!newOrder.validate(messages))
				  throw new CustomBadRequestException("Errors in parameters");
		  //save order in DB
		  long id = orderDao.add(newOrder);

		  res = Response //return 201 and Location: /orders/newid
				  .created(
						  uriInfo
						  .getAbsolutePathBuilder()
						  .path(Long.toString(id))
						  .build())
				  .contentLocation(
					      uriInfo
						  .getAbsolutePathBuilder()
						  .path(Long.toString(id))
						  .build())
				  .build();

		  return res; 
	  }
	  
	  //PUT que actualiza a partir del objeto recibido
	  @PUT
	  @Path("/{orderid: [0-9]+}")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response put(Order orderUpdate, @PathParam("orderid") long orderid,@Context HttpServletRequest request) throws Exception{
			Response response = null;
			
			Connection conn = (Connection)sc.getAttribute("dbConn");
			OrderDAO orderDao = new JDBCOrderDAOImpl();
			orderDao.setConnection(conn);
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			
			//Comprobamos que existe la orden
			Order order = orderDao.get(orderUpdate.getId());
			if(order != null){
				if ((order.getId()!=orderid) || (!order.getName().equals(user.getName())))
					{
					throw new CustomBadRequestException("Error in id");
					}
				else 
				{
					Map<String, String> messages = new HashMap<String, String>();
					if (orderUpdate.validate(messages)){
						orderDao.save(orderUpdate);
						
					}
					else {
							
						throw new CustomBadRequestException("Errors in parameters");
						
					}
					  
				}
			}
				
			else{
				
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			}			
			return response;
			
		}
	  
	  
	  

	@DELETE
	  @Path("/{orderid: [0-9]+}")	  
	  public Response deleteOrder(@PathParam("orderid") long orderid,@Context HttpServletRequest request) {
		  
		Connection conn = (Connection) sc.getAttribute("dbConn");
		OrderDAO orderDao = new JDBCOrderDAOImpl();
		orderDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		Order order = orderDao.get(orderid);
		
		if(order != null){
			if (order.getName().equals(user.getName()))
				{
			orderDao.delete(orderid);
		    return Response.noContent().build(); //204 no content 
				}
			else
			{
				throw new CustomBadRequestException("Error in user");
			}
		}
		else
			{
				throw new CustomBadRequestException("Error in id");
			}
			
		
			
			
			
	  }
	  
} 
