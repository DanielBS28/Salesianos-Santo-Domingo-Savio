package FicherosBinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExplicacionEnClase {

	public static void escribirBinario(String ruta) {

		File fichero = new File(ruta);

		try {

			FileOutputStream fos = new FileOutputStream(fichero);
			String datos = "Vamos a escribir una prueba de datos";
			fos.write(datos.getBytes());
			fos.close();

		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	public static void lecturaBinarios(String ruta) {

		try {

			FileInputStream fis = new FileInputStream(new File(ruta));
			int caracter;

			while ((caracter = fis.read()) != -1) {
				System.out.print((char) caracter);
			}
			fis.close();

		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	public static void EscribirCoches(String ruta) {

		try {

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream((new File(ruta))));

			Coche c1 = new Coche(5, "Opel", "Astra", 500, 200, 20000);
			Coche c2 = new Coche(5, "Citroen", "c3", 100, 1900, 10000);

			oos.writeObject(c1);
			oos.writeObject(c2);

			oos.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.getStackTrace();
		} catch (IOException ioe) {
			ioe.getStackTrace();

		}
	}

	public static void lecturaObjetos(String ruta) {

		try {

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream((new File(ruta))));

			Coche coche1 = (Coche) ois.readObject();
			Coche coche2 = (Coche) ois.readObject();

			// System.out.println(coche1.toString());
			// System.out.println(coche2.toString());
			System.out.println(coche1);
			
			ois.close();

		} catch (ClassNotFoundException fnfe) {
			fnfe.getStackTrace();
		} catch (IOException ioe) {
			ioe.getStackTrace();

		}
	}

	public static void main(String[] args) {

		String ruta = "fichero.bin";
		String ruta2 = "fichero2.bin";
		
		// escribirBinario(ruta);
		// lecturaBinarios(ruta);
		EscribirCoches(ruta2);
		lecturaObjetos(ruta2);

	}

}
