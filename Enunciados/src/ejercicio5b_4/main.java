package ejercicio5b_4;

import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		//LINKED LISTS
		//Leer un entero y luego una lista de 20 enteros. Guardar los mayores al número inicial y mostrarlos al final.
		
		Scanner scanner = new Scanner(System.in);
		
		LinkedList<Integer> enteros = new LinkedList<>();
		
		System.out.println("Ingrese un entero a comparar: ");
		Integer entero = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < 20; i++) {
			System.out.println("Ingrese el "+(i+1)+"º nro:");
			Integer nro = Integer.parseInt(scanner.nextLine());
			if (nro>entero) {
				enteros.add(nro);
			}
		}
		
		for (Integer numeroMayor : enteros) {
			System.out.println(numeroMayor);
		}
		
		
		scanner.close();

	}

}
