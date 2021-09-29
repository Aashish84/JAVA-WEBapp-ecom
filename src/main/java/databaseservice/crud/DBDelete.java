package databaseservice.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import databaseservice.DBConnection;
import pojo.Category;
import pojo.Product;

public class DBDelete {
	int i=0;
	public DBDelete (Category c){
		String query = "delete from category where id = ?";
		DBConnection ob = new DBConnection();
		Connection con = ob.getCon();
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,c.getId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public DBDelete (Product p){
		String query = "delete from product where id = ?";
		DBConnection ob = new DBConnection();
		Connection con = ob.getCon();
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,p.getId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public boolean deleteReport() {
		return i!=0 ;
	}
}
