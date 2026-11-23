package entrenamiento;

import java.util.Scanner;

public class SerpienteDomino {
	static int[][] fichas;

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		int numFichas = reader.nextInt();

		while (numFichas != 0) {
			fichas = new int[7][7];
			boolean correcto = true;

			int fichaIzq = reader.nextInt();
			int numDominos = añadirFicha(fichaIzq);

			for (int i = 2; i <= numFichas && correcto; i++) {
				int fichaDer = reader.nextInt();

				if (fichaIzq % 10 != fichaDer / 10) {
					correcto = false;
					reader.nextLine();
				} else if (numDominos < añadirFicha(fichaDer)) {
					numDominos++;
				}

				fichaIzq = fichaDer;
			}

			System.out.println(correcto ? numDominos : "ERROR");
			numFichas = reader.nextInt();
		}

		reader.close();

	}

	static int añadirFicha(Integer ficha) {

		int unidades = ficha % 10;
		int decenas = ficha / 10;
		
		if (decenas > unidades) {
			fichas[unidades][decenas]++;
		} else {
			fichas[decenas][unidades]++;
		}

		return fichas[unidades][decenas];

	}

}
