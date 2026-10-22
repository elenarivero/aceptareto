package entrenamiento;

import java.util.Scanner;

public class NumerosNicomaco {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int sigNicomaco = 1;
		
		int numEntradas = reader.nextInt();
		
		int numLeido;
		
		int cont = 1;
		
		int suma = 1;
		
		for(int i=1; i<=numEntradas; i++) {
			numLeido = reader.nextInt();
			cont = 1;
			sigNicomaco = 1;
			suma = 1;
			
			while (sigNicomaco < numLeido) {
				
				sigNicomaco = suma*suma;
				cont++;
				suma += cont;
			}
			
			System.out.println(sigNicomaco);
		}
		
		reader.close();

	}

}
