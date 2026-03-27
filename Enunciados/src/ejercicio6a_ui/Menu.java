package ejercicio6a_ui;

import java.util.Scanner;

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
			System.out.println("Aquí los métodos");
			break;
		case "update":
			System.out.println("Aquí los métodos");
			break;
		case "delete":
			System.out.println("Aquí los métodos");
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos los productos");
		System.out.println("search\t\tbuscar por id de producto"); //solo debe devolver 1
		System.out.println("new\t\tcrea un nuevo producto");
		System.out.println("delete\t\tborra por id de producto");
		System.out.println("update\t\tactualizar un producto por id");
		System.out.println("exit\t\tsalir");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
}