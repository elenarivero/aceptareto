package entrenamiento;

import java.util.Scanner;

public class SueloMulticolor {

	static Scanner reader;
	public static void main(String[] args) {
		reader = new Scanner(System.in);
		while(casoPrueba()) {
			
		}

		reader.close();

	}

	public static boolean casoPrueba() {
		if(!reader.hasNext()) {
			return false;
		} else {
			int numFilas = reader.nextInt();
			int numCols = reader.nextInt();
			String patron = reader.next();
	
			for (int i = 0; i < numFilas; i++) {
				for (int j = 0; j < numCols; j++) {
					System.out.print(patron.charAt(j%patron.length()));
				}
				patron = patron.charAt(patron.length()-1) + patron.substring(0, patron.length()-1);
				System.out.println();
			}
			return true;
		}
	}
}
