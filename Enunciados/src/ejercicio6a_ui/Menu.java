package ejercicio6a_ui;

import java.util.Scanner;

import ejercicio6a_entidades.Product;
import ejercicio6a_logica.ProductLogic;

public class Menu {

	Scanner s= null;
	ProductLogic pl = new ProductLogic();
	
	public void start() {
		s = new Scanner(System.in);
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(pl.getAll());
			break;
		case "search":
			System.out.println();
			System.out.print("Ingrese el id del producto a buscar: ");
			int id = Integer.parseInt(s.nextLine());
			System.out.println(pl.getOne(id));
			break;
		case "new":
			System.out.println();
			try { //este try-catch es para poner mensaje de producto creado: y agarrar la excepción de productData
				System.out.print("Ingrese el nombre del producto: ");
				String name = s.nextLine();
				System.out.print("Ingrese la descripción del producto: ");
				String description = s.nextLine();
				System.out.print("Ingrese el precio del producto: ");
				double price = Double.parseDouble(s.nextLine());
				System.out.print("Ingrese el stock del producto: ");
				int stock = Integer.parseInt(s.nextLine());
				System.out.print("¿El envío está incluido? (true/false): ");
				boolean shippingIncluded = Boolean.parseBoolean(s.nextLine());
				Product productoCreado = pl.create(name, description, price, stock, shippingIncluded);
				System.out.println("Producto creado: " + productoCreado);
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
			break;

		case "update":
			System.out.println("");
			 System.out.print("Ingrese el id del producto a actualizar: ");
			 int idUpdate = Integer.parseInt(s.nextLine());
			 System.out.print("Ingrese el nuevo nombre del producto: ");
			 String nameUpdate = s.nextLine();
			 System.out.print("Ingrese la nueva descripción del producto: ");
			 String descriptionUpdate = s.nextLine();
			 System.out.print("Ingrese el nuevo precio del producto: ");
			 double priceUpdate = Double.parseDouble(s.nextLine());
			 System.out.print("Ingrese el nuevo stock del producto: ");
			 int stockUpdate = Integer.parseInt(s.nextLine());
			 System.out.print("¿El envío está incluido? (true/false): ");
			 boolean shippingIncludedUpdate = Boolean.parseBoolean(s.nextLine());
			 try {
				 System.out.println("Producto actualizado: " + pl.update(idUpdate, nameUpdate, descriptionUpdate, priceUpdate, stockUpdate, shippingIncludedUpdate));
			 } catch (Exception e) {
				 System.out.println("Error: " + e.getMessage()); //no entran nunca
			 }
			break;
		case "delete":
			System.out.println("");
			System.out.print("Ingrese el id del producto a borrar: ");
			int idDelete = Integer.parseInt(s.nextLine());
			try {
				System.out.println("Producto borrado: " + pl.delete(idDelete));
			}
			catch (Exception e) {
				System.out.println("Error: " + e.getMessage()); //no entran nunca
			}
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos los productos");
		System.out.println("search\t\tbuscar por id de producto"); 
		System.out.println("new\t\tcrea un nuevo producto");
		System.out.println("delete\t\tborra por id de producto");
		System.out.println("update\t\tactualizar un producto por id");
		System.out.println("exit\t\tsalir");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
}