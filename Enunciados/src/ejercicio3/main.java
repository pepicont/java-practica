package ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// Leer 10 palabras, luego leer una nueva palabra e indicar si la misma ya había sido ingresada
		//en las 10 primeras.

		ArrayList<String> palabras = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Ingrese la palabra "+(i+1)+" :");
			String palabra = scanner.nextLine();
			palabras.add(palabra);
			
		}
		
		System.out.println("Ahora ingrese la palabra a comparar: ");
		String palabra = scanner.nextLine();
		
		System.out.println("La palabra se encuentra en la lista: "+palabras.contains(palabra));
		
		scanner.close();
		
	}

}
