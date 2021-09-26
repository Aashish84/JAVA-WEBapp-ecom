package databaseservice;

import java.sql.*;

public class DBConnection{
    private Connection con;
    
    public DBConnection(){
        DBInfo ob = new DBInfo();
        try {
        	try {
        		Class.forName("com.mysql.jdbc.Driver");
        	} catch (ClassNotFoundException e) {
        		e.printStackTrace();
        	} 
        	con = DriverManager.getConnection(ob.getDburl()+""+ob.getDbname(), ob.getDbusername(), ob.getDbpassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	public Connection getCon() {
		return con;
	}
}