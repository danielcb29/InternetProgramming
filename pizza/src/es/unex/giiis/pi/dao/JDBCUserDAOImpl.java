package es.unex.giiis.pi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import es.unex.giiis.pi.model.User;


public class JDBCUserDAOImpl implements UserDAO {

	private Connection conn;
	private static final Logger logger = Logger.getLogger(JDBCUserDAOImpl.class.getName());
	
	@Override
	public User get(long id) {
		if (conn == null) return null;
		
		User user = null;		
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Public.User WHERE id ="+id);			 
			if (!rs.next()) return null; 
			user  = new User();	 
			user.setId(rs.getLong("id"));
			user.setName(rs.getString("name"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setRole(rs.getString("role"));
			logger.info("fetching User: "+user.getId()+" "+user.getName()+" "+user.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public User get(String username) {
		if (conn == null) return null;
		
		User user = null;		
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Public.User WHERE username ='"+username+"'");			 
			if (!rs.next()) return null; 
			user  = new User();	 
			user.setId(rs.getLong("id"));
			user.setName(rs.getString("name"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setRole(rs.getString("role"));
			logger.info("fetching User: "+user.getId()+" "+user.getName()+" "+user.getUsername()+" @ "+user.getEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public long add(User user) {
		long id=-1;
		if (conn != null){

			Statement stmt;
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate("INSERT INTO User (name,username,email,password) VALUES('"
									+user.getName()+"','"
									+user.getUsername()+"','"
									+user.getEmail()+"','"
									+user.getPassword()+"','"
									+user.getRole()+"')",Statement.RETURN_GENERATED_KEYS);
				
				ResultSet genKeys = stmt.getGeneratedKeys();
				
				if (genKeys.next())
				    id = genKeys.getInt(1);
				
				
				logger.info("creating User("+id+"): "+user.getName()+" - username "+user.getUsername());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
	}

	@Override
	public void save(User user) {
		if (conn != null){

			Statement stmt;
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate("UPDATE User SET name='"+user.getName()
									+"', username='"+user.getUsername()
									+"', email='"+user.getEmail()
									+"', password='"+user.getPassword()
									+"', role='"+user.getRole()
									+"' WHERE id = "+user.getId());
				logger.info("updating User: "+user.getId()+" "+user.getName()+" "+user.getUsername());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(long id) {
		if (conn != null){

			Statement stmt;
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate("DELETE FROM User WHERE id ="+id);
				logger.info("updating User: "+id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void setConnection(Connection conn) {
		// TODO Auto-generated method stub
		this.conn = conn;
	}

	
}

