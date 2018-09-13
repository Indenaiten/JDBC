package test;

import java.time.LocalDate;
import java.util.List;

import dao.UserDAO;
import dao.UserDAOImpl;
import dto.UserDTO;

public class Test01 {

	public static void main(String[] args) {
		//VARIABLES
		UserDAO dao = null;
		int lastInsert = 0;
		
		//ADD
		try{
			//INSTANCE OF DAOT
			dao = new UserDAOImpl();
			
			//CREATE USER
			UserDTO user = new UserDTO( "pepito", "Pepe", "Flores", "Florin", LocalDate.now(), true );

			//ADD USER
			boolean resultAdd = dao.add( user );
			
			//CHECK RESULT
			if( resultAdd ){
				//SHOW MESSAGE
				System.out.println( "Added user !" );
			}
			else{
				//SHOW MESSAGE
				System.out.println( "Not added user !" );
			}
		}
		catch( Exception e ){
			//SHOW ERROR MESSAGE
			e.printStackTrace();
		}
		
		//GET AND EDIT
		try{	
			//GET USER 1
			UserDTO user = dao.get( 1 );
			
			//SHOW USER
			System.out.println( "\nGet user 1\n" + user );
			
			//CHANGE NAME
			user.setUsername( "PaquitoElChocolatero!" );
			
			//EDIT USER
			boolean resultEdit = dao.edit( user );
			
			//CHECK RESULT
			if( resultEdit ){
				//SHOW MESSAGE
				System.out.println( "\nEdited user 1 !" );
			}
			else{
				//SHOW MESSAGE
				System.out.println( "\nNot edited user 1 !" );
			}
		}
		catch( Exception e ){
			//SHOW ERROR MESSAGE
			e.printStackTrace();
		}
		
		//GET ALL
		try{	
			//GET ALL USERS
			List<UserDTO> users = dao.getAll();
			
			//SHOW USERS
			System.out.println( "\n--- All USERS ---" );
			System.out.println( "----------------------------------------" );
			for( UserDTO x : users ){
				System.out.println( x );
			}
			
			//SET LAST INSERT
			lastInsert = users.get( users.size()-1 ).getId();
		}
		catch( Exception e ){
			//SHOW ERROR MESSAGE
			e.printStackTrace();
		}
		
		//REMOVE
		try{
			//REMOVE LAST USER
			boolean resultRemove = dao.remove( lastInsert );
			
			//CHECK RESULT
			if( resultRemove ){
				//SHOW MESSAGE
				System.out.println( "\nRemoved last user !" );
			}
			else{
				//SHOW MESSAGE
				System.out.println( "\nNot removed last user !" );
			}
		}
		catch( Exception e ){
			//SHOW ERROR MESSAGE
			e.printStackTrace();
		}
		
		//GET AND EDIT
		try{	
			//GET USER 1
			UserDTO user = dao.get( 1 );
			
			//SHOW USER
			System.out.println( "\nGet user 1\n" + user );
			
			//CHANGE NAME
			user.setUsername( "Pepe" );
			
			//EDIT USER
			boolean resultEdit = dao.edit( user );
			
			//CHECK RESULT
			if( resultEdit ){
				//SHOW MESSAGE
				System.out.println( "\nEdited user 1 !" );
			}
			else{
				//SHOW MESSAGE
				System.out.println( "\nNot edited user 1 !" );
			}
		}
		catch( Exception e ){
			//SHOW ERROR MESSAGE
			e.printStackTrace();
		}
		
		//GET ALL
		try{	
			//GET ALL USERS
			List<UserDTO> users = dao.getAll();
			
			//SHOW USERS
			System.out.println( "\n--- All USERS ---" );
			System.out.println( "----------------------------------------" );
			for( UserDTO x : users ){
				System.out.println( x );
			}
		}
		catch( Exception e ){
			//SHOW ERROR MESSAGE
			e.printStackTrace();
		}
	}
}
