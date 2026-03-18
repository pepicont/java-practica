package ejercicio5a;

import java.util.Scanner;

import ejercicio5a.entidades.Administrativo;
import ejercicio5a.entidades.Empleado;
import ejercicio5a.entidades.Vendedor;

public class main {

	public static void main(String[] args) {
		
	Empleado[] empleados = new Empleado[3];
	
	Scanner scanner = new Scanner(System.in);
	
	for (int i = 0; i < empleados.length; i++) {
		System.out.println("Ingrese 1 si el empleado es administrativo o 2 si es vendedor");
		String tecla = scanner.nextLine();
		
		System.out.println("Ingrese dni:");
		int dni = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Ingrese nombre:");
		String nombre = scanner.nextLine();
		
		System.out.println("Ingrese apellido:");
		String apellido = scanner.nextLine();
		
		System.out.println("Ingrese email:");
		String email = scanner.nextLine();
		
		System.out.println("Ingrese sueldoBase:");
		int sueldoBase = Integer.parseInt(scanner.nextLine());
		
		if(tecla.equals("1")) {
			
			System.out.println("Ingrese hsExtra:");
			int hsExtra = Integer.parseInt(scanner.nextLine());
			
			System.out.println("Ingrese hsMes:");
			int hsMes = Integer.parseInt(scanner.nextLine());
			
			Administrativo adm = new Administrativo(dni, nombre, apellido, email, sueldoBase, hsExtra, hsMes);
			empleados[i]= adm;
			
		}
		
		if(tecla.equals("2")) {
			
			System.out.println("Ingrese porcenComision:");
			int porcenComision = Integer.parseInt(scanner.nextLine());
			
			System.out.println("Ingrese totalVentas:");
			int totalVentas = Integer.parseInt(scanner.nextLine());
			
			Vendedor vnd = new Vendedor(dni, nombre, apellido, email, sueldoBase, porcenComision, totalVentas);
			empleados[i]= vnd;
			
		}
		
	}
	
	System.out.println("");
	System.out.println("LISTA DE EMPLEADOS:");
	
	for (Empleado empleado : empleados) {
		
		System.out.println("DNI: "+empleado.getDni());
		System.out.println("NOMBRE: "+empleado.getNombre());
		System.out.println("APELLIDO: "+empleado.getApellido());
		System.out.println("SUELDO: "+empleado.getSueldo());
		System.out.println("");
		
	}

	
	
	
	
	scanner.close();
	}
}
