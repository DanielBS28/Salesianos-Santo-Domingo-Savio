package Mecanografía;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Archivos extends JPanel {

	final public static String Usuarios = "src/Mecanografía/ArchivosIniciales/Usuarios.txt";
	final public static String Estadísticas = "src/Mecanografía/ArchivosIniciales/Estadísticas.txt";
	final public static String Textos = "src/Mecanografía/ArchivosIniciales/Textos.txt";

	public static boolean escanearArchivos() {

		File ArchivoUsuarios = new File(Usuarios);
		File ArchivoEstadísticas = new File(Estadísticas);
		File ArchivoTextos = new File(Textos);

		if (ArchivoUsuarios.exists() && ArchivoEstadísticas.exists() && ArchivoTextos.exists()) {
			DatosTXT.cargarUsuarios();
			DatosTXT.cargarTextos();
			DatosTXT.cargarEstadísticas();
			return true;
		} else
			return false;
	}

	public static ArrayList<Usuario> leerUsuarios() {

		ArrayList<Usuario> USUARIOS = new ArrayList<>();

		String linea = "";

		String[] campos = { "ID", "Nombre", "Contraseña", "Correo" };
		try {
			BufferedReader fis = new BufferedReader(new FileReader(Usuarios));

			while ((linea = fis.readLine()) != null) {

				String[] lectura = linea.trim().split("<通配符>");

				if (lectura.length == campos.length) {
					if (EventoAgregarUsuario.esContraseñaValida(lectura[2])
							&& EventoAgregarUsuario.esCorreoValido(lectura[3])
							&& (!lectura[0].isBlank() && !lectura[1].isBlank() && !lectura[2].isBlank()&&
									!lectura[3].isBlank()))
						USUARIOS.add(new Usuario(lectura[0], lectura[1], lectura[2], lectura[3]));
				}

			}

			fis.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		eliminarAdministrador(USUARIOS);
		ajustarTamaño5(USUARIOS);
		eliminarDuplicados(USUARIOS);

		USUARIOS.add(0, new Usuario("a", "admin", "a", "practicasdanielbs@gmail.com"));

		EscribirTXT.EscribirUsuarios(USUARIOS);

		return USUARIOS;

	}

	private static void eliminarDuplicados(ArrayList<Usuario> USUARIOS) {
		HashSet<String> identificadoresUnicos = new HashSet<>();
		Iterator<Usuario> iterador = USUARIOS.iterator();

		while (iterador.hasNext()) {
			Usuario usuario = iterador.next();
			String clave = usuario.getAlias() + "-" + usuario.getCorreo(); // Clave única combinando ID y correo

			if (identificadoresUnicos.contains(clave)) {
				iterador.remove(); // Elimina el duplicado
			} else {
				identificadoresUnicos.add(clave); // Agrega al conjunto si es único
			}
		}
	}

	private static void ajustarTamaño5(ArrayList<Usuario> USUARIOS) {

		for (int i = USUARIOS.size() - 1; i >= 5; i--)
			USUARIOS.remove(i);
	}

	private static void eliminarAdministrador(ArrayList<Usuario> USUARIOS) {

		for (int i = USUARIOS.size() - 1; i >= 0; i--) {
			if (USUARIOS.get(i).getAlias().equals("a") || USUARIOS.get(i).getNombre().equals("admin")
					|| USUARIOS.get(i).getCorreo().equals("practicasdanielbs@gmail.com")) {
				USUARIOS.remove(i);
			}
		}
	}

	public static ArrayList<String> leerTextos() {

		ArrayList<String> TEXTOS = new ArrayList<>();

		String linea = "";

		try {
			BufferedReader fis = new BufferedReader(new FileReader(Textos));

			while ((linea = fis.readLine()) != null) {

				String[] lectura = linea.trim().split("<通配符>");
				if (lectura.length == 2) {
					if (!lectura[0].isBlank() && !lectura[1].isBlank()) {
						TEXTOS.add(lectura[0]);
						TEXTOS.add(lectura[1]);
					}
				}

			}

			fis.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return TEXTOS;

	}

	public static double obtenerNota(int segundosRestantes, int teclasPulsadas, int letrasDelTexto, int pPMinuto,
			int aciertosTeclas, int erroresTeclas, int tiempoTotal, char dificultad, Usuario user) {
		double Nota = 0;

		Nota = (aciertosTeclas * 10) / letrasDelTexto;
		Nota -= dificultad == '1' ? (erroresTeclas * 0.25) : (erroresTeclas * 0.5);
		Nota = Math.floor(Nota * 100) / 100;
		Nota = Nota >= 0 ? Nota : 0;

		if (comprobarRecord(Nota, user, dificultad)) {
			
			String correo = user.getCorreo();
			String asunto = "¡Enhorabuena has superado tu récord en la lección " + (dificultad == '1' ? "FÁCIL! " : "DIFÍCIL! ")
				+ "| Nota obtenida: " + Nota;
			String texto = "En la lección " + (dificultad == '1' ? "fácil " : "difícil ") + "tienes en total " +tiempoTotal + " segundos para completarla, y tiene"
					+ "un total de " + letrasDelTexto +" letras para teclar."
					+ "| A continuación se muestran las estadísticas de tu nuevo récord: "
					+ " | Aciertos: " + aciertosTeclas + "| Errores: " +erroresTeclas +" | PPM: " +pPMinuto +" | Tiempo usado: " 
					+ (tiempoTotal- segundosRestantes)+" segundos" + " | Nota: " + Nota;
					
			
			JOptionPane.showMessageDialog(null, "¡ENHORABUENA! HAS SUPERADO TU RÉCORD\n"
					+ "\nVamos a enviar un mensaje con tu nuevo récord y estadísticas a tu correo electrónico", "Enviando mensaje",
					JOptionPane.NO_OPTION);
			if(dificultad == '1') 
				DatosTXT.actualizarEstadísticasFácil(segundosRestantes, teclasPulsadas, letrasDelTexto, pPMinuto,
						 aciertosTeclas, erroresTeclas, tiempoTotal,dificultad,  user, Nota);
			else
				DatosTXT.actualizarEstadísticasDifícil(segundosRestantes, teclasPulsadas, letrasDelTexto, pPMinuto,
						 aciertosTeclas, erroresTeclas, tiempoTotal,dificultad,  user, Nota);
			
			EscribirTXT.EscribirEstadísticas(DatosTXT.getESTADÍSTICAS());
			EnviarEmail.crearEmail(correo, asunto, texto);
		}else
			JOptionPane.showMessageDialog(null, "No has superado tu récord, ¡vuelve a intentarlo en otra ocasión, lo conseguirás!", "No superaste tu récord",
					JOptionPane.NO_OPTION);
			
		return Nota;

	}

	private static boolean comprobarRecord(double nota, Usuario user, char dificultad) {

		ArrayList<Estadísticas> ESTADÍSTICAS = DatosTXT.getESTADÍSTICAS();

		for (int i = 0; i < ESTADÍSTICAS.size(); i++) {
			if (ESTADÍSTICAS.get(i).getId().equals(user.getAlias())) {
				if (dificultad == '1' && ESTADÍSTICAS.get(i).getNotaFácil() < nota)
					return true;
				else if (dificultad == '2' && ESTADÍSTICAS.get(i).getNotaDifícil() < nota)
					return true;
			}
		}
		return false;

	}

	public static ArrayList<Estadísticas> leerEstadísticas() {

		ArrayList<Estadísticas> ESTADÍSTICAS = new ArrayList<>();

		String linea = "";

		try {
			BufferedReader fis = new BufferedReader(new FileReader(Estadísticas));

			while ((linea = fis.readLine()) != null) {

				String[] lectura = linea.trim().split("<通配符>");
				if (lectura.length == 15) {
					if (!lectura[0].isBlank() && !lectura[1].isBlank() && !lectura[2].isBlank()
							 && !lectura[3].isBlank() && !lectura[4].isBlank() && !lectura[5].isBlank()
							 && !lectura[6].isBlank() && !lectura[7].isBlank() 
							 && !lectura[8].isBlank() && !lectura[9].isBlank()
							 && !lectura[10].isBlank() && !lectura[11].isBlank() && !lectura[12].isBlank()
							 && !lectura[13].isBlank() && !lectura[14].isBlank()) {
						try {
							ESTADÍSTICAS.add(new Estadísticas(lectura[0], Double.parseDouble(lectura[1]),
									Integer.parseInt(lectura[2]),Integer.parseInt(lectura[3])
									,Integer.parseInt(lectura[4]),Integer.parseInt(lectura[5])
									,Integer.parseInt(lectura[6]),Integer.parseInt(lectura[7]),
									Double.parseDouble(lectura[8]),Integer.parseInt(lectura[9]),
									Integer.parseInt(lectura[10]),Integer.parseInt(lectura[11]),
									Integer.parseInt(lectura[12]),
									Integer.parseInt(lectura[13]),Integer.parseInt(lectura[14])));
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,
									"Hubo un error al agregar las estadísticas del usuario cuyo ID es: " + lectura[0],
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					}

				}
			}

			fis.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		limpiarDatosEstadísticass(ESTADÍSTICAS);

		return ESTADÍSTICAS;
	}

	private static void limpiarDatosEstadísticass(ArrayList<Estadísticas> ESTADÍSTICAS) {

		ArrayList<Usuario> USUARIOS = DatosTXT.getUSUARIOS();

		for (int i = 1; i < USUARIOS.size(); i++) {

			boolean usuarioEncontrado = false;

			for (int j = 0; j < ESTADÍSTICAS.size(); j++) {
				if (USUARIOS.get(i).getAlias().equals(ESTADÍSTICAS.get(j).getId()))
					usuarioEncontrado = true;
			}

			if (!usuarioEncontrado)
				ESTADÍSTICAS.add(new Estadísticas(USUARIOS.get(i).getAlias(), 0, 0,0,0,0,0,0,0,0,0,0,0,0,0));
		}

		eliminarDatosSinUsuarios(USUARIOS, ESTADÍSTICAS);
		eliminarDuplicadosEstadísticas(ESTADÍSTICAS);
		EscribirTXT.EscribirEstadísticas(ESTADÍSTICAS);

	}

	private static void eliminarDuplicadosEstadísticas(ArrayList<Estadísticas> ESTADÍSTICAS) {
		HashSet<String> idsUnicos = new HashSet<>();
		Iterator<Estadísticas> iterador = ESTADÍSTICAS.iterator();

		while (iterador.hasNext()) {
			Estadísticas estadistica = iterador.next();
			String id = estadistica.getId(); // Asegúrate de que `getId()` es correcto

			if (idsUnicos.contains(id)) {
				iterador.remove(); // Elimina el duplicado
			} else {
				idsUnicos.add(id); // Agrega el ID único al conjunto
			}
		}
	}

	public static void eliminarDatosSinUsuarios(ArrayList<Usuario> USUARIOS, ArrayList<Estadísticas> ESTADÍSTICAS) {

		for (int i = ESTADÍSTICAS.size() - 1; i >= 0; i--) {

			boolean usuarioEncontrado = false;

			for (int j = 1; j < USUARIOS.size(); j++) {
				if (ESTADÍSTICAS.get(i).getId().equals(USUARIOS.get(j).getAlias()))
					usuarioEncontrado = true;
			}
			if (!usuarioEncontrado)
				ESTADÍSTICAS.remove(i);
		}

	}

}
