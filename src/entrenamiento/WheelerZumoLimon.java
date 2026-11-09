package entrenamiento;

import java.util.Arrays;
import java.util.Scanner;

public class WheelerZumoLimon {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		int numPersonas;
		long[] puntuaciones;
		boolean dunningKruger = true;

		numPersonas = reader.nextInt();
		while (numPersonas != 0) {
			puntuaciones = new long[numPersonas];

			for (int i = 0; i < numPersonas; i++) {
				puntuaciones[i] = reader.nextInt();

			}

			for (int i = 0; i < numPersonas; i++) {
				int despues = reader.nextInt();
				long diff = despues - puntuaciones[i];
				// Uno en una misma variable los dos valores, la puntuación y la diferencia
				puntuaciones[i] = (puntuaciones[i] << 32) | (diff & 0xFFFFFFFFL);
			}

			// Ordeno por las puntuaciones
			Arrays.sort(puntuaciones);

			dunningKruger = true;
			int i = 1;
			// Cojo la primera diferencia
			int diferenciaI = (int) puntuaciones[0];
			while (dunningKruger && i < numPersonas) {
				
				// Al hacer un cast a int me estoy quedando sólo con la diferencia
				int diferenciaJ = (int) puntuaciones[i];
				// Si la diferencia posterior es >= que la anterior no se está cumpliendo
				// Se aprovecha la propiedad transitiva, por eso no son necesarios dos bucles
				if (diferenciaJ >= diferenciaI) {
					dunningKruger = false;
				}

				diferenciaI = diferenciaJ;
				i++;
			}

			System.out.println(dunningKruger ? "SI" : "NO");
			numPersonas = reader.nextInt();
		}

		reader.close();

	}

}
