package FicherosBinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main_ejercicio1 {
	
	static Scanner teclado = new Scanner(System.in);
	
	static Persona pedirDatos() {
		
		System.out.println("Dime el nombre de la persona: ");
		String nombre = teclado.nextLine();
		System.out.println("Dime la edad de la persona");
		int edad = teclado.nextInt();
		teclado.nextLine();
		
		Persona p = new Persona(nombre, edad);
		
		return p;
		}
	
	static void escrituraObjetos(String ruta) {
		
		
		try {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream((new File(ruta))));
		
		Persona persona = pedirDatos();
		
		oos.writeObject(persona);
		
		
		}catch (FileNotFoundException fnfe) {
			fnfe.getStackTrace();
		} catch (IOException ioe) {
			ioe.getStackTrace();

		}
		
		lecturaPersona(ruta);
		}
		
	static void lecturaPersona(String ruta) {
		
		try {

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream((new File(ruta))));

			Persona p1 = (Persona) ois.readObject();
			System.out.println(p1);
			
			ois.close();

		} catch (ClassNotFoundException fnfe) {
			fnfe.getStackTrace();
		} catch (IOException ioe) {
			ioe.getStackTrace();

		}
	}
	
	static void ejercicio1() {
		
		String ruta = "Binarios1.bin";
		escrituraObjetos(ruta);
	}

	public static void main(String[] args) {
		
		ejercicio1();

	}

}
