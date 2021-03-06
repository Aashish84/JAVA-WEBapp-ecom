package databaseservice.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import databaseservice.DBConnection;
import pojo.Category;
import pojo.Customer;
import pojo.Product;

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
	public DBUpdatepost(Product p){
		if(p.getName()!=null) {
			String query;
			if(p.getImage()==null) {
				query = "update product set name = ? , category_id = ?,status = ?,price = ?,discount = ?,inventory= ?,updated_at = ? where id = ?";
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
					pstmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
					pstmt.setInt(8, p.getId());
					System.out.print(p.getId());
					i =pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else {
				query = "update product set name = ? , category_id = ?,status = ?,price=? ,discount = ?,inventory=?,image=?,updated_at = ? where id = ?";
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
					pstmt.setInt(9, p.getId());
					i =pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public DBUpdatepost(Customer cs) {
		if(cs.getId()!=0) {
			String query = "update customer set status = ? where id = ?";
			DBConnection ob = new DBConnection();
			Connection con = ob.getCon();
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setBoolean(1,true);
				pstmt.setInt(2, cs.getId());
				i =pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			query = "update ordereditem set status = ? where customer_id = ?";
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setBoolean(1,true);
				pstmt.setInt(2, cs.getId());
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
