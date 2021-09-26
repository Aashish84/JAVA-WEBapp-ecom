package databaseservice.crud;


import java.sql.*;
import databaseservice.DBConnection;
import pojo.Category;

public class DBAddpost {
	int i = 0;
	public DBAddpost(Category c) {
		String query = "insert into category (name,status,created_at,updated_at) values(?,?,?,?)";
		DBConnection ob = new DBConnection();
		Connection con = ob.getCon();
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, c.getName());
			pstmt.setBoolean(2, c.isStatus());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean addReport() {
		if(i!=0) {
			return true;
		}
		return false;
	}
	
}
