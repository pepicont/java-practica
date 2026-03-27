package ejercicio6a_logica;

import java.sql.SQLException;
import java.util.LinkedList;

import ejercicio6a_data.DataProduct;
import ejercicio6a_entidades.Product;

public class ProductLogic {

	private DataProduct dp = DataProduct.getInstance();
	
	
	public LinkedList<Product> getAll(){
		return dp.getAll();
	}
	
	public Product getOne(int id){
		return dp.getOne(id);
	}
	
	public Product create(String name, String description, double price, int stock, boolean shippingIncluded) {
		return dp.create(name, description, price, stock, shippingIncluded);
	}
	
	public Product update(int id, String name, String description, double price, int stock, boolean shippingIncluded) throws SQLException {
		return dp.update(id, name, description, price, stock, shippingIncluded);
	}
	
	public int delete(int id) throws SQLException {
		return dp.delete(id);
	}
}