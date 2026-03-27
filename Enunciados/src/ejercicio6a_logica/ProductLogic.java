package ejercicio6a_logica;

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
}