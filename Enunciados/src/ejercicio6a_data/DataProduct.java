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
	
	public Product create(String name, String description, double price, int stock, boolean shippingIncluded) {
		
		Product product = null;
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/java_market","java","himitsu");
				PreparedStatement stmt = conn.prepareStatement("insert into product(name, description, price, stock,"
						+ "shipping_included) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)){
			
				stmt.setString(1, name);
				stmt.setString(2, description);
				stmt.setDouble(3, price);
				stmt.setInt(4, stock);
				stmt.setBoolean(5, shippingIncluded);
				stmt.executeUpdate();
				try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						int id = generatedKeys.getInt(1);
						product = new Product();
						product.setId(id);
						product.setName(name);
						product.setDescription(description);
						product.setPrice(price);
						product.setStock(stock);
						product.setShippingIncluded(shippingIncluded);
					}
					else {
						throw new SQLException("Creating product failed, no ID obtained.");
					}}catch (SQLException e) { //este catch es del 2do try-w-resources
						e.printStackTrace();
					}
					
				}
				catch (SQLException e) {
				e.printStackTrace();
				}
		
		return product;
	}
	
	public int delete(int id) throws SQLException{
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/java_market","java","himitsu");
			stmt = conn.prepareStatement("delete from product where id=?");
			stmt.setInt(1, id);
			int rows=stmt.executeUpdate();
			if(rows == 0) {
				throw new SQLException("Deleting went wrong.");
			}
				} 
				 catch (SQLException e) {
				throw e;
				}
		finally {
			//cierre de recursos
			try {
				if(stmt != null) {stmt.close();}
				if(conn != null) {conn.close();}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	
		return id;
	}
	
	public Product update(int id, String name, String description, double price, int stock, boolean shippingIncluded) throws SQLException{
		
		Product product = null;
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/java_market","java","himitsu");
				PreparedStatement stmt = conn.prepareStatement("update product set name=?, description=?, price=?"
						+ ",stock=?, shipping_included=? where id=?")){
						
			
				stmt.setString(1, name);
				stmt.setString(2, description);
				stmt.setDouble(3, price);
				stmt.setInt(4, stock);
				stmt.setBoolean(5, shippingIncluded);
				stmt.setInt(6, id);
				int rows = stmt.executeUpdate();
				if(rows > 0) {
						product = new Product();
						product.setId(id);
						product.setName(name);
						product.setDescription(description);
						product.setPrice(price);
						product.setStock(stock);
						product.setShippingIncluded(shippingIncluded);
					}
					else {
						throw new SQLException("Updating went wrong.");
					}}
					catch (SQLException e) {
						throw e;
					}
		
		return product;
	}
}