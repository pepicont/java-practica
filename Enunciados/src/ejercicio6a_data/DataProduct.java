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
}