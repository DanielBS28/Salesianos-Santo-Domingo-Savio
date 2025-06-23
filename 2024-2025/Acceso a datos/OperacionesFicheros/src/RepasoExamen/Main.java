package RepasoExamen;

import java.io.*;

public class Main {

	static String ruta = "src/RepasoExamen/AlumnoEscritura.bin";

	public static void Escritura() {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta));

			Alumno a = new Alumno(1, 10);
			Alumno b = new Alumno(5, 10);

			oos.writeObject(a);
			oos.writeObject(b);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Lectura() {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta));

			Alumno a = (Alumno) ois.readObject();
			Alumno e = (Alumno) ois.readObject();

			System.out.println(a);
			System.out.println(e);

		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();
		}
		/*
		 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (ClassNotFoundException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}

	public static void main(String[] args) {

		Escritura();
		Lectura();

	}

}
