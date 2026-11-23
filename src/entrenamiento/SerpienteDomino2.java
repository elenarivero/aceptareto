package entrenamiento;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SerpienteDomino2 {
	static Map<String, Integer> fichas;

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		int numFichas = reader.nextInt();

		while (numFichas != 0) {
			fichas = new TreeMap<String, Integer>();
			boolean correcto = true;

			String fichaIzq = reader.next();
			int numDominos = añadirFicha(fichaIzq);

			for (int i = 2; i <= numFichas && correcto; i++) {
				String fichaDer = reader.next();
				
				if (fichaIzq.charAt(1) != fichaDer.charAt(0)) {
					correcto = false;
					reader.nextLine();
				}else if (numDominos < añadirFicha(fichaDer)) {
					numDominos++;
					fichaIzq = fichaDer;
				}
				
			}

			System.out.println(correcto ? numDominos : "ERROR");
			numFichas = reader.nextInt();
		}

		reader.close();

	}

	static int añadirFicha(String ficha) {

		Integer valor;

		if (ficha.charAt(0) > ficha.charAt(1)) {
			ficha = "" + ficha.charAt(1) + ficha.charAt(0);
		}

		valor = fichas.get(ficha);

		if (valor == null) {
			valor = 0;
		}

		valor++;
		fichas.put(ficha, valor);

		return valor;

	}

}
