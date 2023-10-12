package db;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import db.DBConnection;

public class DBConnection {

	private Connection connection = null;
	private static DBConnection dbConnection;

	
	private static final String serverAddress = "jdbc:sqlserver://hildur.ucn.dk";
	private static final String databaseName = ";databaseName = DMA-CSD-V23_10478728";
	
	private static String userName = ";user=DMA-CSD-V23_10478728";
	private static String password = ";password=Password1!";
	private static String encryption = ";encrypt=false";
	
	private DatabaseMetaData dma;
	private static Connection con;
	 
	    private static DBConnection  instance = null;

	    private DBConnection()
	    {
	    	String url = serverAddress+ databaseName + userName + password + encryption;
	    	System.out.println("URL: " + url);

	        try{
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            System.out.println("Driver class loaded ok");
	          
	        }
	        catch(Exception e){
	            System.out.println("Cannot find the driver");
	            System.out.println(e.getMessage());
	        }
	        try{
	            con = DriverManager.getConnection(url);
	            con.setAutoCommit(true);
	            dma = con.getMetaData(); // get meta data
	            System.out.println("Connection to " + dma.getURL());
	            System.out.println("Driver " + dma.getDriverName());
	            System.out.println("Database product name " + dma.getDatabaseProductName());
	        }
	        catch(Exception e){
	            System.out.println("Problems with the connection to the database:");
	            System.out.println(e.getMessage());
	            System.out.println(url);
	        }
	    }
		   
	    public static void closeConnection()
	    {
	       	try{
	            con.close();
	            instance= null;
	            System.out.println("The connection is closed");
	        }
	         catch (Exception e){
	            System.out.println("Error trying to close the database " +  e.getMessage());
	         }
	       	
	         }

	    public Connection getDBcon()
	    {
	       return con;
	    }

	    public static boolean instanceIsNull()
	    {
	       return (instance == null);
	    }    

	    public static DBConnection getInstance()
	    {
	        if (instance == null)
	        {
	          instance = new DBConnection();
	        }
	        return instance;
	    }
	    public static boolean getOpenStatus() {
	    	boolean isOpen = false;
	    	try {
	    		isOpen = (!con.isClosed());
	    	} catch (Exception sclExc) {
	    		isOpen = false;
	    	}
	    	return isOpen;
	    }
	    	
	    	
	        public static void main(String[] args) {
	            DBConnection dbConn = DBConnection.getInstance();
	            if (dbConn.getDBcon() != null) {
	                System.out.println("Successfully connected to the database!");
	            } else {
	                System.out.println("Failed to connect to the database.");
	            }
	            DBConnection.closeConnection(); // Jeg ved ikke om vi burde lukke connectionen her.
	        
	    
	 
	    	
	 
	    }	 
	 
}
