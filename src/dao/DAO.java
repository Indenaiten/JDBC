package dao;

import java.sql.Connection;

public interface DAO {	
	//ON
	boolean on() throws Exception;
	
	//OFF
	boolean off() throws Exception;
	
	//BEGIN TRANSACTION
	void beginTransaction() throws Exception;
	
	//COMMIT
	void commit() throws Exception;
	
	//ROLLBACK
	void rollback() throws Exception;
}
