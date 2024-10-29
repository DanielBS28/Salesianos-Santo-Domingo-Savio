package Ventana2;

import java.util.ArrayList;
import java.io.*;

public class Fichero {

	public static String leerArchivo() {
		
		File fichero = new File("CorreoBody.txt");

		ArrayList<String> Strings = new ArrayList<>();
		String linea = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader(fichero));

			while ((linea = br.readLine()) != null) {

				Strings.add(linea +"\n");
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return guardarString(Strings);
	}

	private static String guardarString(ArrayList<String> strings) {
		
		String texto = "";
		
		for(String s : strings)
			texto += s;

		return texto;
	}

}
