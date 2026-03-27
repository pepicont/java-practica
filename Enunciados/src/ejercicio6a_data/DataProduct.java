package ejercicio6a_data;

import java.sql.*;
import java.util.LinkedList;

import ejercicio6a_entidades.Product;

public class DataProduct {
	
	private static DataProduct instance; //patrón singleton
	
	public static DataProduct getInstance() { //patrón singleton
		if (instance == null) {
			instance = new DataProduct();
		}
		return instance;
	}
	
	

	public LinkedList<Product> getAll(){
		
		LinkedList<Product>products = new LinkedList<>();
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/java_market","java","himitsu");
				PreparedStatement stmt = conn.prepareStatement("select * from product");
				ResultSet rs = stmt.executeQuery()) {
								if(rs!=null) {
									while(rs.next()) {
										Product p = new Product();
										p.setId(rs.getInt("id"));
										p.setName(rs.getString("name"));
										p.setDescription(rs.getString("description"));
										p.setPrice(rs.getDouble("price"));
										p.setStock(rs.getInt("stock"));
										p.setShippingIncluded(rs.getBoolean("shipping_included"));
										products.add(p);
										
									}
								}
								
				} catch (SQLException e) {
				e.printStackTrace();
				}
		return products;
	}
	
	public Product getOne(int id){
		
		Product product = null;
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/java_market","java","himitsu");
				PreparedStatement stmt = conn.prepareStatement("select * from product where id=?")) {
				stmt.setInt(1, id);
				try (ResultSet rs = stmt.executeQuery()){ //otro try-w-resources porque no me deja setear param en el 1ero
								if(rs!=null) {
									if(rs.next()) { //no while porque es solo 1, uso if.
										product = new Product();
										product.setId(rs.getInt("id"));
										product.setName(rs.getString("name"));
										product.setDescription(rs.getString("description"));
										product.setPrice(rs.getDouble("price"));
										product.setStock(rs.getInt("stock"));
										product.setShippingIncluded(rs.getBoolean("shipping_included"));
										
									}
								} 
				}
				} catch (SQLException e) {
				e.printStackTrace();
				}
		//otra forma de hacer esto es sin try-w-r y hacer al final esto
		/* finally {
	        try { if (rs != null) {rs.close();}
	         if (stmt != null) {stmt.close();} 
	         if (conn != null) {conn.close();}}
	         catch (SQLException e) { e.printStackTrace(); }*/
			
		
		
		return product;
	}
}