package ejercicio6b_data;

import java.sql.*;
import java.util.LinkedList;
import java.util.Date;

import ejercicio6b_entidades.Product;

public class ProductData {
	
	private static ProductData instance; //patrón singleton
	
	public static ProductData getInstance() { //patrón singleton
		if (instance == null) {
			instance = new ProductData();
		}
		return instance;
	}
	
	

	public LinkedList<Product> getAll(){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LinkedList<Product>products = new LinkedList<>();
		Connection conn = null;
		
		try  {
			conn = DbConnector.getInstancia().getConn();
				stmt = conn.prepareStatement("select * from product");
				rs = stmt.executeQuery();
								if(rs!=null) {
									while(rs.next()) {
										Product p = new Product();
										p.setId(rs.getInt("id"));
										p.setName(rs.getString("name"));
										p.setDescription(rs.getString("description"));
										p.setPrice(rs.getDouble("price"));
										p.setStock(rs.getInt("stock"));
										p.setShippingIncluded(rs.getBoolean("shipping_included"));
										p.setDisabledOn(rs.getDate("disabled_on"));
										products.add(p);
										
									}
								}
								
				} catch (SQLException e) {
				e.printStackTrace();
				}
		finally {
			try {
				if(stmt != null) {stmt.close();}
				if(rs!=null) {rs.close();}
				DbConnector.getInstancia().releaseConn();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return products;
	}
	
	public Product getOne(int id){
		
		Product product = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try  {
				Connection conn = DbConnector.getInstancia().getConn();
				stmt = conn.prepareStatement("select * from product where id=?");
				stmt.setInt(1, id);
				rs = stmt.executeQuery(); //otro try-w-resources porque no me deja setear param en el 1ero
								if(rs!=null) {
									if(rs.next()) { //no while porque es solo 1, uso if.
										product = new Product();
										product.setId(rs.getInt("id"));
										product.setName(rs.getString("name"));
										product.setDescription(rs.getString("description"));
										product.setPrice(rs.getDouble("price"));
										product.setStock(rs.getInt("stock"));
										product.setShippingIncluded(rs.getBoolean("shipping_included"));
										product.setDisabledOn(rs.getDate("disabled_on"));
										
									}
								} 
				
				} catch (SQLException e) {
				e.printStackTrace();
				}
		 finally {
	        try { if (rs != null) {rs.close();}
	         if (stmt != null) {stmt.close();} 
	         DbConnector.getInstancia().releaseConn();}
	         catch (SQLException e) { e.printStackTrace(); }}
			
		
		
		return product;
	}
	
	public Product create(String name, String description, double price, int stock, boolean shippingIncluded) {
		
		Product product = null;
		PreparedStatement stmt = null;
		ResultSet generatedKeys = null;
		
		try {
				Connection conn = DbConnector.getInstancia().getConn();
				stmt = conn.prepareStatement("insert into product(name, description, price, stock,"
				+ "shipping_included, disabled_on) values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				
				stmt.setString(1, name);
				stmt.setString(2, description);
				stmt.setDouble(3, price);
				stmt.setInt(4, stock);
				stmt.setBoolean(5, shippingIncluded);
				stmt.setDate(6, null);
				stmt.executeUpdate();
				generatedKeys = stmt.getGeneratedKeys();
					if (generatedKeys.next()) {
						int id = generatedKeys.getInt(1);
						product = new Product();
						product.setId(id);
						product.setName(name);
						product.setDescription(description);
						product.setPrice(price);
						product.setStock(stock);
						product.setShippingIncluded(shippingIncluded);
						product.setDisabledOn(null);
					}
					else {
						throw new SQLException("Creating product failed, no ID obtained.");
					
				}}
				catch (SQLException e) {
				e.printStackTrace();
				}
		
		return product;
	}
	
	public int delete(int id) throws SQLException{
		
		PreparedStatement stmt = null;
		
		try {
			Connection conn = DbConnector.getInstancia().getConn();
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
				DbConnector.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	
		return id;
	}
	
	public Product update(int id, String name, String description, double price, int stock, boolean shippingIncluded, Date disabledOn) throws SQLException{
		
		Product product = null;
		PreparedStatement stmt = null;
		
		try {
			Connection conn = DbConnector.getInstancia().getConn();
			stmt = conn.prepareStatement("update product set name=?, description=?, price=?"
					+ ",stock=?, shipping_included=?, disabled_on=? where id=?");
				stmt.setString(1, name);
				stmt.setString(2, description);
				stmt.setDouble(3, price);
				stmt.setInt(4, stock);
				stmt.setBoolean(5, shippingIncluded);
				
				if (disabledOn != null) {
					stmt.setDate(6, new java.sql.Date(disabledOn.getTime()));}
				else {
					stmt.setDate(6, null);
				}
				
				stmt.setInt(7, id);
				int rows = stmt.executeUpdate();
				if(rows > 0) {
						product = new Product();
						product.setId(id);
						product.setName(name);
						product.setDescription(description);
						product.setPrice(price);
						product.setStock(stock);
						product.setShippingIncluded(shippingIncluded);
						product.setDisabledOn(disabledOn);
					}
					else {
						throw new SQLException("Updating went wrong.");
					}}
					catch (SQLException e) {
						throw e;
					}
		finally {
			try {
				if(stmt != null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return product;
	}
}