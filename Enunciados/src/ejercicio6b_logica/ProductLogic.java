package ejercicio6b_logica;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

import ejercicio6b_data.ProductData;
import ejercicio6b_entidades.Product;

public class ProductLogic {

	private ProductData pd = ProductData.getInstance();
	
	
	public LinkedList<Product> getAll(){
		return pd.getAll();
	}
	
	public Product getOne(int id){
		return pd.getOne(id);
	}
	
	public Product create(String name, String description, double price, int stock, boolean shippingIncluded) {
		return pd.create(name, description, price, stock, shippingIncluded);
	}
	
	public Product update(int id, String name, String description, double price, int stock, boolean shippingIncluded, Date disabledOn ) throws SQLException {
		return pd.update(id, name, description, price, stock, shippingIncluded, disabledOn);
	}
	
	public int delete(int id) throws SQLException {
		return pd.delete(id);
	}
}