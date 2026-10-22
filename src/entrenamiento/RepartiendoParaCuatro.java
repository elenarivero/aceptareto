package entrenamiento;

import java.util.Scanner;

public class RepartiendoParaCuatro {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int num;
		int fin;
		int numPartes = 1;
		
		fin = reader.nextInt();
		while(fin!=0) {
			numPartes = fin;
			num = reader.nextInt();
			
			while(num != 0) {
				numPartes *= num;
				num = reader.nextInt();
			}
			System.out.println(numPartes);

			fin = reader.nextInt();
		}
		
		reader.close();

	}

}
