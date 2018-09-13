package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import dto.UserDTO;

public class UserDAOImpl extends DAOImpl implements UserDAO{
	//ATTRIBUTES
	private final String GET = "SELECT * FROM users WHERE id = ?";
	private final String ADD = "INSERT INTO users( username, name, lastname1, lastname2, birthdate, active ) VALUES (?, ?, ?, ?, ?, ?)";
	private final String EDIT = "UPDATE users SET username = ?, name = ?, lastname1 = ?, lastname2 = ?, birthdate = ?, active = ? WHERE id = ?";
	private final String REMOVE = "DELETE FROM users WHERE id = ?";
	private final String GET_ALL = "SELECT * FROM users";
	private final String REMOVE_ALL = "DELETE FROM users";
	
	//METHODS
	//CONSTRUCTS
	public UserDAOImpl() throws Exception{
		super();
	}
	
	//ADD
	public boolean add( UserDTO user ) throws Exception{
		//VARIABLES
		boolean result = false;
		
		try{
			//PREPARED STATEMENT
			PreparedStatement ps = this.cn.prepareStatement( this.ADD );
			
			//SET PARAMETERS
			ps.setString( 1, user.getUsername() );
			ps.setString( 2, user.getName() );
			ps.setString( 3, user.getLastname1() );
			ps.setString( 4, user.getLastname2() );
			ps.setString( 5, user.getBirthdate().toString() );
			ps.setBoolean( 6, user.isActive() );
			
			//EXECUTE PREPARED STATEMENT
			ps.executeUpdate();
			
			//SET RESULT IN TRUE
			result = true;
		}
		catch( Exception e ){		
			//THROW EXCEPTION
			throw new Exception( e );
		}
		finally{			
			//RETURN RESULT
			return result;
		}
	}
	
	//EDIT
	public boolean edit( UserDTO user ) throws Exception{
		//VARIABLES
		boolean result = false;
		
		try{
			//PREPARED STATEMENT
			PreparedStatement ps = this.cn.prepareStatement( this.EDIT );
			
			//SET PARAMETERS
			ps.setString( 1, user.getUsername() );
			ps.setString( 2, user.getName() );
			ps.setString( 3, user.getLastname1() );
			ps.setString( 4, user.getLastname2() );
			ps.setString( 5, user.getBirthdate().toString() );
			ps.setBoolean( 6, user.isActive() );
			ps.setInt( 7, user.getId() );
			
			//EXECUTE PREPARED STATEMENT
			ps.executeUpdate();
			
			//SET RESULT IN TRUE
			result = true;
		}
		catch( Exception e ){		
			//THROW EXCEPTION
			throw new Exception( e );
		}
		finally{			
			//RETURN RESULT
			return result;
		}
	}
	
	//GET
	public UserDTO get( int id ) throws Exception{
		//VARIABLES
		UserDTO user = null;
		
		try{
			//PREPARED STATEMENT
			PreparedStatement ps = this.cn.prepareStatement( this.GET );
			
			//SET PARAMETERS
			ps.setInt( 1, id );
			
			//EXECUTE PREPARED STATEMENT
			ResultSet rs = ps.executeQuery();
			
			//CHECK IF THERE ARE RESULTS
			if( rs.next() ){
				//CREATE USER
				user = new UserDTO( 
						rs.getInt( "id" ), 
						rs.getString( "username" ), 
						rs.getString( "name" ), 
						rs.getString( "lastname1" ), 
						rs.getString( "lastname2" ),
						LocalDate.parse( rs.getString( "birthdate" ) ),
						rs.getBoolean( "active" ) );
			}
		}
		catch( Exception e ){		
			//THROW EXCEPTION
			throw new Exception( e );
		}
		finally{			
			//RETURN USER
			return user;
		}
	}
	
	//REMOVE
	public boolean remove( int id ) throws Exception{
		//VARIABLES
		boolean result = false;
		
		try{
			//PREPARED STATEMENT
			PreparedStatement ps = this.cn.prepareStatement( this.REMOVE );
			
			//SET PARAMETERS
			ps.setInt( 1, id );
			
			//EXECUTE PREPARED STATEMENT
			ps.executeUpdate();
			
			//SET RESULT IN TRUE
			result = true;
		}
		catch( Exception e ){		
			//THROW EXCEPTION
			throw new Exception( e );
		}
		finally{			
			//RETURN RESULT
			return result;
		}
	}
	
	//GET ALL
	public List<UserDTO> getAll() throws Exception{
		//VARIABLES
		List<UserDTO> users = new ArrayList<UserDTO>();
		
		try{
			//PREPARED STATEMENT
			PreparedStatement ps = this.cn.prepareStatement( this.GET_ALL );
			
			//EXECUTE PREPARED STATEMENT
			ResultSet rs = ps.executeQuery();
			
			//CHECK IF THERE ARE RESULTS
			while( rs.next() ){
				//CREATE USER
				UserDTO user = new UserDTO( 
						rs.getInt( "id" ), 
						rs.getString( "username" ), 
						rs.getString( "name" ), 
						rs.getString( "lastname1" ), 
						rs.getString( "lastname2" ),
						LocalDate.parse( rs.getString( "birthdate" ) ),
						rs.getBoolean( "active" ) );
				
				//ADD USER TO LIST
				users.add( user );
			}
		}
		catch( Exception e ){		
			//THROW EXCEPTION
			throw new Exception( e );
		}
		finally{			
			//RETURN USER
			return (List<UserDTO>) users;
		}
	}
	
	//REMOVE ALL
	public boolean removeAll() throws Exception{
		//VARIABLES
		boolean result = false;
		
		try{
			//PREPARED STATEMENT
			PreparedStatement ps = this.cn.prepareStatement( this.REMOVE_ALL );
			
			//EXECUTE PREPARED STATEMENT
			ps.executeUpdate();
			
			//SET RESULT IN TRUE
			result = true;
		}
		catch( Exception e ){		
			//THROW EXCEPTION
			throw new Exception( e );
		}
		finally{			
			//RETURN RESULT
			return result;
		}
	}
	
	//DESCTRUCTOR
	@Override
	public void finalize()  throws Exception{
		//CLOSE CONNECTION
		this.off();
	}
}
