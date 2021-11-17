package databaseservice.crud;


import java.sql.*;
import java.util.ArrayList;

import controller.product.CartList;
import databaseservice.DBConnection;
import pojo.Category;
import pojo.Customer;
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
	
	public DBAddpost(Customer cs) {
		CartList cl = CartList.getInstance();
		if(cl.getList().size()==0) {
			System.out.println("returned");
			i=0;
			return;
		}
		String query = "insert into customer (name,contact,email,address,status,created_at,updated_at) values(?,?,?,?,?,?,?)";
		DBConnection ob = new DBConnection();
		Connection con = ob.getCon();
		try {
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,cs.getName());
			pstmt.setDouble(2, cs.getContact());
			pstmt.setString(3, cs.getEmail());
			pstmt.setString(4, cs.getAddress());
			pstmt.setBoolean(5, cs.isStatus());
			pstmt.setDouble(6, ts.getTime());
			pstmt.setTimestamp(7, ts);
			i = pstmt.executeUpdate();
			
			DBDisplay obdisplay = new DBDisplay("customer" , "where created_at = '"+ts.getTime()+"'");
			ArrayList<Customer> tmplist = obdisplay.displayAllCustomer();
			
			if(tmplist.size() == 1) {
				cs = tmplist.get(0);
				query = "insert into ordereditem (customer_id,product_id,quantity,created_at,updated_at) values(?,?,?,?,?)";
				for(int j = 0 ; j < cl.getList().size() ; j++) {
					int []tmp = cl.getList().get(j);
					PreparedStatement pstmt2 = con.prepareStatement(query);
					pstmt2.setInt(1,cs.getId());
					pstmt2.setInt(2, tmp[0]);
					pstmt2.setInt(3, tmp[1]);
					pstmt2.setTimestamp(4, ts);
					pstmt2.setTimestamp(5, ts);
					i += pstmt2.executeUpdate();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean addReport() {
		return i!=0;
	}
}
