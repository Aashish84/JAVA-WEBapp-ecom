package databaseservice.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databaseservice.DBConnection;
import pojo.Category;
import pojo.Customer;
import pojo.Ordereditem;
import pojo.Product;

public class DBDisplay {
	
	private String table;
	private String query;
	public DBDisplay(String table,String condition) {
		this.table = table;
		this.query = "select * from "+this.table+" "+condition;
	}
	public DBDisplay(String table) {
		this.table=table;
		this.query = "select * from "+this.table;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public void setTable(String table) {
		this.table = table;
	}
	
	public boolean isEmpty() {
		ResultSet rs = null;		
		DBConnection ob = new DBConnection();
		Connection con = ob.getCon();
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	private ResultSet displayAll() {
		ResultSet rs = null;		
		DBConnection ob = new DBConnection();
		Connection con = ob.getCon();
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ArrayList<Category> displayAllCategory() {
		ArrayList<Category> temp = new ArrayList<>();
		ResultSet rs = displayAll();
            try {
				while (rs.next()) {
					int bid = rs.getInt(1);
					String name = rs.getString(2); 
					boolean status =rs.getBoolean(3);
					Category cob = new Category(bid, name , status);
					temp.add(cob);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		return temp;
	}
	
	public Category displayOneCategory(int id) {
		query="select * from "+table+" where id=?";		
		Category temp = null ;
		DBConnection ob = new DBConnection();
		Connection con = ob.getCon();
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt(1);
				String name = rs.getString(2); 
				boolean status =rs.getBoolean(3);
				Category cob = new Category(id1, name , status);
				temp=cob;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	
	public ArrayList<Product> displayAllProduct(){
		ArrayList<Product> temp = new ArrayList<>();
		ResultSet rs = displayAll();
		
		try {
			while(rs.next()) {
				int pid = rs.getInt(1);
				String name = rs.getString(2);
				int cid = rs.getInt(3);
				boolean status = rs.getBoolean(4);
				int price = rs.getInt(5);
				int discount = rs.getInt(6);
				int inv = rs.getInt(7);
				String image = rs.getString(8);
				Product p = new Product(pid, name, cid, status,	price,discount, inv ,image);
				temp.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public Product displayOneProduct(int id) {
		query="select * from "+table+" where id=?";		
		Product temp = null ;
		DBConnection ob = new DBConnection();
		Connection con = ob.getCon();
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt(1);
				String name = rs.getString(2);
				int cid = rs.getInt(3);
				boolean status = rs.getBoolean(4);
				int price = rs.getInt(5);
				int discount = rs.getInt(6);
				int inv = rs.getInt(7);
				String image = rs.getString(8);
				Product p = new Product(pid, name, cid, status,price ,discount, inv ,image);
				temp = p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	

	public ArrayList<Customer> displayAllCustomer(){
		ArrayList<Customer> temp = new ArrayList<>();
		ResultSet rs = displayAll();
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double contact = rs.getDouble(3);
				String email = rs.getString(4);
				String address = rs.getString(5);
				boolean status = rs.getBoolean(6);
				Customer cs = new Customer(id, name, contact, email, address ,status);
				temp.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public ArrayList<Ordereditem> displayProductOfCustomer(Customer cs){
		ArrayList<Ordereditem> temp = new ArrayList<>();
		DBConnection conob = new DBConnection();
		Connection con = conob.getCon();
		
		query = "select * from ordereditem where customer_id= ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cs.getId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Ordereditem ob = new Ordereditem(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getBoolean(4)
						);
				temp.add(ob);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return temp;
	}
	
//	public ArrayList<Brand> displayAllCategory(String table) {
//		String query="select * from "+table;		
//		ArrayList<Brand> temp = new ArrayList<>();
//		DBConnection ob = new DBConnection();
//		Connection con = ob.getCon();
//		try {
//            PreparedStatement pstmt = con.prepareStatement(query);
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//            	int bid = rs.getInt(1);
//            	String name = rs.getString(2); 
//            	int cid = rs.getInt(3);
//            	Brand bob = new Brand(bid,name,cid);
//            	temp.add(bob);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//		return temp;
//	}
	
}
