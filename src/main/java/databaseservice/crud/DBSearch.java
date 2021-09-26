package databaseservice.crud;

import java.sql.*;

import databaseservice.DBConnection;
import pojo.User;

public class DBSearch {	
	
	public Boolean isAdmin(User u){
        DBConnection ob = new DBConnection();
        Connection con = ob.getCon();
        if(con==null) {
        	System.out.println("database not connected");
        }
        else {
        	try {
        		String query = "select value from roles where id in (select id from user where email = ? and password = ?) ";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString (1,u.getEmail());
                pstmt.setString(2, u.getPwd());
                ResultSet rs = pstmt.executeQuery();
                if(rs.next() && rs.getString(1).equalsIgnoreCase("admin")){
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
        return false;
    }

	public boolean isUser(User u) {
		DBConnection ob = new DBConnection();
        Connection con = ob.getCon();
        if(con==null) {
        	System.out.println("database not connected");
        }
        else {
        	try {
        		String query = "select id from user where email = ? and password = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString (1,u.getEmail());
                pstmt.setString(2, u.getPwd());
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
        return false;
	}
	
}