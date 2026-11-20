package entrenamiento;

import java.util.Scanner;

public class EspectaculoNocturnoMatriz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int anchoFachada = sc.nextInt();
		int altoFachada = sc.nextInt();
		int numCañones = sc.nextInt();
		int supFachada = anchoFachada * altoFachada;
		boolean cuadrados[][] = new boolean[altoFachada][anchoFachada];

		while (altoFachada != 0 || anchoFachada != 0 || numCañones != 0) {

			for (int i = 1; i <= numCañones; i++) {
				int posX = sc.nextInt();
				int posY = sc.nextInt();
				int anchoCañón = sc.nextInt();
				int altoCañón = sc.nextInt();

				for (int fila = cuadrados.length - posY - 1; fila >= 0
						&& fila >= cuadrados.length - (altoCañón + posY); fila--) {
					for (int col = posX; col < Math.min(anchoCañón + posX, cuadrados[fila].length); col++) {
						if (cuadrados[fila][col] == false) {
							cuadrados[fila][col] = true;
							supFachada--;
//							imprimeTabla(cuadrados);
						}
					}
				}

			}

			System.out.println(supFachada);

			anchoFachada = sc.nextInt();
			altoFachada = sc.nextInt();
			numCañones = sc.nextInt();
			cuadrados = new boolean[altoFachada][anchoFachada];
			supFachada = altoFachada * anchoFachada;
		}

		sc.close();
	}

	public static void imprimeTabla(boolean[][] tabla) {
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				System.out.print(tabla[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
