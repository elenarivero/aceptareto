package entrenamiento;

import java.util.Scanner;

public class CuerdasPiano {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		int numCasos = reader.nextInt();
		int total3Cuerdas;
		int total2Cuerdas;
		int total1Cuerda;

		for (int i = 1; i <= numCasos; i++) {
			total3Cuerdas = 3 * reader.nextInt();
			total2Cuerdas = 2 * reader.nextInt();
			total1Cuerda = reader.nextInt();
			System.out.println(total1Cuerda + total2Cuerdas + total3Cuerdas);
		}

		reader.close();

	}

}
