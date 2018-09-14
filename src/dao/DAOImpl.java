package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class DAOImpl implements DAO{
	//CONSTANTS
	private final String CONNECTION_DEFAULT = "connectionMySQL";
	
	//ATTRIBUTES
	protected Connection cn;
	private String nameOfConnection;
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	//CONSTRUCTS
	public DAOImpl() throws Exception{
		//SET DEFAULT NAME OF CONNECTION
		this.nameOfConnection = this.CONNECTION_DEFAULT;
		
		//CONNECT
		this.on();
	}
	
	//CONNECT
	private Connection connect() throws Exception{
		//PARSE XML DOCUMENT
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse( "config/database.xml" );
		doc.getDocumentElement().normalize();
		
		//GET ALL CONNECTIONS
		NodeList connections = doc.getElementsByTagName( "connection" );
		
		//SEARCH CONNECTION
		boolean found = false;
		for( int i = 0 ; i < connections.getLength() && found == false ; i++ ){
			if( connections.item( i ).getAttributes().item(0).getNodeValue().equals( this.nameOfConnection ) &&
					connections.item( i ).getAttributes().item(0).getNodeName().equals( "name" ) ){
				//SAVE DATE IN VARIABLES
				this.driver = doc.getElementsByTagName( "driver" ).item(i).getTextContent();
				this.url = doc.getElementsByTagName( "url" ).item(i).getTextContent();
				this.user = doc.getElementsByTagName( "user" ).item(i).getTextContent();
				this.pass = doc.getElementsByTagName( "pass" ).item(i).getTextContent();
				
				//SET FOUND IN TRUE
				found = true;
			}
		}
		
		//DRIVER
		Class.forName( this.driver );
			
		//RETURN CONNECTION
		return DriverManager.getConnection( this.url, this.user, this.pass );
	}
	
	//ON CONNECTION
	public boolean on() throws Exception{
		//VARIABLES
		boolean result = false;
		
		//CHECK CONNECTION
		if( this.cn == null ){
			//SET CONNECTION
			this.cn = this.connect();
			
			//SET RESULT IN TRUE
			result = true;
		}
		
		//RETURN RESULT
		return result;
	}
	
	//OFF CONNECTION
	public boolean off() throws Exception{
		//VARIABLES
		boolean result = false;
		
		//CHECK CONNECTION
		if( this.cn != null ){
			//SET CONNECTION
			this.cn.close();
			
			//SET RESULT IN TRUE
			result = true;
		}
		
		//ABLE AUTOCOMMIT
		this.cn.setAutoCommit( true );
		
		//RETURN RESULT
		return result;
	}
	
	//BEGIN TRANSACTION
	public void beginTransaction() throws Exception{
		//DISABLE AUTOCOMMIT
		this.cn.setAutoCommit( false );
	}
	
	//COMMIT
	public void commit() throws Exception{
		//COMMIT
		this.cn.commit();
		
		//ABLE AUTOCOMMIT
		this.cn.setAutoCommit( true );
	}
	
	//ROLLBACK
	public void rollback() throws Exception{
		//ROLLBACK
		this.cn.rollback();
		
		//ABLE AUTOCOMMIT
		this.cn.setAutoCommit( true );
	}
}
