package databaseservice.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import databaseservice.DBConnection;
import pojo.Category;

public class DBUpdatepost {
	int i = 0;
	public DBUpdatepost(Category b){
		if(b.getName()!=null) {
			String query = "update category set name = ? , status = ?,updated_at = ? where id = ?";
			DBConnection ob = new DBConnection();
			Connection con = ob.getCon();
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1,b.getName());
				pstmt.setBoolean(2, b.isStatus());
				pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
				pstmt.setInt(4, b.getId());
				i =pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean updateReport() {
		return i!=0 ;
	}
}
