package facade;

import java.util.List;

import dto.UserDTO;

public interface UserFacade {
	//ADD
	boolean add( UserDTO user ) throws Exception;
	
	//EDIT
	boolean edit( UserDTO user ) throws Exception;
	
	//FIND BY ID
	UserDTO findById( int id ) throws Exception;
	
	//REMOVE
	boolean remove( int id ) throws Exception;
	
	//FIND ALL
	List<UserDTO> findAll() throws Exception;
	
	//REMOVE ALL
	boolean removeAll() throws Exception;
}
