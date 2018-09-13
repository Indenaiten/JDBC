package dao;

import java.sql.Connection;

public interface DAO {	
	//ON
	boolean on() throws Exception;
	
	//OFF
	boolean off() throws Exception;
}
