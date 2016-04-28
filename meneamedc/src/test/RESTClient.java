package test;

import java.net.URI;
import java.sql.Time;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;
import model.News;

public class RESTClient {
	
	@Context
	static ServletContext sc;
	  
	  private static URI getBaseURI() {
		  	return UriBuilder.fromUri("http://localhost:8080/meneamedc").build();
	  }
	  
	  private static void testComment(WebTarget target){
		  Response response;
		 
		  Form form =new Form();
		  form.param("text", "Si señor comentario rest");
		  
		// Probamos el POST
		    response = 
		    		target
		    		.path("rest")
		    		.path("comentarios?id=2")
		    		.request()
		    		.post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),Response.class);
		    
		 // Debe devolver 201 == created resource
		    System.out.println("Form response " +response.toString());
		    //Consultamos la URI del nuevo recurso creado
		    System.out.println("Form response Location" +response.getLocation());
		  
	  }
	  
	  private static void noticiaComment(WebTarget target){
		  Response response;
			
			String json = "{\"category\":\"deporte\","
					+ "\"dateStamp\":\"2016-04-09\","
					+ "\"hits\":2,"
					+ "\"id\":20"
					+ ",\"likes\":4,"
					+ "\"owner\":8,"
					+ "\"text\":\"El Centro Pompidou acoge la mayor retrospectiva desde 1969 sobre uno de los genios del siglo XX. 230 obras conforman el viaje por la obra del pintor suizo\","
					+ "\"timeStamp\":\"18:37:01\","
					+ "\"title\":\"Paul Klee en París: el arte como antídoto contra la certidumbre\","
					+ "\"url\":\"http://cultura.elpais.com/cultura/2016/04/08/actualidad/1460124118_326536.html\"}";
			
			News noticia = new News();
			noticia.setOwner(8);
			
			Date hoy = new Date();
			noticia.setDateStamp(hoy);
			
			Time yaMismo = new Time(hoy.getTime());
			noticia.setTimeStamp(yaMismo);
			
			noticia.setTitle("Paul Klee en París: el arte como antídoto contra la certidumbre");
			noticia.setText("El Centro Pompidou acoge la mayor retrospectiva desde 1969 sobre uno de los genios del siglo XX. 230 obras conforman el viaje por la obra del pintor suizo");
			noticia.setUrl("http://cultura.elpais.com/cultura/2016/04/08/actualidad/1460124118_326536.html");
			noticia.setHits(0);
			noticia.setLikes(0);
			noticia.setCategory("deporte");
			response = target.path("rest").path("noticias").request(MediaType.APPLICATION_JSON).post(Entity.entity(noticia,MediaType.APPLICATION_JSON),Response.class);
		    
			System.out.println(response.getStatus());
	  }
	
	public static void main(String[] args){
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		
		WebTarget target = client.target(getBaseURI());
		testComment(target);
		
		
		
		
	}
}
