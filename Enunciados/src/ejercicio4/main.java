package ejercicio4;

import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		// Leer un entero y luego una lista de 20 enteros.
		// Guardar los mayores al número inicial y mostrarlos al final. Usar arrays, no otras colecciones.
		
		Scanner scanner = new Scanner(System.in);
		
		Integer[] enteros = new Integer[20];
		
		System.out.println("Ingrese un entero a comparar: ");
		Integer entero = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < 20; i++) {
			System.out.println("Ingrese el "+(i+1)+"º nro:");
			Integer nro = Integer.parseInt(scanner.nextLine());
			if (nro>entero) {
				enteros[i]=nro;
			}
		}
		
		for (int i=0; i<20; i++) {
			if(enteros[i]!=null) {
				System.out.println(enteros[i]);
			}
		}
		
		
		scanner.close();

	}

}
