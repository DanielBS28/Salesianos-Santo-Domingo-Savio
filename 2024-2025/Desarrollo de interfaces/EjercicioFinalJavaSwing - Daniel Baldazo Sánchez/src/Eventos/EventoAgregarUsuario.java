package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Utilidades.*;
import ClasesArchivos.*;

public class EventoAgregarUsuario extends JPanel implements ActionListener {
	
	/**
	 * Esta clase es un evento que se encarga de agregar usuarios y comprobar que todos los 
	 * datos sean legibles
	 * **/

	private JTextField campoID;
	private JTextField campoContraseña;
	private JTextField campoNombre;
	private JTextField campoCorreo;
	private ArrayList<Usuario> USUARIOS = null;

	public EventoAgregarUsuario(JTextField campoID, JTextField campoContraseña, JTextField campoNombre,
			JTextField campoCorreo, ArrayList<Usuario> USUARIOS) {

		this.campoContraseña = campoContraseña;
		this.campoCorreo = campoCorreo;
		this.campoID = campoID;
		this.campoNombre = campoNombre;
		this.USUARIOS = USUARIOS;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		boolean ErrorEncontrado = false;

		String contraseña = campoContraseña.getText();
		String Correo = campoCorreo.getText();
		String ID = campoID.getText();
		String Nombre = campoNombre.getText();
		//Si hay algun campo vacío saltará un aviso y no se agregará el usuario
		if (contraseña.isBlank() || Correo.isBlank() || ID.isBlank() || Nombre.isBlank()) {
			JOptionPane.showMessageDialog(this,
					"Debes de llenar todos los campos, no puedes dejar campos en el formulario vacíos.", "Error",
					JOptionPane.ERROR_MESSAGE);
			ErrorEncontrado = true;
			// Si hay 6 o mas de 6 usuarios en el arraylist no se agregará el usuario
		} else if (USUARIOS.size() >= 6) {
			JOptionPane.showMessageDialog(this,
					"No se pudo agregar el usuario, el máximo de usuarios permitidos en la aplicación es 5.", "Error",
					JOptionPane.ERROR_MESSAGE);
			ErrorEncontrado = true;
			//Si en algún campo se incluye "<通配符>" no será valido ese campo, es una palabra reservada de la APP
		} else if (contraseña.contains("<通配符>") || Correo.contains("<通配符>") || ID.contains("<通配符>")
				|| Nombre.equals("<通配符>")) {
			JOptionPane.showMessageDialog(this,
					"No se pudo agregar el usuario, está prohibido usar la secuencia de carácteres \"<通配符>\" en cualquier campo", "Error",
					JOptionPane.ERROR_MESSAGE);
			ErrorEncontrado = true;
			//Si cualquier de las otras opciones no son verdaderas ya paso a recorrer el arraylist buscando mas fallos
		} else {
			for (int i = 0; i < USUARIOS.size() && !ErrorEncontrado; i++) {
				//Si el campo alias y el campo correo son iguales que los de un usuario del arraylist no lo guardo
				if (USUARIOS.get(i).getAlias().equals(ID) && USUARIOS.get(i).getCorreo().equals(Correo)) {
					JOptionPane.showMessageDialog(this,
							"No se puede agregar este usuario, ya existe otro usuario con el ID y correo que has introducido.",
							"Error", JOptionPane.ERROR_MESSAGE);
					ErrorEncontrado = true;
					//si el campo alias de un usuario del arraylist es igual que el ID del label introducido, no lo guardo el usuario
				} else if (USUARIOS.get(i).getAlias().equals(ID)) {
					JOptionPane.showMessageDialog(this,
							"No se puede agregar este usuario, ya existe otro usuario con el ID que has introducido.",
							"Error", JOptionPane.ERROR_MESSAGE);
					ErrorEncontrado = true;
					//si el campo correo de un usuario del arraylist es igual que el correo del label introducido, no lo guardo el usuario
				} else if (USUARIOS.get(i).getCorreo().equals(Correo)) {
					JOptionPane.showMessageDialog(this,
							"No se puede agregar este usuario, ya existe otro usuario con el correo que has introducido.",
							"Error", JOptionPane.ERROR_MESSAGE);
					ErrorEncontrado = true;
					//Si el correo introducido en el label no es válido, no guardo el usuario
				} else if (!esCorreoValido(Correo)) {
					JOptionPane.showMessageDialog(this,
							"El correo electrónico que has introducido no es un correo válido, vuelve a intentarlo por favor.",
							"Error", JOptionPane.ERROR_MESSAGE);
					ErrorEncontrado = true;
					//Si la contraseña no es válida, no guardo el usuario
				} else if (!esContraseñaValida(contraseña)) {
					JOptionPane.showMessageDialog(this,
							"La contraseña que has introducido no es válida, debe de tener 6 caracteres con mayúsculas, mínusculas y números, vuelve a intentarlo por favor.",
							"Error", JOptionPane.ERROR_MESSAGE);
					ErrorEncontrado = true;
				}
			}
		}
		//Si no se ha encontrado un error voy a guardar el usuario
		if (!ErrorEncontrado) {
			JOptionPane.showMessageDialog(this, "El usuario se ha agregado correctamente.", "Usuario agregado",
					JOptionPane.NO_OPTION);
			USUARIOS.add(new Usuario(ID, Nombre, contraseña, Correo));
			EscribirTXT.EscribirUsuarios(USUARIOS);
			DatosTXT.getESTADÍSTICAS().add(new Estadísticas(ID, 0,0,0,0,0,0,0,0,0,0,0,0,0,0));
			EscribirTXT.EscribirEstadísticas(DatosTXT.getESTADÍSTICAS());
			campoContraseña.setText("");
			campoCorreo.setText("");
			campoID.setText("");
			campoNombre.setText("");

		}
	}

	//función que comprueba si un correo es válido o no
	public static boolean esCorreoValido(String correo) {

		String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

		Pattern expresión = Pattern.compile(regex);
		Matcher coincide = expresión.matcher(correo);

		return coincide.matches();
	}
	
	//función que comprueba si una contraseña es válida o no
	public static boolean esContraseñaValida(String contraseña) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$";

		Pattern expresión = Pattern.compile(regex);
		Matcher coincide = expresión.matcher(contraseña);

		return coincide.matches();
	}

}
