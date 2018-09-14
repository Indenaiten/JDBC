package facade;

import java.util.List;

import dao.UserDAO;
import dao.UserDAOImpl;
import dto.UserDTO;

public class UserFacadeImpl implements UserFacade{
	//ATTRIBUTES
	private UserDAO dao = new UserDAOImpl();
	
	//METHODS
	//CONSTRUCTS
	public UserFacadeImpl() throws Exception{

	}
	
	//ADD 
	public boolean add( UserDTO user ) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			this.dao.add( user );
			
			//SET RESULT IN TRUE
			result = true;
		}
		catch( Exception e ){
			//THROW EXCEPTION
			throw new Exception( e );
		}
		
		//RETURN RESULT
		return result;
	}
	
	//EDIT
	public boolean edit( UserDTO user ) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			this.dao.edit( user );
			
			//SET RESULT IN TRUE
			result = true;
		}
		catch( Exception e ){
			//THROW EXCEPTION
			throw new Exception( e );
		}
		
		//RETURN RESULT
		return result;
	}
	
	//FIND BY ID
	public UserDTO findById( int id ) throws Exception {
		//VARIABLES
		UserDTO result;
		
		try{
			//ADD USER
			result = this.dao.get( id );
		}
		catch( Exception e ){
			//THROW EXCEPTION
			throw new Exception( e );
		}
		
		//RETURN RESULT
		return result;
	}
	
	//REMOVE
	public boolean remove( int id ) throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			this.dao.remove( id );
			
			//SET RESULT IN TRUE
			result = true;
		}
		catch( Exception e ){
			//THROW EXCEPTION
			throw new Exception( e );
		}
		
		//RETURN RESULT
		return result;
	}
	
	//FIND ALL
	public List<UserDTO> findAll() throws Exception {
		//VARIABLES
		List<UserDTO> result;
		
		try{
			//ADD USER
			result = this.dao.getAll();
		}
		catch( Exception e ){
			//THROW EXCEPTION
			throw new Exception( e );
		}
		
		//RETURN RESULT
		return result;
	}
	
	//REMOVE ALL
	public boolean removeAll() throws Exception {
		//VARIABLES
		boolean result = false;
		
		try{
			//ADD USER
			this.dao.removeAll();
			
			//SET RESULT IN TRUE
			result = true;
		}
		catch( Exception e ){
			//THROW EXCEPTION
			throw new Exception( e );
		}
		
		//RETURN RESULT
		return result;
	}
}
