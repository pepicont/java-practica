package ejercicio2;

import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		// Leer 10 palabras y mostrarlas en orden inverso al que fueron ingresadas.
		
		String[] palabras = new String[10];
		
		Scanner scanner = new Scanner(System.in);
		
		for (int i=0; i<10; i++) {
			System.out.println("Ingrese la palabra "+(i+1)+" :");
			palabras[i]=scanner.nextLine();
			
		}
		
		scanner.close();
		
		for (int i=10; i!=0; i--) {
			System.out.println(palabras[i-1]);
		}

	}

}
