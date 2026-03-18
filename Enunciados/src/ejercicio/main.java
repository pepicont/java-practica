package ejercicio;

public class main {

	public static void main(String[] args) {
		//Mostrar por consola los 10 primeros números enteros y los 10 primeros números impares
		
		System.out.println("Imprimimos los 10 primeros números enteros:");
		for (int i=0; i<10; i++) {
			System.out.println(i+1);
		}
		
		System.out.println("Ahora imprimimos los 10 primeros números impares");
		for (int i=1; i<11; i++) {
			System.out.println(i*2-1);
		}
	}

}
