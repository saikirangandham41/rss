package com.test.inventory.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.test.inventory.config.*;
import com.test.inventory.model.Product;

public class ProductCRUDRespository {
	public void insert_values(String itemId, String product_name, int quantity, String description) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
		try {
			String query = "insert into PRODUCT(ITEM_ID, qty, PRODUCT_NAME,DESCRIPTION) values(?,?,?,?)";
			ps = connection.prepareStatement(query);
			ps.setString(1, itemId);
			ps.setInt(2, quantity);
			ps.setString(3, product_name);
			ps.setString(4, description);
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public List<Product> get_values() {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		try {
			String querry = "select * from PRODUCT";
			ps = connection.prepareStatement(querry);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product(rs.getString("ITEM_ID"), rs.getString("PRODUCT_NAME"), rs.getInt("qty"),
						rs.getString("DESCRIPTION"));
				list.add(p);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public Product get_value_of_product(String itemId){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product p=new Product();
		try {
		 String querry="select * from PRODUCT where ITEM_ID=?";
		 ps=connection.prepareStatement(querry);		
		 ps.setString(1, itemId);
		 rs=ps.executeQuery();
		 while(rs.next()){
			 p.setItemId(rs.getString("ITEM_ID"));
			 p.setDescription(rs.getString("DESCRIPTION"));
			 p.setName(rs.getString("PRODUCT_NAME"));
			 p.setQuantity(rs.getInt("qty"));
	         }
		} catch (Exception e) {
		System.out.println(e);
		}
		return p;
	}
	public void edit_values(Product p) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
		try {
			String querry = "update PRODUCT set ITEM_ID=?,qty=?,PRODUCT_NAME=?, DESCRIPTION=? where ITEM_ID=?";
			ps = connection.prepareStatement(querry);
			ps.setString(1, p.getItemId());
			ps.setString(3, p.getName());
			ps.setInt(2, p.getQuantity());
			ps.setString(4, p.getDescription());
			ps.setString(5, p.getItemId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void delete_value(Product p) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
		try {
			String querry = "delete from PRODUCT where ITEM_ID=?";
			ps = connection.prepareStatement(querry);
			ps.setString(1, p.getItemId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
