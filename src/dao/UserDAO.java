package dao;

import java.util.List;
import dto.UserDTO;

public interface UserDAO extends DAO{
	//ADD
	boolean add( UserDTO user ) throws Exception;
	
	//EDIT
	boolean edit( UserDTO user ) throws Exception;
	
	//GET
	UserDTO get( int id ) throws Exception;
	
	//REMOVE
	boolean remove( int id ) throws Exception;
	
	//GET ALL
	List<UserDTO> getAll() throws Exception;
	
	//REMOVE ALL
	boolean removeAll() throws Exception;
}
