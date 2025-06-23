import java.sql.Date;

public class Ejercicio6MAIN {

	public static void main(String[] args) {

		Administración Daniel = new Administración("1", "Daniel", "Baldazo Sánchez", "FP", 5, 2000);
		Administración Hugo = new Administración("2", "Hugo", "Jimenez", "FP", 2, 2000);

		Directivo Sergio = new Directivo("3", "Sergio", "Martinez", true, 'M', 1500);
		Directivo Mosta = new Directivo("4", "Sergio", "Mostacero", false, 'T', 1000);

		Profesor Victor = new Profesor("5", "Victor", "Sánchez", 3, true, 1700);
		Profesor Mariano = new Profesor("6", "Mariano", "Rajoy", 5, false, 5000);

		Modulo Matematicas = new Modulo("Matemáticas", 5, Victor, false);
		Modulo Geografía = new Modulo("Geografía", 5, Mariano, false);
		Modulo TIC = new Modulo("TIC", 3, Victor, true);
		Modulo Historia = new Modulo("Historia", 4, Mariano, false);

		Alumno Pepito = new Alumno("50", "Pepito", "Perez", "2003-04-28", 'H', false);
		Alumno Javier = new Alumno("51", "Javier", "González", "2005-02-22", 'H', false);
		Alumno Marta = new Alumno("52", "Marta", "Martinez", "2003-09-24", 'M', false);

		/*
		 * //Profesores System.out.println(Mariano.toString());
		 * System.out.println(Victor.toString());
		 * 
		 * // Directivos System.out.println(Sergio.toString());
		 * System.out.println(Mosta.toString());
		 * 
		 * // Administración System.out.println(Daniel.toString());
		 * System.out.println(Hugo.toString());
		 */

		Pepito.modulos.add(Geografía);
		Pepito.modulos.add(Historia);

		Marta.modulos.add(Historia);
		Marta.modulos.add(Matematicas);

		Javier.modulos.add(Matematicas);
		Javier.modulos.add(TIC);

		System.out.println(Pepito.toString());


	}

}
