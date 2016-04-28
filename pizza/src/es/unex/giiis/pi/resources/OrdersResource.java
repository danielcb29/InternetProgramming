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
	  public List<Order> getOrdersJSON() {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		OrderDAO orderDao = new JDBCOrderDAOImpl();
		orderDao.setConnection(conn);
		
		List<Order> orders = orderDao.getAll();	
		
	    return orders; 
	  }
	  
	  @GET
	  @Path("/{orderid: [0-9]+}")	  
	  @Produces(MediaType.APPLICATION_JSON)
	  public Order getOrderJSON(@PathParam("orderid") long orderid) {
		  
		Connection conn = (Connection) sc.getAttribute("dbConn");
		OrderDAO orderDao = new JDBCOrderDAOImpl();
		orderDao.setConnection(conn);
		
		Order order = orderDao.get(orderid);
		if (order == null) {
		   throw new CustomNotFoundException("Order ("+ orderid + ") is not found");
		   
		  }
		
	    return order; 
	  }
	  
	  //POST que recibe datos de la nueva orden por formulario
	  @POST	  	  
	  @Consumes("application/x-www-form-urlencoded")
	  public Response post(@FormParam("topping") List<String> toppingList,
			  MultivaluedMap<String, String> formParams, @Context HttpServletRequest request) {	
		  
		 
			
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			
			  if (user!=null)
					System.out.println("usuario: "+user.getName());
			  
		  Response res;
		  Connection conn = (Connection) sc.getAttribute("dbConn");
		  OrderDAO orderDao = new JDBCOrderDAOImpl();
		  orderDao.setConnection(conn);

		  Order order = new Order();
		  order.setName(formParams.getFirst("name"));
		  order.setEmail(formParams.getFirst("email"));
		  order.setTel(formParams.getFirst("tel"));
		  order.setSize(formParams.getFirst("size"));
		  if (!toppingList.isEmpty()){
			  	String toppings=new String();
				Iterator<String> it = toppingList.iterator();
				toppings= it.next();
				while(it.hasNext()) toppings= toppings+" "+it.next();
				order.setToppings(toppings);
			}
			else order.setToppings(" ");
		  order.setDelivery(formParams.getFirst("delivery"));
			order.setComments(formParams.getFirst("comments"));

		  Map<String, String> messages = new HashMap<String, String>();
		  if (!order.validate(messages))
				  throw new CustomBadRequestException("Errors in parameters");
		  //save order in DB
		  long id = orderDao.add(order);

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
		public Response put(Order orderUpdate, @PathParam("orderid") long orderid) throws Exception{
			Response response = null;
			
			Connection conn = (Connection)sc.getAttribute("dbConn");
			OrderDAO orderDao = new JDBCOrderDAOImpl();
			orderDao.setConnection(conn);
						
			
			//Comprobamos que existe la orden
			Order order = orderDao.get(orderUpdate.getId());
			if(order != null){
				if (order.getId()!=orderid)
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
	  public Response deleteOrder(@PathParam("orderid") long orderid) {
		  
		Connection conn = (Connection) sc.getAttribute("dbConn");
		OrderDAO orderDao = new JDBCOrderDAOImpl();
		orderDao.setConnection(conn);
		
		orderDao.delete(orderid);
		
	    return Response.noContent().build(); //204 no content 
	  }
	  
} 
