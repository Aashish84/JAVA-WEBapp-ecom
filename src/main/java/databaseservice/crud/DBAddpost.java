package databaseservice.crud;


import java.sql.*;
import databaseservice.DBConnection;
import pojo.Category;
import pojo.Product;

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
	public DBAddpost(Product p) {
		String query = "insert into product (name,category_id,status,price,discount,inventory,image,created_at,updated_at) values(?,?,?,?,?,?,?,?,?)";
		DBConnection ob = new DBConnection();
		Connection con = ob.getCon();
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,p.getName());
			pstmt.setInt(2, p.getCategory_id());
			pstmt.setBoolean(3, p.isStatus());
			pstmt.setInt(4, p.getPrice());
			pstmt.setInt(5, p.getDiscount());
			pstmt.setInt(6, p.getInventory());
			pstmt.setString(7, p.getImage());
			pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean addReport() {
		return i!=0;
	}
	
}
