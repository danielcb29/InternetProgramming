package resources;

import java.sql.Connection;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;

import dao.UserDAO;
import dao.CommentDAO;
import dao.JDBCCommentDAOImpl;
import dao.JDBCUserDAOImpl;
import model.User;

@Path("/usuarios")
public class UserResource {
	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
	
	@GET
	  @Path("/{user: [0-9]+}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public User getUserJSON(@PathParam("user") long user) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		UserDAO uDao = new JDBCUserDAOImpl();
		uDao.setConnection(conn);
		logger.info("Consultado usuario por rest id:"+user);
		User usuario = uDao.get(user);	
		
	    return usuario; 
	  }
	
	@GET
	  @Path("/karma/{user: [0-9]+}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Integer getUserKarma(@PathParam("user") long user) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		CommentDAO cDao = new JDBCCommentDAOImpl();
		cDao.setConnection(conn);
		logger.info("Consultado karma usuario por rest id:"+user);
		Integer karma = cDao.getAllByOwner(user).size();	
		
	    return karma; 
	  }
	
	@GET
	  @Path("/sesion")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response getSesionJSON(@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		UserDAO uDao = new JDBCUserDAOImpl();
		uDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		logger.info("Consultado usuario de sesion por rest ");
		
		if(user==null){
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).entity(user).build();
		//return user;
		
		
	  }
}
