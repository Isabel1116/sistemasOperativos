import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Automata {

	ArrayList<String> alphabet = new ArrayList<String>();
	ArrayList<String> edosF = new ArrayList<String>();

	ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
	int matriz[][];
	int edos, size;

	public ArrayList<ArrayList<Integer>> getMatrix() {
		return matrix;
	}

	public int getSize() {
		return this.size;
	}

	public Automata(String file) {// constructor que recibe archivo y asigna valores a la quíntupla

		int renglon = 0;

		try {
			FileReader lectorArchivo;
			File f = new File(file);
			String aux = "";/* variable auxiliar */

			lectorArchivo = new FileReader(f);
			BufferedReader br = new BufferedReader(lectorArchivo);

			while (true) {
				aux = br.readLine(); // leemos una linea de texto y la guardamos en la variable auxiliar
				if (aux != null) { // si aun hay datos continuamos con el guardado de informacion

					switch (renglon) {
					case 0:// se guardan los simbolos del alfabeto
						String[] letras = aux.split(",");
						int sizeA = letras.length;
						this.size = sizeA;

						for (int i = 0; i < letras.length; i++) {
							// System.out.println(letras[i]);
							alphabet.add(letras[i]);
						}
						break;

					case 1:// se guarda el numero de estados
						this.edos = Integer.parseInt(aux);
						break;

					case 2:// se guardan los estados de aceptacion
						String[] estados = aux.split(",");

						for (int j = 0; j < estados.length; j++) {
							// System.out.println(letras[i]);
							edosF.add(estados[j]);
						}
						break;

					case 3:// se llena la matriz de transicion
						String[] coord = aux.split(",");
						int w = 0;
						matriz = new int[this.size][this.edos];

						/*
						 * for (int j = 0; j < coord.length; j++) {
						 * 
						 * //String[] value = coord[j].split(":"); if(w == 0) { for (int k = 0; k <
						 * this.edos; k++) { matriz[0][k] = k; } }
						 * 
						 * w++; }
						 */
						System.out.println("Tamaño de matriz: " + matriz.length);
						for (int x = 0; x < matriz.length; x++) {
							for (int y = 0; y < matriz[x].length; y++) {
								int currentCell = matriz[x][y];
								System.out.println(currentCell);
							}
						}
						break;
					}
					renglon++;

				} else
					break;
			}
			// System.out.println(alphabet.toString());
			// System.out.println(edos);
			// System.out.println(edosF.toString());
			System.out.println(matriz[0].toString());
			br.close();
			lectorArchivo.close();
		} catch (IOException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	public void validacion(ArrayList<ArrayList<Integer>> matrix, String c) {
		int estado;

		for (int x = 0; x < c.length(); x++)
			System.out.println("Caracter " + x + ": " + c.charAt(x));

	}

}
