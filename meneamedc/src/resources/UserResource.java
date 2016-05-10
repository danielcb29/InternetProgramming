package resources;

import java.sql.Connection;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;

import dao.UserDAO;
import dao.CommentDAO;
import dao.JDBCCommentDAOImpl;
import dao.JDBCUserDAOImpl;
import model.User;
import resources.exceptions.CustomBadRequestException;

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
	  }
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newUser(User usuario, @Context HttpServletRequest request) throws Exception{
		Response response;
		
		Connection conn = (Connection)sc.getAttribute("dbConn");
		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		logger.info("Registro de usuario por rest ");
		long id = userDao.add(usuario);
		
		response = Response //return 201
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

		return response;
	}
	
	@PUT
	@Path("/{userid: [0-9]+}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editUser(User newusuario, @PathParam("userid") long userid,@Context HttpServletRequest request) throws Exception{
		Response response;

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user==null){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		Connection conn = (Connection)sc.getAttribute("dbConn");
		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		
		User usuario = userDao.get(newusuario.getId());
		if(usuario!=null){
			if(usuario.getId()!=userid){
				throw new CustomBadRequestException("Error en id");
			}else{
				userDao.save(newusuario);
			}
		}else{
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		
		
		
		response = Response //return 201
				  .created(
						  uriInfo
						  .getAbsolutePathBuilder()
						  .path(Long.toString(userid))
						  .build())
				  .contentLocation(
						  uriInfo
						  .getAbsolutePathBuilder()
						  .path(Long.toString(userid))
						  .build())
				  .build();	

		return response;
	}
	
	@DELETE
	@Path("/{userid: [0-9]+}")	  
	public Response deleteUsuario(@PathParam("userid") long userid) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);

		userDao.delete(userid);

		return Response.noContent().build(); //204 no content 
	}
}
