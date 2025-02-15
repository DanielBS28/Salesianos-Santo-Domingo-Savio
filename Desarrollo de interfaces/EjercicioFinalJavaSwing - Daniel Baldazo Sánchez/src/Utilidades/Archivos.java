package Utilidades;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import ClasesArchivos.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Eventos.EventoAgregarUsuario;

public class Archivos extends JPanel {
	
	/*
	 * Esta clase es esencial en mi aplicación se encarga de gestionar todos los datos de los archivos
	 * tanto comprobar que los datos son legibles, de tener las rutas de los archivos, de ajustar los arrays para
	 * evitar que haya más datos de los requeridos o que haya datos duplicados etc.
	 */

	//Estas son las rutas de los archivos
	final public static String Usuarios = "src/Mecanografía/ArchivosIniciales/Usuarios.txt";
	final public static String Estadísticas = "src/Mecanografía/ArchivosIniciales/Estadísticas.txt";
	final public static String Textos = "src/Mecanografía/ArchivosIniciales/Textos.txt";

	public static boolean escanearArchivos() {

		/*
		 * Esta clase se encarga de comprobar que los 3 archivos iniciales existen. Si existen la aplicación
		 * continuará con su flujo sino la aplicación mostrará una ventana emergente y la aplicación se cerrará.
		 */
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
		
		/*
		 * Esta función se encarga de dar una primera lectura de los datos de los usuarios y comprueba que haya
		 * 4 campos que son el ID, nombre, contraseña y correo. Se hacen mas comprobaciones extra para que los datos
		 * sean legibles y también que se cumplan los requisitos de la aplicación (No más de 5 usuarios y que haya
		 * un administrador) tampoco habrá datos duplicados. 
		 */

		ArrayList<Usuario> USUARIOS = new ArrayList<>();

		String linea = "";

		String[] campos = { "ID", "Nombre", "Contraseña", "Correo" };
		try {
			BufferedReader fis = new BufferedReader(new FileReader(Usuarios));

			while ((linea = fis.readLine()) != null) {

				String[] lectura = linea.trim().split("<通配符>");			
				/*
				 * Se hace un split para separar los campos y a continuación si hay 4 campos añado 
				 * ese usuario al ArrayList pero tiene tres medidas mas de seguridad para comprobar los datos
				 * que son: comprobar que el correo del usuario leído se un correo que cumpla la sintaxis de un correo
				 * electrónico, que la contraseña sea una contraseña válida de 6 carácteres con minúsculas, mayúsculas
				 * y números. Y por último que el campo no esté vacio. Si se ha cumplido todo esto añadiré el usuario
				 * al ArrayList de usuarios
				 */
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
		
		//Elimino al administrador para asegurarme de que en este momento no haya administradores
		eliminarAdministrador(USUARIOS);
		//Ajusto el tamaño del arrayList a 5 usuarios
		ajustarTamaño5(USUARIOS);
		//Elimino usuarios duplicados que tengan el mismo ID o mismo correo, no puede haber datos duplicados
		eliminarDuplicados(USUARIOS);

		//Una vez tengo ya los datos correctos procedo a añadir al usuario administrador en la posición cero del 
		//arraylist, ya me he asegurado antes de que no haya administrador.
		USUARIOS.add(0, new Usuario("a", "admin", "a", "practicasdanielbs@gmail.com"));

		//Una vez que tengo todos los datos correctos procedo a escribirlos en el TXT de usuarios.
		EscribirTXT.EscribirUsuarios(USUARIOS);

		return USUARIOS;

	}

	private static void eliminarDuplicados(ArrayList<Usuario> USUARIOS) {

	    /*
	     * Esta función se encarga de eliminar usuarios duplicados que tengan el mismo ID
	     * o el mismo correo.
	     */

	    HashSet<String> identificadoresUnicos = new HashSet<>();
	    HashSet<String> correosUnicos = new HashSet<>();

	    Iterator<Usuario> iterador = USUARIOS.iterator();

	    while (iterador.hasNext()) {

	        Usuario usuario = iterador.next();
	        String id = usuario.getAlias();     // ID del usuario
	        String correo = usuario.getCorreo(); // Correo del usuario

	        // Verifica si el ID o el correo ya existen en los conjuntos de identificadores/correos únicos

	        if (identificadoresUnicos.contains(id) || correosUnicos.contains(correo)) {

	            iterador.remove(); // Elimina el duplicado

	        } else {

	            identificadoresUnicos.add(id);   // Agrega el ID al conjunto de identificadores únicos
	            correosUnicos.add(correo);       // Agrega el correo al conjunto de correos únicos
	        }
	    }
	}

	private static void ajustarTamaño5(ArrayList<Usuario> USUARIOS) {
		
		//Está función elimina usuarios para que solo haya 5 en la APP 
		for (int i = USUARIOS.size() - 1; i >= 5; i--)
			USUARIOS.remove(i);
	}

	private static void eliminarAdministrador(ArrayList<Usuario> USUARIOS) {

		//Esta función itera sobre el arraylist de usuarios buscando cualquier coincidencia con los datos
		// del administrador, si hay algo que coincide con los datos del administrador ese usuario se elimina.
		for (int i = USUARIOS.size() - 1; i >= 0; i--) {
			if (USUARIOS.get(i).getAlias().equals("a") || USUARIOS.get(i).getCorreo().equals("practicasdanielbs@gmail.com")) {
				USUARIOS.remove(i);
			}
		}
	}

	public static ArrayList<String> leerTextos() {
		
		/*
		 * Esta función es la encargada de dar la primera lectura a los textos, verificar que hay dos textos
		 * y que no estén vacíos.
		 */

		ArrayList<String> TEXTOS = new ArrayList<>();

		String linea = "";

		try {
			BufferedReader fis = new BufferedReader(new FileReader(Textos));

			while ((linea = fis.readLine()) != null) {

				String[] lectura = linea.trim().split("<通配符>");
				
				/*
				 * Si el tamaño del array de String obtenido al hacer el split es dos y los textos no están
				 * vacíos los añado al arraylist de textos.
				 */
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
		
		/*
		 * Esta función se encarga de obtener la nota de la lección que ha jugado un usuario además se encarga de 
		 * comprobar si ha superado el récord e informar al usuario y finalmente 
		 * actualizar y escribir la estadísticas en caso de que el usuario las haya superado
		 */
		Nota = (aciertosTeclas * 10) / letrasDelTexto;
		Nota -= dificultad == '1' ? (erroresTeclas * 0.15) : (erroresTeclas * 0.33);
		Nota = Math.floor(Nota * 100) / 100;
		Nota = Nota >= 0 ? Nota : 0;

		if (comprobarRecord(Nota, user, dificultad)) {
			
			//Si se ha superado el récord aviso al usuario por ventana emergente, actualizo y escribo sus estadísticas
			// y le envío un correo.
			String correo = user.getCorreo();
			String asunto = "¡Enhorabuena has superado tu récord en la lección " + (dificultad == '1' ? "fácil! " : "difícil! ")
				+ "| Nota obtenida: " + Nota;
			String texto = "En la lección " + (dificultad == '1' ? "fácil " : "difícil ") + "tienes en total " +tiempoTotal + " segundos para completarla, y tiene"
					+ " un total de " + (letrasDelTexto+1) +" letras para teclear."
					+ " A continuación se muestran las estadísticas de tu nuevo récord: "
					+ " Aciertos: " + aciertosTeclas + " | Errores: " +erroresTeclas +" | PPM: " +pPMinuto +" | Tiempo usado: " 
					+ (tiempoTotal- segundosRestantes)+" segundos" + " | Tiempo restante: "+segundosRestantes+" segundos | Nota: " + Nota;
					
			
			JOptionPane.showMessageDialog(null, "¡ENHORABUENA! HAS SUPERADO TU RÉCORD\n"
					+ "\nVamos a enviar un mensaje con tu nuevo récord y estadísticas a tu correo electrónico", "Enviando mensaje",
					JOptionPane.NO_OPTION);
			if(dificultad == '1') 
				DatosTXT.actualizarEstadísticasFácil(segundosRestantes, teclasPulsadas, letrasDelTexto+1, pPMinuto,
						 aciertosTeclas, erroresTeclas, tiempoTotal,dificultad,  user, Nota);
			else
				DatosTXT.actualizarEstadísticasDifícil(segundosRestantes, teclasPulsadas, letrasDelTexto+1, pPMinuto,
						 aciertosTeclas, erroresTeclas, tiempoTotal,dificultad,  user, Nota);
			
			EscribirTXT.EscribirEstadísticas(DatosTXT.getESTADÍSTICAS());
			EnviarEmail.crearEmail(correo, asunto, texto);
		}else
			JOptionPane.showMessageDialog(null, "No has superado tu récord, ¡vuelve a intentarlo en otra ocasión, lo conseguirás!", "No superaste tu récord",
					JOptionPane.NO_OPTION);
			
		return Nota;

	}

	private static boolean comprobarRecord(double nota, Usuario user, char dificultad) {

		/*
		 * Esta función se encarga de comprobar la nota de la lección fácil o difícil (lo sabemos por el char
		 * dificultad) si es mayor la nota pasada devolverá true, si no devolverá false.
		 */
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
		
		/*
		 * Esta función se encarga de comprobar los datos del txt estadísticas y se van a ir haciendo filtros
		 * para que los datos sean correctos y que no estén vacios
		 */

		ArrayList<Estadísticas> ESTADÍSTICAS = new ArrayList<>();

		String linea = "";

		try {
			BufferedReader fis = new BufferedReader(new FileReader(Estadísticas));

			while ((linea = fis.readLine()) != null) {

				String[] lectura = linea.trim().split("<通配符>");
				
				//Si el array de lectura es igual a 15 y los datos no están vacios compruebo los campos
				if (lectura.length == 15) {
					if (!lectura[0].isBlank() && !lectura[1].isBlank() && !lectura[2].isBlank()
							 && !lectura[3].isBlank() && !lectura[4].isBlank() && !lectura[5].isBlank()
							 && !lectura[6].isBlank() && !lectura[7].isBlank() 
							 && !lectura[8].isBlank() && !lectura[9].isBlank()
							 && !lectura[10].isBlank() && !lectura[11].isBlank() && !lectura[12].isBlank()
							 && !lectura[13].isBlank() && !lectura[14].isBlank()) {
						try {
							//Intento añadir los campos al arraylist de estadísticas, si uno falla no se va a agregar
							//al arraylist de estadísticas y además saldrá una ventana emergente avisando al usuario
							// de que hubo un error al cargar ese dato en el usuario correspondiente
							ESTADÍSTICAS.add(new Estadísticas(lectura[0], Double.parseDouble(lectura[1]),
									Integer.parseInt(lectura[2]),Integer.parseInt(lectura[3])
									,Integer.parseInt(lectura[4]),Integer.parseInt(lectura[5])
									,Integer.parseInt(lectura[6]),Integer.parseInt(lectura[7]),
									Double.parseDouble(lectura[8]),Integer.parseInt(lectura[9])
									,Integer.parseInt(lectura[10]),Integer.parseInt(lectura[11]),
									Integer.parseInt(lectura[12]),Integer.parseInt(lectura[13]),
									Integer.parseInt(lectura[14])));
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

		limpiarDatosEstadísticas(ESTADÍSTICAS);

		return ESTADÍSTICAS;
	}

	private static void limpiarDatosEstadísticas(ArrayList<Estadísticas> ESTADÍSTICAS) {
		
		/*
		 * Esta función se encarga de comprobar si un usuario existente en el arraylist de usuarios
		 * no tiene estadísticas, si un usuario del arraylist no tiene estadísticas voy a crearle una estadística
		 * nueva. También se encarga de eliminar datos de estadísticas que no tengan un usuario por id asignado
		 * y también elimino estadísticas duplicadas
		 */

		ArrayList<Usuario> USUARIOS = DatosTXT.getUSUARIOS();

		for (int i = 1; i < USUARIOS.size(); i++) {

			boolean usuarioEncontrado = false;

			//Compruebo si el usuario iterado está en el arraylist de estadísticas, si está
			// pongo la variable usuario encontrado a true para indicar que se ha encontrado un usuario
			for (int j = 0; j < ESTADÍSTICAS.size(); j++) {
				if (USUARIOS.get(i).getAlias().equals(ESTADÍSTICAS.get(j).getId()))
					usuarioEncontrado = true;
			}

			//Si no se ha encontrado el usuario en el arraylist de estadísticas,
			// voy a añadir una estadística nueva con el id del usuario iterado
			if (!usuarioEncontrado)
				ESTADÍSTICAS.add(new Estadísticas(USUARIOS.get(i).getAlias(), 0,0,0, 0,0,0,0,0,0,0,0,0,0,0));
		}

		//Una vez que ya tengo los datos bien filtrados, vuelvo a dar una vuelta de seguridad para comprobar
		// que los datos sean iguales en el arraylist de usuarios y estadísticas.
		eliminarDatosSinUsuarios(USUARIOS, ESTADÍSTICAS);
		//Compruebo que no haya duplicados
		eliminarDuplicadosEstadísticas(ESTADÍSTICAS);
		//Cuando los datos sean correctos finalmente escribo en el arraylist de estadísticas los datos correctos
		EscribirTXT.EscribirEstadísticas(ESTADÍSTICAS);

	}

	private static void eliminarDuplicadosEstadísticas(ArrayList<Estadísticas> ESTADÍSTICAS) {
		
		/*
		 * Esta función se encarga de eliminar estadísticas duplicadas filtrando por el 
		 * id del usuario
		 */
		HashSet<String> idsUnicos = new HashSet<>();
		Iterator<Estadísticas> iterador = ESTADÍSTICAS.iterator();

		while (iterador.hasNext()) {
			Estadísticas estadistica = iterador.next();
			String id = estadistica.getId(); // Me guardo el ID iterado en la variable tipo String id

			if (idsUnicos.contains(id)) {
				iterador.remove(); // Elimina el duplicado
			} else {
				idsUnicos.add(id); // Agrega el ID único al hashset de ids únicos
			}
		}
	}

	public static void eliminarDatosSinUsuarios(ArrayList<Usuario> USUARIOS, ArrayList<Estadísticas> ESTADÍSTICAS) {

		/*
		 * Esta función se encarga de comprobar si un usuario que está dado de alta en estadísticas existe
		 * en el arraylist de usuarios (filtramos por su id), si existe no pasa nada, pero si no existe se elimina del 
		 * array list de estadísticas. Está función es útil por si se cambian los datos de forma manual del txt
		 * de estadísticas o se ha eliminado un usuario de forma normal.
		 */
		for (int i = ESTADÍSTICAS.size() - 1; i >= 0; i--) {

			boolean usuarioEncontrado = false;

			for (int j = 1; j < USUARIOS.size(); j++) {
				//Si el ID se ha encontrado en cualquier iteración de usuarios
				//usuario encontrado ess true y no se va a eliminar de estadísticas.
				if (ESTADÍSTICAS.get(i).getId().equals(USUARIOS.get(j).getAlias()))
					usuarioEncontrado = true;
			}
			//Si no se ha encontrado el usuario en cualquier iteración del arraylist de usuarios
			// esa estadística se elimina por que no le pertence a ningún usuario
			if (!usuarioEncontrado)
				ESTADÍSTICAS.remove(i);
		}

	}

}
