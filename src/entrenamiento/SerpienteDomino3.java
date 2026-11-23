package entrenamiento;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SerpienteDomino3 {
	static Map<Integer, Integer> fichas;

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		int numFichas = reader.nextInt();

		while (numFichas != 0) {
			fichas = new TreeMap<Integer, Integer>();
			boolean correcto = true;

			int fichaIzq = reader.nextInt();
			int numDominos = añadirFicha(fichaIzq);

			for (int i = 2; i <= numFichas; i++) {
				int fichaDer = reader.nextInt();

				if (numDominos < añadirFicha(fichaDer)) {
					numDominos++;
				}

				if (fichaIzq%10 != fichaDer/10) {
					correcto = false;
				}

				fichaIzq = fichaDer;
			}

			System.out.println(correcto ? numDominos : "ERROR");
			numFichas = reader.nextInt();
		}

		reader.close();

	}

	static int añadirFicha(Integer ficha) {

		Integer valor;

		int unidades = ficha % 10;
		int decenas = ficha / 10;
		if (decenas > unidades) {
			ficha = unidades * 10 + decenas;
		}

		valor = fichas.get(ficha) == null ? 1 : fichas.get(ficha)+1;
		
		fichas.put(ficha, valor);

		return valor;

	}

}
