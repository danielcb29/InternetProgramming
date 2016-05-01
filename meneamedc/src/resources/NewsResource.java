package resources;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import dao.JDBCNewsDAOImpl;
import dao.NewsDAO;
import resources.exceptions.*;
import model.News;

@Path("/noticias")
public class NewsResource {
	
	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
	
	@GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<News> getNewListJSON() {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		NewsDAO newDao = new JDBCNewsDAOImpl();
		newDao.setConnection(conn);
		
		List<News> noticias = newDao.getAll();	
		
	    return noticias; 
	  }
	
	@GET
	  @Path("/{categoria: .*}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<News> getNewsCategoryJSON(@PathParam("categoria") String categoria) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		NewsDAO newDao = new JDBCNewsDAOImpl();
		newDao.setConnection(conn);
		
		List<News> noticias = newDao.getAllByCategory(categoria);	
		
	    return noticias; 
	  }
	
	@GET
	  @Path("/owner/{owner: [0-9]+}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<News> getNewsOwnerJSON(@PathParam("owner") long owner) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		NewsDAO newDao = new JDBCNewsDAOImpl();
		newDao.setConnection(conn);
		
		List<News> noticias = newDao.getAllByOwner(owner);	
		
	    return noticias; 
	  }
	
	@GET
	  @Path("/{newid: [0-9]+}")	  
	  @Produces(MediaType.APPLICATION_JSON)
	  public News getNewJSON(@PathParam("newid") long newid) {
		  
		Connection conn = (Connection) sc.getAttribute("dbConn");
		NewsDAO newDao = new JDBCNewsDAOImpl();
		newDao.setConnection(conn);
		
		News noticia = newDao.get(newid);
		if (noticia == null) {
		   throw new CustomNotFoundException("New ("+ newid + ") is not found");
		   
		  }
		
	    return noticia; 
	  }
	
	//POST inserta nueva noticia
	  @POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response postNew(News noticia, @Context HttpServletRequest request) throws Exception{
			Response response = null;
			System.out.println("post noticia rest");
			Connection conn = (Connection)sc.getAttribute("dbConn");
			NewsDAO newDao = new JDBCNewsDAOImpl();
			newDao.setConnection(conn);
						
			logger.info("Registrando noticia por API REST");
			long id = newDao.add(noticia);
			logger.info("Nueva noticia registrada");
			
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
	  
	//PUT que actualiza a partir del objeto recibido
	  @PUT
	  @Path("/{newid: [0-9]+}")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response putNew(News noticiaUp, @PathParam("newid") long newid) throws Exception{
			Response response = null;
			
			Connection conn = (Connection)sc.getAttribute("dbConn");
			NewsDAO newDao = new JDBCNewsDAOImpl();
			newDao.setConnection(conn);
						
			
			//Comprobamos que existe la orden
			News noticia = newDao.get(noticiaUp.getId());
			if(noticia != null){
				if (noticia.getId()!=newid)
					{
					throw new CustomBadRequestException("Error in id");
					}
				else 
				{
						logger.info("Actualizando noticia REST");
						newDao.save(noticiaUp);
					  
				}
			}
				
			else{
				
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			}			
			return response;
			
		}
	  
	  @DELETE
	  @Path("/{newid: [0-9]+}")	  
	  public Response deleteOrder(@PathParam("newid") long newid) {
		  
		Connection conn = (Connection) sc.getAttribute("dbConn");
		NewsDAO newDao = new JDBCNewsDAOImpl();
		newDao.setConnection(conn);
		
		newDao.delete(newid);
		
	    return Response.noContent().build(); //204 no content 
	  }

}