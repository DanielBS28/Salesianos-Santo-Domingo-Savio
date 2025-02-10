package Mecanografía;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class EscribirTXT {

	public static void EscribirUsuarios(ArrayList<Usuario> USUARIOS) {

		Path fichero = Paths.get(Archivos.Usuarios);

		try {
			Files.writeString(fichero, "");
			for (int i = 0; i < USUARIOS.size(); i++) {

				Files.writeString(fichero, USUARIOS.get(i).getAlias() + "<通配符>", StandardOpenOption.APPEND);
				Files.writeString(fichero, USUARIOS.get(i).getNombre() + "<通配符>", StandardOpenOption.APPEND);
				Files.writeString(fichero, USUARIOS.get(i).getContrasena() + "<通配符>", StandardOpenOption.APPEND);
				Files.writeString(fichero, USUARIOS.get(i).getCorreo() + "\n", StandardOpenOption.APPEND);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void escribirTextos(String textoFácil, String textoDifícil) {
		Path fichero = Paths.get(Archivos.Textos);

		try {
			Files.writeString(fichero, textoFácil);
			Files.writeString(fichero, "<通配符>", StandardOpenOption.APPEND);
			Files.writeString(fichero, textoDifícil, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void EscribirEstadísticas(ArrayList<Estadísticas> ESTADÍSTICAS) {

		Path fichero = Paths.get(Archivos.Estadísticas);

		try {
			Files.writeString(fichero, "");
			for (int i = 0; i < ESTADÍSTICAS.size(); i++) {

				Files.writeString(fichero, ESTADÍSTICAS.get(i).getId() + "<通配符>", StandardOpenOption.APPEND);
				Files.writeString(fichero, ESTADÍSTICAS.get(i).getNotaFácil() + "<通配符>", StandardOpenOption.APPEND);
				Files.writeString(fichero, ESTADÍSTICAS.get(i).getAciertosTeclasF() + "<通配符>",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, ESTADÍSTICAS.get(i).getErroresTeclasF() + "<通配符>",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, ESTADÍSTICAS.get(i).getPPMF() + "<通配符>", StandardOpenOption.APPEND);
				Files.writeString(fichero, ESTADÍSTICAS.get(i).getSegundosRestantesF() + "<通配符>",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, ESTADÍSTICAS.get(i).getLetralDelTextoF() + "<通配符>",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, ESTADÍSTICAS.get(i).getTiempoTotalF() + "<通配符>", StandardOpenOption.APPEND);
				Files.writeString(fichero, ESTADÍSTICAS.get(i).getNotaDifícil() + "<通配符>", StandardOpenOption.APPEND);
				Files.writeString(fichero, ESTADÍSTICAS.get(i).getAciertosTeclasD() + "<通配符>",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, ESTADÍSTICAS.get(i).getErroresTeclasD() + "<通配符>",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, ESTADÍSTICAS.get(i).getPPMD() + "<通配符>", StandardOpenOption.APPEND);
				Files.writeString(fichero, ESTADÍSTICAS.get(i).getSegundosRestantesD() + "<通配符>",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, ESTADÍSTICAS.get(i).getLetralDelTextoD() + "<通配符>",
						StandardOpenOption.APPEND);
				Files.writeString(fichero, ESTADÍSTICAS.get(i).getTiempoTotalD() + "\n", StandardOpenOption.APPEND);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
