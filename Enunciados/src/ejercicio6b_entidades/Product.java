package ejercicio6b_entidades;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Product {
	
	private int id;
	private String name;
	private String description;
	private double price;
	private int stock;
	private boolean shippingIncluded;
	private Date disabledOn;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean isShippingIncluded() {
		return shippingIncluded;
	}
	public void setShippingIncluded(boolean shippingIncluded) {
		this.shippingIncluded = shippingIncluded;
	}
	
	public Date getDisabledOn() {
		return disabledOn;
	}
	public void setDisabledOn(Date date) {
		this.disabledOn = date;
	}
	@Override
	public String toString() {
	    String formattedDate = null;
	    if (disabledOn != null) {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        formattedDate = sdf.format(disabledOn);}
		return "\nProduct [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", stock=" + stock + ", isShippingIncluded=" + shippingIncluded + ", disabledOn=" + formattedDate +"]";
	}
	
	
}