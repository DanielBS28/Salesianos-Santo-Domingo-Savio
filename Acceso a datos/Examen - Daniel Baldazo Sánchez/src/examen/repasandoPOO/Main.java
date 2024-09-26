package examen.repasandoPOO;

public class Main {

	public static void main(String[] args) {
		
		// Creación de personas 
		Persona Juan = new Persona("Juan");
		Persona Ana = new Persona("Ana");
		
		// Creación de coches
		Coche coche1 = new Coche("Toyota", "Corolla", 2020, 4);
		Coche coche2 = new Coche("Honda", "Civic", 2021, 4);
		Coche coche3 = new Coche("Ford", "Focus", 2022, 4);
		
		// Creación de camiones
		Camion Camion1 = new Camion("Mercedes","Actros",2019,18);
		
		//Imprimir la varible estática perteneciente a la clase Vehiculo mostrando el número total de vehiculos
		System.out.println("El número total de vehiculos es: "+ Vehiculo.getContador());
		
		// Asignación de propietarios
		coche1.setPropietario(Juan);
		coche2.setPropietario(Ana);
		Camion1.setPropietario(Juan);
		
		// Imprimir la información del coche y el propietario
		System.out.println("Coche 1" + coche1.obtenerInformacion());
		System.out.println("Coche 2" + coche2.obtenerInformacion());
		System.out.println("Coche 3" + coche3.obtenerInformacion());
		System.out.println("Camion 1" + Camion1.obtenerInformacion());
		

		
	}

}
